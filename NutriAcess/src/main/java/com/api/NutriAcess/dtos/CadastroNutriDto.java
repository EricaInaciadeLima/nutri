package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.CadastroNutriModel;
import jakarta.validation.constraints.NotBlank;

public class CadastroNutriDto {

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String nomeSocial;

    @NotBlank
    private String email;

    @NotBlank
    private String senha;


    @NotBlank
    private String crn;

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public CadastroNutriDto setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public CadastroNutriDto setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CadastroNutriDto setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getSenha() {
        return senha;
    }

    public CadastroNutriDto setSenha(String senha) {
        this.senha = senha;
        return this;
    }

    public String getCrn() {return crn;}

    public CadastroNutriDto setCrn(String crn) {
        this.crn = crn;
        return this;
    }

    //Esse método converter os dados DTO em modelo da entidade no banco de dados
    public CadastroNutriModel parseToEntity() {

        CadastroNutriModel cadastroNutriModel = new CadastroNutriModel();

        cadastroNutriModel.setNomeCompleto(this.nomeCompleto);
        cadastroNutriModel.setNomeSocial(this.nomeSocial);
        cadastroNutriModel.setEmail(this.email);
        cadastroNutriModel.setSenha(this.senha);
        cadastroNutriModel.setCrn(this.crn);

        return cadastroNutriModel;
    }
}
