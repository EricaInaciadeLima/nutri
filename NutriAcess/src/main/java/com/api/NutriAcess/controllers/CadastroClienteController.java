package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.CadastroClienteDto;
import com.api.NutriAcess.models.CadastroClienteModel;
import com.api.NutriAcess.services.CadastroClienteService;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class CadastroClienteController {
    // Injenção de dependência
    final CadastroClienteService cadastroClienteService;

    public CadastroClienteController(CadastroClienteService cadastroClienteService) {
        this.cadastroClienteService = cadastroClienteService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Object> cadastrarCliente(@RequestBody @Valid CadastroClienteDto cadastroClienteDto,
            BindingResult bindingResult) {
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
    @GetMapping("/{id}")
    public ResponseEntity<Object> getCliente(@PathVariable(value = "id") UUID id) {
        Optional<CadastroClienteModel> cadastroClienteModelOptional = cadastroClienteService.findById(id);
        if (!cadastroClienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadastroClienteModelOptional.get());
    }
    
    @GetMapping
    public ResponseEntity<Page<CadastroClienteModel>> getAllCliente(
            @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(cadastroClienteService.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteCliente(@PathVariable(value = "id") UUID id) {
        Optional<CadastroClienteModel> cadastroClienteModelOptional = cadastroClienteService.findById(id);
        if (!cadastroClienteModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado dados desse cliente.");
        }
        cadastroClienteService.delete(cadastroClienteModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso.");
    }
}
