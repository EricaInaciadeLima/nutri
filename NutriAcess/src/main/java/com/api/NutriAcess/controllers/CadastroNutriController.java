package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.CadastroNutriDto;
import com.api.NutriAcess.models.CadastroNutriModel;
import com.api.NutriAcess.services.CadastroNutriService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/nutricionista")
public class CadastroNutriController {

    // Injenção de dependência
    final CadastroNutriService cadastroNutriService;

    public CadastroNutriController(CadastroNutriService cadastroNutriService) {
        this.cadastroNutriService = cadastroNutriService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarNutri(@RequestBody @Valid CadastroNutriDto cadastroNutriDto,
            BindingResult bindingResult) {
        ResponseEntity<Object> validationResult = cadastroNutriService.validarCadastroNutri(cadastroNutriDto);

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

            CadastroNutriModel cadastroNutriModel = cadastroNutriDto.parseToEntity();

            return ResponseEntity.status(HttpStatus.CREATED).body(cadastroNutriService.save(cadastroNutriModel));

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

}
