package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.ConsultaDto;
import com.api.NutriAcess.models.ConsultaModel;

import com.api.NutriAcess.repositories.ConsultaRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class ConsultaService {
    //Injenção de dependencias
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }
    @Transactional
    public ConsultaModel save(ConsultaModel consultaModel) {
        return consultaRepository.save(consultaModel);
    }

    public Optional<ConsultaModel> findById(UUID id) {
        return consultaRepository.findById(id);
    }
    //Validar os campos e irá retornar null se estiver tudo ok.
    public ResponseEntity<Object> validarConsulta(ConsultaDto consultaDto) {


        return null;
    }
}
