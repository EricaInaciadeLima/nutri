package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.CadastroClienteDto;
import com.api.NutriAcess.models.CadastroClienteModel;
import com.api.NutriAcess.repositories.CadastroClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CadastroClienteService {
    //Injenção de dependencias
    private final CadastroClienteRepository cadastroClienteRepository;

    public CadastroClienteService(CadastroClienteRepository cadastroClienteRepository) {
        this.cadastroClienteRepository = cadastroClienteRepository;
    }

    @Transactional
    public CadastroClienteModel save(CadastroClienteModel cadastroClienteModel) {
        return cadastroClienteRepository.save(cadastroClienteModel);
    }

    @Transactional
    public boolean existsByCadastroClienteEmail(String email) {
        return cadastroClienteRepository.existsByEmail(email);
    }

    //Validar os campos e irá retornar null se estiver tudo ok.
    public ResponseEntity<Object> validarCadastroCliente(CadastroClienteDto cadastroClienteDto) {
        String email = cadastroClienteDto.getEmail();
        String senha = cadastroClienteDto.getSenha();
        String nomeCompleto = cadastroClienteDto.getNomeCompleto();
        String nomeSocial = cadastroClienteDto.getNomeSocial();

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
        if (existsByCadastroClienteEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado.");
        }
        return null;
    }

    public Optional<CadastroClienteModel> findById(UUID id) {
        return cadastroClienteRepository.findById(id);
    }
}
