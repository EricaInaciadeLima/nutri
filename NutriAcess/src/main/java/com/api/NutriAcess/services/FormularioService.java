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

        if (formularioDto.getNome() == null || formularioDto.getNome().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O campo nome não pode estar vazio.");
        }

        if (formularioDto.getObjetivo() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O objetivo fornecido é inválido.");
        }

        if (formularioDto.getGenero() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O gênero não pode ser nulo.");
        }

        if ( formularioDto.getAltura() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A altura deve ser um valor positivo.");
        }

        if (formularioDto.getIdade() < 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A idade deve ser um valor não negativo.");
        }

        if (formularioDto.getPeso() <= 0) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O peso deve ser um valor positivo.");
        }

        if (formularioDto.getAlimentacao() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A alimentação não pode ser nula.");
        }

        if (formularioDto.getRestricaoAlimentar() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("A restrição alimentar não pode ser nula.");
        }

        if (formularioDto.getTempoPreparo() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O tempo de preparo não pode ser nulo.");
        }

                   return null;
    }

}
