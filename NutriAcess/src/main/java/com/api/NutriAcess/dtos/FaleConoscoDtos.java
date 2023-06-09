package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.FaleConoscoModel;
import com.api.NutriAcess.models.FormularioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class FaleConoscoDtos {

    @NotBlank
    private String nomeUsuario;

    @NotBlank
    private String Email;

    @NotBlank
    private String mensagem;

    @NotNull
    private FaleConoscoModel.Avaliacao avaliacao;


    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public FaleConoscoModel.Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(FaleConoscoModel.Avaliacao avaliacao) {this.avaliacao = avaliacao;
    }




    //Esse método converter os dados DTO em modelo da entidade no banco de dados
    public FaleConoscoModel parseToEntity() {
        FaleConoscoModel faleConoscoModel = new FaleConoscoModel();

        faleConoscoModel.setNomeUsuario(this.nomeUsuario);
        faleConoscoModel.setEmail(this.Email);
        faleConoscoModel.setAvaliacao(this.avaliacao);
        faleConoscoModel.setMensagem(this.mensagem);


        return faleConoscoModel;
    }
}
