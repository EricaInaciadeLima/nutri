package com.api.NutriAcess.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "login")
public class LoginModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;
    @Column(name = "senha", nullable = false, length = 30)
    private String senha;

    public UUID getId() {
        return id;
    }

    public LoginModel setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public LoginModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public LoginModel setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
