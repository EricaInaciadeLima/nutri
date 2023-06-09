package com.api.NutriAcess.models;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "planos")
public class PlanosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo", nullable = false)
    private Enum tipo;

    @Column(name = "data_inicio", nullable = false) // Mês em que o cliente fez a assinatura.
    private LocalDate dataInicio;

    @Column(name = "data_termino", nullable = false) // Mês em que vai terminar a assinatura do cliente.
    private LocalDate dataTermino;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "valor", nullable = false)
    private BigDecimal valor;

    // Construtores, getters e setters

    public PlanosModel() {
    }

    public PlanosModel(String tipo, LocalDate dataInicio, LocalDate dataTermino, String descricao, BigDecimal valor) {
        this.tipo= tipo;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
