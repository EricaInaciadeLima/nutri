package com.api.NutriAcess.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Fale Conosco")
public class FaleConoscoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "avaliacao", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private AvaliacaoEnum avaliacao;

    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mensagem", nullable = false, length = 700)
    private String mensagem;

    public enum AvaliacaoEnum {
        ZERO,
        UM,
        DOIS,
        TRÊS,
        CINCO,
        SEIS,
        SETE,
        OITO,
        NOVE,
        DEZ
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AvaliacaoEnum getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(AvaliacaoEnum avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}


