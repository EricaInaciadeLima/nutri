package com.api.NutriAcess.models;
import jakarta.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;
import com.api.NutriAcess.models.CadastroClienteModel;



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

    @ManyToOne
    @JoinColumn(name = "id_client")
    private CadastroClienteModel cliente;

    // Getters e Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public CadastroClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(CadastroClienteModel cliente) {
        this.cliente = cliente;
    }
}
