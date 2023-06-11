package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.FamiliaModel;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FamiliaDto {

    @NotBlank(message = "O campo nome não pode estar vazio.")
    private String nome;

    @NotNull(message = "O campo idade não pode estar vazio.")
    @Positive(message = "A idade deve ser um valor positivo.")
    @Min(value = 0, message = "A idade deve ser maior que 0.")
    private int idade;

    @NotNull(message = "O campo peso não pode estar vazio.")
    @Positive(message = "O peso deve ser um valor positivo.")
    @Min(value = 0, message = "O peso deve ser maior que 0.")
    private double peso;

    @NotNull(message = "O campo sexo não pode estar vazio.")
    private String sexo;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public FamiliaModel parseToEntity() {
        FamiliaModel familiaModel = new FamiliaModel();

        familiaModel.setNome(this.nome);
        familiaModel.setIdade(this.idade);
        familiaModel.setPeso(this.peso);
        familiaModel.setSexo(FamiliaModel.Sexo.valueOf(this.sexo.toUpperCase()));

        return familiaModel;
    }
}
