package com.api.NutriAcess.services;

import com.api.NutriAcess.dtos.CadastroClienteDto;
import com.api.NutriAcess.models.CadastroClienteModel;
import com.api.NutriAcess.models.CadastroNutriModel;
import com.api.NutriAcess.repositories.CadastroClienteRepository;
import jakarta.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Optional<CadastroClienteModel> findById(UUID id) {
        return cadastroClienteRepository.findById(id);
    }
     @Transactional
    public void delete(CadastroClienteModel cadastroClienteModel) {
        cadastroClienteRepository.delete(cadastroClienteModel);
    }

    public Page<CadastroClienteModel> findAll(Pageable pageable) {
        return cadastroClienteRepository.findAll(pageable);
    }
    //Validar os campos e irá retornar null se estiver tudo ok.
    public ResponseEntity<Object> validarCadastroCliente(CadastroClienteDto cadastroClienteDto) {
        String email = cadastroClienteDto.getEmail();
    
        if (existsByCadastroClienteEmail(email)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email já cadastrado.");
        }
        return null;
    }


}
