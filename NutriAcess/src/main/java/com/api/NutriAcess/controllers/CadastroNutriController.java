package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.CadastroNutriDto;
import com.api.NutriAcess.models.CadastroNutriModel;
import com.api.NutriAcess.models.ConsultaModel;
import com.api.NutriAcess.services.CadastroNutriService;
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

     @GetMapping("/{id}")
    public ResponseEntity<Object> getNutricionista(@PathVariable(value = "id") UUID id) {
        Optional<CadastroNutriModel> cadastroNutriModelOptional = cadastroNutriService.findById(id);
        if (!cadastroNutriModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nutricionista não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cadastroNutriModelOptional.get());
    }
    
    @GetMapping
    public ResponseEntity<Page<CadastroNutriModel>> getAllNutricionista(
            @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(cadastroNutriService.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNutricionista(@PathVariable(value = "id") UUID id) {
        Optional<CadastroNutriModel> cadastroNutriModelOptional = cadastroNutriService.findById(id);
        if (!cadastroNutriModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado dados desse nutricionista.");
        }
        cadastroNutriService.delete(cadastroNutriModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso.");
    }

}
