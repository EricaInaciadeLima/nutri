package com.api.NutriAcess.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.NutriAcess.models.FamiliaModel;
@Repository
public interface FamiliaRepository extends JpaRepository<FamiliaModel, UUID>{
  
}
