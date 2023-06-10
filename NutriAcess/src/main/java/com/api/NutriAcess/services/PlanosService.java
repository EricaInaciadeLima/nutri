package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.PlanosDto;
import com.api.NutriAcess.models.PlanosModel;
import com.api.NutriAcess.repositories.PlanosRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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
    
    PlanosModel.Tipo tipo = planosDto.getTipo();
    if (tipo != PlanosModel.Tipo.PLUS && tipo != PlanosModel.Tipo.FAMILIA && tipo != PlanosModel.Tipo.PREMIUM) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O tipo fornecido é inválido.");
    }
    if(planosDto.getDuracao() == null  || planosDto.getDuracao().isEmpty()){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo duração não pode ficar vazio!");
    }

    if (planosDto.getDescricao() == null || planosDto.getDescricao().isEmpty()) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo descrição não pode ficar vazio!");
    }

    if (planosDto.getValor() == null || planosDto.getValor().compareTo(BigDecimal.ZERO) <= 0) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O valor fornecido é inválido.");
    }

    return null;

  }

}