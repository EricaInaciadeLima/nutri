package com.api.NutriAcess.repositories;

import com.api.NutriAcess.models.CadastroNutriModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CadastroNutriRepository extends JpaRepository<CadastroNutriModel, UUID>{

    boolean existsByEmail(String email);
}
