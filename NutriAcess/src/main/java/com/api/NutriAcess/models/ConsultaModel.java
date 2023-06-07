package com.api.NutriAcess.models;

import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "consulta")
public class ConsultaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "data", nullable = false)
    private Date data;

    @Column(name = "hora", nullable = false)
    private Time hora;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "observacoes", nullable = false, length = 1000)
    private String observacoes;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public ConsultaModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public Date getData() {
        return data;
    }

    public ConsultaModel setData(Date data) {
        this.data = data;
        return this;
    }

    public Time getHora() {
        return hora;
    }

    public ConsultaModel setHora(Time hora) {
        this.hora = hora;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ConsultaModel setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public ConsultaModel setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }
}
