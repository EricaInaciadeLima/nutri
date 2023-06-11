package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.CadastroClienteModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CadastroClienteDto {

    @NotBlank(message = "O campo nome completo é obrigatório.")
    private String nomeCompleto;

    @NotBlank(message = "O campo nome social é obrigatório.")
    private String nomeSocial;

    @NotBlank(message = "O campo de e-mail é obrigatório.")
    @Email(message = "O campo de e-mail está em um formato inválido.")
    private String email;

    @NotBlank(message = "O campo de senha é obrigatório.")
    @Size(min = 6, max = 12, message = "O campo senha deve ter entre 6 e 12 caracteres")
    private String senha;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public CadastroClienteDto setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public CadastroClienteDto setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CadastroClienteDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public CadastroClienteDto setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    //Esse método converter os dados DTO em modelo da entidade no banco de dados
    public CadastroClienteModel parseToEntity() {

        CadastroClienteModel cadastroClienteModel = new CadastroClienteModel();

        cadastroClienteModel.setNomeCompleto(this.nomeCompleto);
        cadastroClienteModel.setNomeSocial(this.nomeSocial);
        cadastroClienteModel.setEmail(this.email);
        cadastroClienteModel.setSenha(this.senha);

        return cadastroClienteModel;
    }

}
