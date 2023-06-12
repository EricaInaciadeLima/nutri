package com.api.NutriAcess.dtos;

import com.api.NutriAcess.models.FamiliaModel;

public record DadosAtualizacaoFamilia(String id, String nome, Integer idade, Double peso, FamiliaModel.Sexo sexo) {
    public String getId() {
        return id;
    }
}
