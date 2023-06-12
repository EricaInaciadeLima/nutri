package com.api.NutriAcess.models;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "Fale_Conosco")
public class FaleConoscoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "avaliacao", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private Avaliacao avaliacao;

    @Column(name = "nome_usuario", nullable = false)
    private String nomeUsuario;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "mensagem", nullable = false, length = 700)
    private String mensagem;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private CadastroClienteModel cliente;

    public enum Avaliacao{
        ZERO(0),
        UM(1),
        DOIS(2),
        TRES(3),
        QUATRO(4),
        CINCO(5),
        SEIS(6),
        SETE(7),
        OITO(8),
        NOVE(9),
        DEZ(10);

        private final int Valor;

        Avaliacao(int Valor) {
            this.Valor = Valor;
        }

        public int getvalor() {
            return Valor;
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

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
        this.email = email;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
   public CadastroClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(CadastroClienteModel cliente) {
        this.cliente = cliente;
    }
}

