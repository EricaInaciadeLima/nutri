package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.PlanosModel;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public class PlanosDto {

    @NotNull(message = "O campo tipo não pode estar vazio.")
    @Enumerated(EnumType.STRING)
    private PlanosModel.Tipo tipo;

    @NotBlank(message = "O campo duração não pode estar vazio.")
    private String duracao;

    @NotBlank(message = "O campo descrição não pode estar vazio.")
    private String descricao;

    @NotNull(message = "O campo valor não pode estar vazio.")
    @Positive(message = "O valor deve ser um valor positivo.")
    @Min(value = 0, message = "O valor deve ser maior que 0.")
    private BigDecimal valor;


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
