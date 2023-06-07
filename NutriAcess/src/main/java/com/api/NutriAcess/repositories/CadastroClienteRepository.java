package com.api.NutriAcess.repositories;

import com.api.NutriAcess.models.CadastroClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CadastroClienteRepository extends JpaRepository<CadastroClienteModel, UUID> {

    boolean existsByEmail(String email);
}