package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.FormularioDto;
import com.api.NutriAcess.models.FormularioModel;
import com.api.NutriAcess.repositories.FormularioRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FormularioService {
    private final FormularioRepository formularioRepository;

    public FormularioService(FormularioRepository formularioRepository) {
        this.formularioRepository = formularioRepository;
    }

    @Transactional
    public FormularioModel save(FormularioModel formularioModel) {
        return formularioRepository.save(formularioModel);
    }

    //Vai retornar uma lista de todos registros.
    public Optional<FormularioModel> findById(UUID id) {
        return formularioRepository.findById(id);
    }

    public ResponseEntity<Object> validarFormulario(FormularioDto formularioDto) {


                   return null;
    }

}
