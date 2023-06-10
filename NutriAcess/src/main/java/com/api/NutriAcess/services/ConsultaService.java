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
        Date data = consultaDto.getData();
        Time hora = consultaDto.getHora();
        String status = consultaDto.getStatus();
        String observacoes = consultaDto.getObservacoes();

        if (data == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo data é obrigatório.");
        }

        if (hora == null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo hora é obrigatório.");
        }

        if (status == null || status.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo status é obrigatório.");
        }

        if (observacoes == null || observacoes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo observações é obrigatório.");
        }

        return null;
    }
}
