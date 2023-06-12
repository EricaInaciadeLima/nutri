package com.api.NutriAcess.repositories;


import com.api.NutriAcess.models.FaleConoscoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FaleConoscoRepository extends JpaRepository<FaleConoscoModel, UUID>{

}
