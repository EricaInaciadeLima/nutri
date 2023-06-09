package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.CadastroClienteDto;
import com.api.NutriAcess.models.CadastroClienteModel;
import com.api.NutriAcess.services.CadastroClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
import java.util.UUID;

@RestController
public class CadastroClienteController {
    // Injenção de dependência
    final CadastroClienteService cadastroClienteService;

    public CadastroClienteController(CadastroClienteService cadastroClienteService) {
        this.cadastroClienteService = cadastroClienteService;
    }

    @PostMapping("/cadastrar/cliente")
    public ResponseEntity<Object> cadastrarCliente(@RequestBody @Valid CadastroClienteDto cadastroClienteDto, BindingResult bindingResult) {

        try {
            //Conexão com a camada service e dto.
            ResponseEntity<Object> validationResult = cadastroClienteService.validarCadastroCliente(cadastroClienteDto);

            if (validationResult != null) {
                return validationResult;
            }

            if (bindingResult.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.toString());
            }

            CadastroClienteModel cadastroClienteModel = cadastroClienteDto.parseToEntity();

            return ResponseEntity.status(HttpStatus.CREATED).body(cadastroClienteService.save(cadastroClienteModel));

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/cadastro/{id}")
    public ResponseEntity<Object> getCadastro(@PathVariable(value = "id") UUID id) {
        Optional<CadastroClienteModel> cadastroClienteModelOptional = cadastroClienteService.findById(id);
        if (!cadastroClienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadastroClienteModelOptional.get());
    }
}
