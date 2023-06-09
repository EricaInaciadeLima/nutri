package com.api.NutriAcess.repositories;

import com.api.NutriAcess.models.PlanosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PlanosRepository extends JpaRepository <PlanosModel, UUID> {


}
