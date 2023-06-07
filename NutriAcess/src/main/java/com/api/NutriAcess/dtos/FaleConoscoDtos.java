package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.FaleConoscoModel;
import com.api.NutriAcess.models.FormularioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FaleConoscoDtos {

    @NotBlank
    private String nomeUsuario;

    @NotBlank
    private String email;

    @NotBlank
    private String mensagem;

    @NotNull
    private FaleConoscoModel.AvaliacaoEnum avaliacaoEnum;


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
        email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public FaleConoscoModel.AvaliacaoEnum getAvaliacaoEnum() {
        return avaliacaoEnum;
    }

    public void setAvaliacaoEnum(FaleConoscoModel.AvaliacaoEnum avaliacaoEnum) {
        this.avaliacaoEnum = avaliacaoEnum;
    }




    //Esse método converter os dados DTO em modelo da entidade no banco de dados
    public FaleConoscoModel parseToEntity() {
        FaleConoscoModel faleConoscoModel = new FaleConoscoModel();

        faleConoscoModel.setNomeUsuario(this.nomeUsuario);
        faleConoscoModel.setEmail(this.email);
        faleConoscoModel.setAvaliacao(this.avaliacaoEnum);
        faleConoscoModel.setMensagem(this.mensagem);


        return faleConoscoModel;
    }
}
