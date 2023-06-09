package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.PlanosModel;
import jakarta.persistence.EnumType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class PlanosDto {

    @NotBlank
    private PlanosModel.Tipo tipo;

    @NotNull
    private Date dataInicio;

    @NotNull
    private Date dataTermino;

    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal valor;

    // Construtores, getters e setters

    public PlanosDto(PlanosModel.Tipo tipo, Date dataInicio, Date dataTermino, String descricao, BigDecimal valor) {
        this.tipo = tipo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descricao = descricao;
        this.valor = valor;
    }

    public PlanosModel.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(PlanosModel.Tipo tipo) {
        this.tipo = tipo;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(Date dataTermino) {
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

    public PlanosModel parseToEntity() {
        PlanosModel planosModel = new PlanosModel();
        planosModel.setDataInicio(this.dataInicio);
        planosModel.setTipo(this.tipo);
        planosModel.setDescricao(this.descricao);
        planosModel.setDataTermino(this.dataTermino);
        planosModel.setValor(this.valor);
        return planosModel;
    }

}
