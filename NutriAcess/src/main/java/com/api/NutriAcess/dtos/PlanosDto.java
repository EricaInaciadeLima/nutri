package com.api.NutriAcess.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PlanosDto {

    @NotBlank
    private String tipo;

    @NotNull
    private LocalDate dataInicio;

    @NotNull
    private LocalDate dataTermino;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    // Construtores, getters e setters

    public PlanosDto(String tipo, LocalDate dataInicio, LocalDate dataTermino, String descricao, BigDecimal valor) {
        this.tipo = tipo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
