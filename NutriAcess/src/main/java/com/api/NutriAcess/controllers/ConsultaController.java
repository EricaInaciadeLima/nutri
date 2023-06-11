package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.ConsultaDto;
import com.api.NutriAcess.models.ConsultaModel;
import com.api.NutriAcess.services.ConsultaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class ConsultaController {
    // Injenção de dependência
    final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @PostMapping("/consulta/criar")
    public ResponseEntity<Object> consulta(@RequestBody @Valid ConsultaDto consultaDto, BindingResult bindingResult) {
        // Conexão com a camada service e dto.
        ResponseEntity<Object> validationResult = consultaService.validarConsulta(consultaDto);

        if (validationResult != null) {
            return validationResult;
        }

        if (bindingResult.hasErrors()) {
            StringBuilder errorMessage = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errorMessage.append(error.getDefaultMessage()).append("\n");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString().trim());
        }
        try {
            ConsultaModel consultaModel = consultaDto.parseToEntity();

            return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consultaModel));

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/consulta/{id}")
    public ResponseEntity<Object> getConsulta(@PathVariable(value = "id") UUID id) {
        Optional<ConsultaModel> consultaModelOptional = consultaService.findById(id);
        if (!consultaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Consulta não marcada.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(consultaModelOptional.get());
    }
}
