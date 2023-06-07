package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.CadastroClienteModel;
import jakarta.validation.constraints.NotBlank;

public class CadastroClienteDto {

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String nomeSocial;

    @NotBlank
    private String email;

    @NotBlank
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
