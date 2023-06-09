package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.CadastroNutriDto;
import com.api.NutriAcess.models.CadastroNutriModel;
import com.api.NutriAcess.repositories.CadastroNutriRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CadastroNutriService {
    //Injenção de dependencias
    private final CadastroNutriRepository cadastroNutriRepository;

    public CadastroNutriService(CadastroNutriRepository cadastroNutriRepository) {
        this.cadastroNutriRepository = cadastroNutriRepository;
    }

    @Transactional
    public CadastroNutriModel save(CadastroNutriModel cadastroNutriModel) {
        return cadastroNutriRepository.save(cadastroNutriModel);
    }

    @Transactional
    public boolean existsByCadastroNutriEmail(String email) {
        return cadastroNutriRepository.existsByEmail(email);
    }

    //Validar os campos e irá retornar null se estiver tudo ok.
    public ResponseEntity<Object> validarCadastroNutri(CadastroNutriDto cadastroNutriDto) {
        String email = cadastroNutriDto.getEmail();
        String senha = cadastroNutriDto.getSenha();
        String nomeCompleto = cadastroNutriDto.getNomeCompleto();
        String nomeSocial = cadastroNutriDto.getNomeSocial();
        String crn = cadastroNutriDto.getCrn();

        if (senha.length() < 6) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Senha precisa ter no mínimo 6 caracteres.");
        }

        if (nomeCompleto == null || nomeCompleto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo nome completo é obrigatório.");
        }

        if (nomeSocial == null || nomeSocial.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo nome social é obrigatório.");
        }

        if (email.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo de e-mail é obrigatório.");
        }
        if (existsByCadastroNutriEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado.");
        }
        if (crn.isEmpty()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Crn inválido");
        }
        return null;
    }

    public Optional<CadastroNutriModel> findById(UUID id) {
        return cadastroNutriRepository.findById(id);
    }
}
