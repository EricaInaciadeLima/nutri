package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.FormularioModel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class FormularioDto {

    @NotBlank(message = "O campo nome não pode estar vazio.")
    private String nome;

    @NotNull(message = "O campo objetivo não pode estar vazio.")
    private FormularioModel.Objetivo objetivo;

    @NotNull(message = "O campo gênero não pode estar vazio.")
    private FormularioModel.Genero genero;

    @NotNull(message = "O campo altura não pode estar vazio.")
    @Positive(message = "A altura deve ser um valor positivo.")
    @Min(value = 0, message = "A altura deve ser maior que 0.")
    private double altura;

    @NotNull(message = "O campo idade não pode estar vazio.")
    @Positive(message = "A idade deve ser um valor positivo.")
    @Min(value = 0, message = "A idade deve ser maior que 0.")
    private int idade;

    @NotNull(message = "O campo peso não pode estar vazio.")
    @Positive(message = "O peso deve ser um valor positivo.")
    @Min(value = 0, message = "A peso deve ser maior que 0.")
    private double peso;

    @NotNull(message = "O campo alimentação não pode estar vazio.")
    private FormularioModel.Alimentacao alimentacao;

    @NotNull(message = "O campo restrição alimentar não pode estar vazio.")
    private FormularioModel.RestricaoAlimentar restricaoAlimentar;

    @NotNull(message = "O campo tempo de preparo não pode estar vazio.")
    private FormularioModel.TempoPreparo tempoPreparo;

    @NotNull(message = "O campo foto não pode estar vazio.")
    private String foto;

    public String getNome() {
        return nome;
    }

    public FormularioDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public FormularioModel.Objetivo getObjetivo() {
        return objetivo;
    }

    public FormularioDto setObjetivo(FormularioModel.Objetivo objetivo) {
        this.objetivo = objetivo;
        return this;
    }

    public FormularioModel.Genero getGenero() {
        return genero;
    }

    public FormularioDto setGenero(FormularioModel.Genero genero) {
        this.genero = genero;
        return this;
    }

    public double getAltura() {
        return altura;
    }

    public FormularioDto setAltura(double altura) {
        this.altura = altura;
        return this;
    }

    public int getIdade() {
        return idade;
    }

    public FormularioDto setIdade(int idade) {
        this.idade = idade;
        return this;
    }

    public double getPeso() {
        return peso;
    }

    public FormularioDto setPeso(double peso) {
        this.peso = peso;
        return this;
    }

    public FormularioModel.Alimentacao getAlimentacao() {
        return alimentacao;
    }

    public FormularioDto setAlimentacao(FormularioModel.Alimentacao alimentacao) {
        this.alimentacao = alimentacao;
        return this;
    }

    public FormularioModel.RestricaoAlimentar getRestricaoAlimentar() {
        return restricaoAlimentar;
    }

    public FormularioDto setRestricaoAlimentar(FormularioModel.RestricaoAlimentar restricaoAlimentar) {
        this.restricaoAlimentar = restricaoAlimentar;
        return this;
    }

    public FormularioModel.TempoPreparo getTempoPreparo() {
        return tempoPreparo;
    }

    public FormularioDto setTempoPreparo(FormularioModel.TempoPreparo tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
        return this;
    }

    public String getFoto() {
        return foto;
    }

    public FormularioDto setFoto(String foto) {
        this.foto = foto;
        return this;
    }

    //Esse método converter os dados DTO em modelo da entidade no banco de dados
    public FormularioModel parseToEntity() {
        FormularioModel formularioModel = new FormularioModel();

        formularioModel.setNome(this.nome);
        formularioModel.setObjetivo(this.objetivo);
        formularioModel.setGenero(this.genero);
        formularioModel.setAltura(this.altura);
        formularioModel.setIdade(this.idade);
        formularioModel.setPeso(this.peso);
        formularioModel.setAlimentacao(this.alimentacao);
        formularioModel.setRestricaoAlimentar(this.restricaoAlimentar);
        formularioModel.setTempoPreparo(this.tempoPreparo);
        formularioModel.setFoto(this.foto);

        return formularioModel;
    }
}