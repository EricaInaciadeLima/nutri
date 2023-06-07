package com.api.NutriAcess.repositories;


import com.api.NutriAcess.models.FaleConoscoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FaleConoscoRepository extends JpaRepository<FaleConoscoModel, UUID>{

}
