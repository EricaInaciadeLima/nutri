package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.FaleConoscoDtos;
import com.api.NutriAcess.models.FaleConoscoModel;
import com.api.NutriAcess.repositories.FaleConoscoRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FaleConoscoService {

    //Injenção de dependencias
    private final FaleConoscoRepository faleConoscoRepository;

    public FaleConoscoService(FaleConoscoRepository faleConoscoRepository) {
        this.faleConoscoRepository = faleConoscoRepository;
    }

    @Transactional
    public FaleConoscoModel save(FaleConoscoModel faleConoscoModel) {
        return faleConoscoRepository.save(faleConoscoModel);
    }

    public Optional<FaleConoscoModel> findById(UUID id) {
        return faleConoscoRepository.findById(id);
    }


    public ResponseEntity<Object> validarFaleConosco(FaleConoscoDtos faleConoscoDtos) {
        String nomeUsuario = faleConoscoDtos.getNomeUsuario();
        String email  = faleConoscoDtos.getEmail();
        String mensagem = faleConoscoDtos.getMensagem();


        if (faleConoscoDtos.getAvaliacao() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A opção de avaliação não pode ficar vazia");
        }
        if (nomeUsuario == null || nomeUsuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo nome não pode estar vazio.");
        }
        if (email == null || email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo email não pode estar vazio.");
        }
        if (mensagem == null || mensagem.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo de Mensagem não pode estar vazio.");
        }
        return null;
    }
}
