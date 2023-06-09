package com.api.NutriAcess.controllers;

import com.api.NutriAcess.dtos.ConsultaDto;
import com.api.NutriAcess.dtos.PlanosDto;
import com.api.NutriAcess.models.ConsultaModel;
import com.api.NutriAcess.models.PlanosModel;
import com.api.NutriAcess.services.ConsultaService;
import com.api.NutriAcess.services.PlanosService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
public class PlanosController  {

    //injeção de dependencias.

    final PlanosService planosService;

    public PlanosController(PlanosService planosService) {
        this.planosService = planosService;
    }

    @PostMapping("/planos")
    public ResponseEntity<Object> planos(@RequestBody @Valid PlanosDto planosDto, BindingResult bindingResult) {

        try {
            //Conexão com a camada service e dto.
            ResponseEntity<Object> validationResult = planosService.validarPlanos(planosDto);

            if (validationResult != null) {
                return validationResult;
            }

            if (bindingResult.hasErrors()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(bindingResult.toString());
            }

            PlanosModel planosModel = planosDto.parseToEntity();

            return ResponseEntity.status(HttpStatus.CREATED).body(planosService.save(planosModel));

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        }
    }

    @GetMapping("/planos/{id}")
    public ResponseEntity<Object> getPlanos(@PathVariable(value = "id") UUID id) {
        Optional<PlanosModel> planosModelOptional = planosService.findById(id);
        if (!planosModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Planos: 'PLUS', 'PREMIUM', 'FAMILIA' ");
        }
        return ResponseEntity.status(HttpStatus.OK).body(planosModelOptional.get());
    }








}
