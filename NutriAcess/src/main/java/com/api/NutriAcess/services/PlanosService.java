package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.PlanosDto;
import com.api.NutriAcess.models.FormularioModel;
import com.api.NutriAcess.models.PlanosModel;
import com.api.NutriAcess.repositories.PlanosRepository;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Transactional
    public void delete(PlanosModel planosModel) {
        planosRepository.delete(planosModel);
    }

    public Page<PlanosModel> findAll(Pageable pageable) {
        return planosRepository.findAll(pageable);
    }

  public ResponseEntity<Object> validarPlanos(PlanosDto planosDto) {
    

    return null;

  }

}