package com.api.NutriAcess.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cadastro_cliente")
public class CadastroClienteModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "nome_completo", nullable = false, length = 250)
    private String nomeCompleto;

    @Column(name = "nome_social", nullable = false, length = 30)
    private String nomeSocial;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "senha", nullable = false, length = 30)
    private String senha;
    

    public UUID getId() {
        return id;
    }

    public CadastroClienteModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public CadastroClienteModel setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public CadastroClienteModel setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CadastroClienteModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public CadastroClienteModel setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
