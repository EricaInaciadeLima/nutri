package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.CadastroClienteDto;
import com.api.NutriAcess.models.CadastroClienteModel;
import com.api.NutriAcess.services.CadastroClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class CadastroClienteController {
    // Injenção de dependência
    final CadastroClienteService cadastroClienteService;

    public CadastroClienteController(CadastroClienteService cadastroClienteService) {
        this.cadastroClienteService = cadastroClienteService;
    }

    @PostMapping("/cadastrar/cliente")
    public ResponseEntity<Object> cadastrarCliente(@RequestBody @Valid CadastroClienteDto cadastroClienteDto, BindingResult bindingResult) {
        ResponseEntity<Object> validationResult = cadastroClienteService.validarCadastroCliente(cadastroClienteDto);
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

            CadastroClienteModel cadastroClienteModel = cadastroClienteDto.parseToEntity();

            return ResponseEntity.status(HttpStatus.CREATED).body(cadastroClienteService.save(cadastroClienteModel));

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    }
