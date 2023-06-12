package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.FaleConoscoDtos;
import com.api.NutriAcess.models.FaleConoscoModel;
import com.api.NutriAcess.models.PlanosModel;
import com.api.NutriAcess.services.FaleConoscoService;
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
@RequestMapping("/fale-conosco")
public class FaleConoscoController {

    // Injenção de dependência
    final FaleConoscoService faleConoscoService;

    public FaleConoscoController(FaleConoscoService faleConoscoService) {
        this.faleConoscoService = faleConoscoService;
    }


    @PostMapping("/criar")
    public ResponseEntity<Object> postfaleconosco(@RequestBody @Valid FaleConoscoDtos faleConoscoDtos,BindingResult bindingResult) {

        ResponseEntity<Object> validationResult = faleConoscoService.validarFaleConosco(faleConoscoDtos);

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
            FaleConoscoModel faleConoscoModel = faleConoscoDtos.parseToEntity();
            return ResponseEntity.status(HttpStatus.CREATED).body(faleConoscoService.save(faleConoscoModel));
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFaleConosco(@PathVariable(value = "id") UUID id) {
        Optional<FaleConoscoModel> faleConoscoModelOptional = faleConoscoService.findById(id);
        if (!faleConoscoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Formulário fale conosco não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(faleConoscoModelOptional.get());
    }
    
    @GetMapping
    public ResponseEntity<Page<FaleConoscoModel>> getAllFaleConosco(
            @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.status(HttpStatus.OK).body(faleConoscoService.findAll(pageable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteFaleConosco(@PathVariable(value = "id") UUID id) {
        Optional<FaleConoscoModel> faleConoscoModelOptional = faleConoscoService.findById(id);
        if (!faleConoscoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado dados desse formulário fale conosco.");
        }
        faleConoscoService.delete(faleConoscoModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso.");
    }


}
