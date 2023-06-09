package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.FormularioDto;
import com.api.NutriAcess.dtos.PlanosDto;
import com.api.NutriAcess.models.FormularioModel;
import com.api.NutriAcess.models.PlanosModel;
import com.api.NutriAcess.repositories.FormularioRepository;
import com.api.NutriAcess.repositories.PlanosRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PlanosService {

    private final PlanosRepository planosRepository;

    public PlanosService(PlanosRepository planosRepository) {
        this.planosRepository = planosRepository;
    }

    @Transactional
    public PlanosModel save(PlanosModel planosModel) {
        return planosRepository.save(planosModel);
    }

    //Vai retornar uma lista de todos registros.
    public Optional<PlanosModel> findById(UUID id) {
        return planosRepository.findById(id);
    }

    public ResponseEntity<Object> validarPlanos(PlanosDto planosDto) {

       /* if (planosDto.getTipo() == null || planosDto.getTipo()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Insira alguns desses planos: 'PLUS', 'PREMIUM', 'FAMILIA'");
        } */

        if (planosDto.getDataInicio() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data de inicio da assinatura");
        }

        if (planosDto.getDataTermino() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data de termino da assinatura");
        }

        if ( planosDto.getDescricao() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("descrição invalida");
        }

        if (planosDto.getValor() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Valor");
        }
        return null;
    }

}