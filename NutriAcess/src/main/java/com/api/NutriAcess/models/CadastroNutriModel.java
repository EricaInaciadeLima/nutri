package com.api.NutriAcess.models;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "cadastro_nutricionista")
public class CadastroNutriModel {

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

    @Column(name = "crn", nullable = false, length = 10)
    private String crn;

    public UUID getId() {
        return id;
    }

    public CadastroNutriModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public CadastroNutriModel setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public CadastroNutriModel setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CadastroNutriModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public CadastroNutriModel setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getCrn() {return crn;}

    public CadastroNutriModel setCrn(String crn) {
        this.crn = crn;
        return this;
    }
}
