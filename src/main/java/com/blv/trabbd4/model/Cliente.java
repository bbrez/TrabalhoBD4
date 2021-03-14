package com.blv.trabbd4.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;
    private String nome;
    private String sobrenome;
    private String cpf;

    @ManyToOne
    @JoinColumn(name="id_endereco_residencial")
    private EnderecoEspecifico enderecoResidencial;

    @ManyToOne
    @JoinColumn(name="id_endereco_comercial")
    private EnderecoEspecifico enderecoComercial;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Telefone> telefones;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Fatura> faturas;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Email> emails;

    public Cliente(){}
    public Cliente(String nome, String sobrenome, String cpf){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
    }

}
