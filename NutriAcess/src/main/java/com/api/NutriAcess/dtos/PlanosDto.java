package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.PlanosModel;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class PlanosDto {

    @NotNull
    @Enumerated(EnumType.STRING)
    private PlanosModel.Tipo tipo;

    @NotNull
    private String duracao;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    public PlanosDto() {
    }

    public PlanosDto(PlanosModel.Tipo tipo, String duracao, String descricao, BigDecimal valor) {
        this.tipo = tipo;
        this.duracao = duracao;
        this.descricao = descricao;
        this.valor = valor;
    }

    public PlanosModel.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(PlanosModel.Tipo tipo) {
        this.tipo = tipo;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
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

    public PlanosModel parseToEntity() {
        PlanosModel planosModel = new PlanosModel();
        planosModel.setTipo(this.tipo);
        planosModel.setDuracao(this.duracao);
        planosModel.setDescricao(this.descricao);
        planosModel.setValor(this.valor);
        return planosModel;
    }
}
