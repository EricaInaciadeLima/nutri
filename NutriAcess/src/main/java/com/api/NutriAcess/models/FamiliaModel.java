package com.api.NutriAcess.models;

import java.util.UUID;

import com.api.NutriAcess.dtos.DadosAtualizacaoFamilia;
import com.api.NutriAcess.dtos.FamiliaDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "Familia")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FamiliaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name = "peso", nullable = false)
    private double peso;

    @Column(name = "sexo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private CadastroClienteModel cliente;

    public void atualizarInformacoes(DadosAtualizacaoFamilia dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.idade() != null) {
            this.idade = dados.idade();
        }

        if (dados.peso() != null) {
            this.peso = dados.peso();
        }

        if (dados.sexo() != null) {
            this.sexo = dados.sexo();
        }
    }

    public enum Sexo {
        MASCULINO,
        FEMININO,
        OUTRO
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public CadastroClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(CadastroClienteModel cliente) {
        this.cliente = cliente;
    }
}
