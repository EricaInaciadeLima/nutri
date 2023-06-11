package com.api.NutriAcess.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.NutriAcess.models.FamiliaModel;

public interface FamiliaRepository extends JpaRepository<FamiliaModel, UUID>{
  
}
