package com.api.NutriAcess.repositories;

import com.api.NutriAcess.models.FormularioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FormularioRepository extends JpaRepository<FormularioModel, UUID> {
}
