package com.api.NutriAcess.dtos;

import jakarta.validation.constraints.NotBlank;

public class LoginDto {

    @NotBlank
    private String email;

    @NotBlank
    private String senha;

    public String getEmail() {
        return email;
    }

    public LoginDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public LoginDto setSenha(String senha) {
        this.senha = senha;
        return this;
    }
}
