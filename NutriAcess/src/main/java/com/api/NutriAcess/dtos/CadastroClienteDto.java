package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.CadastroClienteModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import javax.security.auth.callback.LanguageCallback;

@Getter
@Setter
public class CadastroClienteDto {

    @NotBlank(message = "O campo nome completo é obrigatório.")
    private String nomeCompleto;

    @NotBlank
    private String nomeSocial;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 6, max = 6)
    private String senha;



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
