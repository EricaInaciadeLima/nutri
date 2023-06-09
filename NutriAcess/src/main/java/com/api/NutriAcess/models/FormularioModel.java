    package com.api.NutriAcess.models;

    import jakarta.persistence.*;

    import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

    @Entity
    @Table(name = "formulario")
    public class FormularioModel {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private UUID id;

        @Column(name = "name", nullable = false, length = 255)
        private String nome;

        @Column(name = "objetivo", nullable = false)
        @Enumerated(EnumType.STRING)
        private Objetivo objetivo;

        @Column(name = "genero", nullable = false)
        @Enumerated(EnumType.STRING)
        private Genero genero;

        @Column(name = "altura", nullable = false)
        private double altura;

        @Column(name = "idade", nullable = false)
        private int idade;

        @Column(name = "peso", nullable = false)
        private double peso;

        @Column(name = "alimentacao", nullable = false)
        @Enumerated(EnumType.STRING)
        private Alimentacao alimentacao;

        @Column(name = "restricao_alimentar", nullable = false)
        @Enumerated(EnumType.STRING)
        private RestricaoAlimentar restricaoAlimentar;

        @Column(name = "tempo_preparo", nullable = false)
        @Enumerated(EnumType.STRING)
        private TempoPreparo tempoPreparo;

       
        @Column(name = "foto")
        private String foto;

        @ManyToOne
        @JoinColumn(name = "id_client")
        private CadastroClienteModel cliente;

        // Getters e Setters

        public UUID getId() {
            return id;
        }

        public FormularioModel setId(UUID id) {
            this.id = id;
            return this;
        }

        public String getNome() {
            return nome;
        }

        public FormularioModel setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Genero getGenero() {
            return genero;
        }

        public FormularioModel setGenero(Genero genero) {
            this.genero = genero;
            return this;
        }

        public Objetivo getObjetivo() {
            return objetivo;
        }

        public FormularioModel setObjetivo(Objetivo objetivo) {
            this.objetivo = objetivo;
            return this;
        }

        public double getAltura() {
            return altura;
        }

        public FormularioModel setAltura(double altura) {
            this.altura = altura;
            return this;
        }

        public int getIdade() {
            return idade;
        }

        public FormularioModel setIdade(int idade) {
            this.idade = idade;
            return this;
        }

        public double getPeso() {
            return peso;
        }

        public FormularioModel setPeso(double peso) {
            this.peso = peso;
            return this;
        }

        public Alimentacao getAlimentacao() {
            return alimentacao;
        }

        public FormularioModel setAlimentacao(Alimentacao alimentacao) {
            this.alimentacao = alimentacao;
            return this;
        }

        public RestricaoAlimentar getRestricaoAlimentar() {
            return restricaoAlimentar;
        }

        public FormularioModel setRestricaoAlimentar(RestricaoAlimentar restricaoAlimentar) {
            this.restricaoAlimentar = restricaoAlimentar;
            return this;
        }

        public TempoPreparo getTempoPreparo() {
            return tempoPreparo;
        }

        public FormularioModel setTempoPreparo(TempoPreparo tempoPreparo) {
            this.tempoPreparo = tempoPreparo;
            return this;
        }

        public String getFoto() {
            return foto;
        }

        public FormularioModel setFoto(String foto) {
            this.foto = foto;
            return this;
        }
     public CadastroClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(CadastroClienteModel cliente) {
        this.cliente = cliente;
    }
    // Enums para objetivo, genero, alimentacao, restricao_alimentar e tempo_preparo

        public enum Objetivo {
            @JsonProperty("PERDER PESO")
            PERDER_PESO,

            @JsonProperty("MANTER PESO ATUAL")
            MANTER_PESO_ATUAL,

            @JsonProperty("GANHAR MASSA MUSCULAR")
            GANHAR_MASSA_MUSCULAR
        }

        public enum Genero {
            HOMEM,
            MULHER,
            OUTRO
        }

        public enum Alimentacao {
            @JsonProperty("SEDENTARISMO")
            SEDENTARISMO,

            @JsonProperty("ATIVIDADE FISICA MODERADA")
            ATIVIDADE_FISICA_MODERADA,

            @JsonProperty("ATIVIDADE FISICA INTENSIVA")
            ATIVIDADE_FISICA_INTENSIVA
        }


        public enum RestricaoAlimentar {
            @JsonProperty("QUALQUER COISA")
            QUALQUER_COISA,

            @JsonProperty("SOU VEGETARIANO")
            SOU_VEGETARIANO,

            @JsonProperty("SOU VEGANO")
            SOU_VEGANO
        }

        public enum TempoPreparo {
            SIM,
            NAO
        }
    }