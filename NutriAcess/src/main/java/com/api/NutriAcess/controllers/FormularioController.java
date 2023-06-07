package com.api.NutriAcess.controllers;


import com.api.NutriAcess.dtos.FormularioDto;
import com.api.NutriAcess.models.FormularioModel;
import com.api.NutriAcess.services.FormularioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class FormularioController {
    // Injenção de dependência
    final FormularioService formularioService;

    public FormularioController(FormularioService formularioService) {
        this.formularioService = formularioService;
    }

    @PostMapping("/formulario")
    public ResponseEntity<Object> postFormulario(@RequestBody @Valid FormularioDto formularioDto, BindingResult bindingResult) {

        ResponseEntity<Object> validationResult = formularioService.validarFormulario(formularioDto);

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
            FormularioModel formularioModel = formularioDto.parseToEntity();
            return ResponseEntity.status(HttpStatus.CREATED).body(formularioService.save(formularioModel));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/formulario/{id}")
    public ResponseEntity<Object> getFormulario(@PathVariable(value = "id") UUID id) {
        Optional<FormularioModel> formularioModelOptional = formularioService.findById(id);
        if (!formularioModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formulário não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(formularioModelOptional.get());
    }
}
