package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.CadastroNutriModel;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CadastroNutriDto {

  
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

    @NotBlank(message = "Crn inválido" )
    @Size(min = 9, max = 9, message = "O campo crn deve ter entre 1 e 10 caracteres")
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
