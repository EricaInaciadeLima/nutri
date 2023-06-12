package com.api.NutriAcess.controllers;

import java.util.Optional;
import java.util.UUID;

import com.api.NutriAcess.dtos.DadosAtualizacaoFamilia;
import com.api.NutriAcess.repositories.FamiliaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.NutriAcess.dtos.FamiliaDto;
import com.api.NutriAcess.models.FamiliaModel;
import com.api.NutriAcess.services.FamiliaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/familia")
public class FamiliaController {
  // injeção de dependências.
  private final FamiliaService familiaService;

  @Autowired
  private FamiliaRepository familiaRepository;

  public FamiliaController(FamiliaService familiaService) {
    this.familiaService = familiaService;
  }

  @PostMapping("/criar")
  public ResponseEntity<Object> cadastrarNutri(@RequestBody @Valid FamiliaDto familiaDto,
      BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
      StringBuilder errorMessage = new StringBuilder();
      for (FieldError error : bindingResult.getFieldErrors()) {
        errorMessage.append(error.getDefaultMessage()).append("\n");
      }
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage.toString().trim());
    }
    try {

      FamiliaModel familiaModel = familiaDto.parseToEntity();

      return ResponseEntity.status(HttpStatus.CREATED).body(familiaService.save(familiaModel));

    } catch (Exception exception) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<Page<FamiliaModel>> getAllFamilia(
      @PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
    return ResponseEntity.status(HttpStatus.OK).body(familiaService.findAll(pageable));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Object> getOneFamilia(@PathVariable(value = "id") UUID id) {
    Optional<FamiliaModel> familiaModelOptional = familiaService.findById(id);
    if (!familiaModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado dados dessa família.");
    }
    return ResponseEntity.status(HttpStatus.OK).body(familiaModelOptional.get());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteFamilia(@PathVariable(value = "id") UUID id) {
    Optional<FamiliaModel> familiaModelOptional = familiaService.findById(id);
    if (!familiaModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado dados dessa família.");
    }
    familiaService.delete(familiaModelOptional.get());
    return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso.");
  }

<<<<<<< HEAD
  @PutMapping
  @Transactional
  public void atualizar(@RequestBody @Valid DadosAtualizacaoFamilia dados) {
    var familia = familiaRepository.getReferenceById(UUID.fromString(dados.getId()));
     familia.atualizarInformacoes(dados);
=======
  @PutMapping("/{id}")
  public ResponseEntity<Object> updateFamilia(@PathVariable(value = "id") UUID id,
      @RequestBody @Valid FamiliaDto familiaDto) {
    Optional<FamiliaModel> familiaModelOptional = familiaService.findById(id);
    if (!familiaModelOptional.isPresent()) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado dados dessa família.");
    }
   
    var familiaModel = new FamiliaModel();
    BeanUtils.copyProperties(familiaDto, familiaModel);
    familiaModel.setId(familiaModelOptional.get().getId());

    return ResponseEntity.status(HttpStatus.OK).body(familiaService.save(familiaModel));
>>>>>>> 84a9da79e374252fdac2be84d2aa51fc64cf40a2
  }
  


}
