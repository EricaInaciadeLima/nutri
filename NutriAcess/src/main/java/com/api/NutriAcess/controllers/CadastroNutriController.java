package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.CadastroNutriDto;
import com.api.NutriAcess.models.CadastroNutriModel;
import com.api.NutriAcess.services.CadastroNutriService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class CadastroNutriController {

    // Injenção de dependência
    final CadastroNutriService cadastroNutriService;

    public CadastroNutriController (CadastroNutriService cadastroNutriService) {
        this.cadastroNutriService = cadastroNutriService;
    }

    @PostMapping("/cadastrar/nutricionista")
    public ResponseEntity<Object> cadastrarNutri(@RequestBody @Valid CadastroNutriDto cadastroNutriDto, BindingResult bindingResult) {

        try {
            //Conexão com a camada service e dto.
            ResponseEntity<Object> validationResult = cadastroNutriService.validarCadastroNutri(cadastroNutriDto);

            if (validationResult != null) {
                return validationResult;
            }

            if (bindingResult.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.toString());
            }

            CadastroNutriModel cadastroNutriModel = cadastroNutriDto.parseToEntity();

            return ResponseEntity.status(HttpStatus.CREATED).body(cadastroNutriService.save(cadastroNutriModel));

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/cadastro/{id_nutri}")
    public ResponseEntity<Object> getCadastro(@PathVariable(value = "id") UUID id) {
        Optional<CadastroNutriModel> cadastroNutriModelOptional = cadastroNutriService.findById(id);
        if (!cadastroNutriModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cadastro não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadastroNutriModelOptional.get());
    }
}
