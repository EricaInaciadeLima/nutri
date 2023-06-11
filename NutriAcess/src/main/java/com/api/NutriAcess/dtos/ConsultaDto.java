package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.ConsultaModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Time;
import java.util.Date;

public class ConsultaDto {

    @NotNull(message = "O campo data é obrigatório.")
    private Date data;

    @NotNull(message = "O campo hora é obrigatório.")
    private Time hora;

    @NotBlank(message ="O campo status é obrigatório.")
    private String status;

    @NotBlank(message = "O campo observações é obrigatório.")
    private String observacoes;

    public Date getData() {
        return data;
    }

    public ConsultaDto setData(Date data) {
        this.data = data;
        return this;
    }

    public Time getHora() {
        return hora;
    }

    public ConsultaDto setHora(Time hora) {
        this.hora = hora;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ConsultaDto setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public ConsultaDto setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }

    //Esse método converter os dados DTO em modelo da entidade no banco de dados
    public ConsultaModel parseToEntity() {
        ConsultaModel consultaModel = new ConsultaModel();

        consultaModel.setData(this.data);
        consultaModel.setHora(this.hora);
        consultaModel.setStatus(this.status);
        consultaModel.setObservacoes(this.observacoes);

        return consultaModel;
    }
}
