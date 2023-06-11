package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.PlanosDto;
import com.api.NutriAcess.models.PlanosModel;
import com.api.NutriAcess.services.PlanosService;
import jakarta.validation.Valid;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/plano")
public class PlanosController {
    // injeção de dependencias.
    final PlanosService planosService;

    public PlanosController(PlanosService planosService) {
        this.planosService = planosService;
    }

    @PostMapping("/criar")
    public ResponseEntity<Object> planos(@RequestBody @Valid PlanosDto planosDto,
    BindingResult bindingResult) {

    ResponseEntity<Object> validationResult =
    planosService.validarPlanos(planosDto);

    if (validationResult != null) {
    return validationResult;
    }

    if (bindingResult.hasErrors()) {
    StringBuilder errorMessage = new StringBuilder();
    for (FieldError error : bindingResult.getFieldErrors()) {
    errorMessage.append(error.getDefaultMessage()).append("\n");
    }
    return
    ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString().trim());
    }

    try {
    PlanosModel planosModel = planosDto.parseToEntity();
    return
    ResponseEntity.status(HttpStatus.CREATED).body(planosService.save(planosModel));

    } catch (Exception exception) {
    return
    ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
    }
 

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPlanos(@PathVariable(value = "id") UUID id) {
        Optional<PlanosModel> planosModelOptional = planosService.findById(id);
        if (!planosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Plano não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(planosModelOptional.get());
    }

}
