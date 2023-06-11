package com.api.NutriAcess.services;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.NutriAcess.models.FamiliaModel;
import com.api.NutriAcess.repositories.FamiliaRepository;

import jakarta.transaction.Transactional;

@Service
public class FamiliaService {
  
    private final FamiliaRepository familiaRepository;

    public FamiliaService(FamiliaRepository familiaRepository) {
        this.familiaRepository = familiaRepository;
    }

    @Transactional
    public FamiliaModel save(FamiliaModel familiaModel) {
        return familiaRepository.save(familiaModel);
    }

    @Transactional
    public void delete(FamiliaModel familiaModel) {
        familiaRepository.delete(familiaModel);
    }
    public Optional<FamiliaModel> findById(UUID id) {
        return familiaRepository.findById(id);
    }

    public Page<FamiliaModel> findAll(Pageable pageable) {
        return familiaRepository.findAll(pageable);
    }
}
