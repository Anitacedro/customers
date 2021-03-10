package com.customer.rest.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "customer")
public class CustomerModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "endereco",nullable = false,length = 100)
    private String endereco;

    @Column(name = "cidade",nullable = false,length = 100)
    private String cidade;

    @Column(name = "uf",nullable = false,length = 100)
    private String uf;

    @Column(name = "genero",nullable = false,length = 8)
    private String genero;

    @Column(name = "nome",nullable = false,length = 100)
    private String nome;

    @Column(name = "sobre_nome", nullable = false,length = 100)
    private String sobrenome;

    @Column(name = "num_cpf",nullable = false,length = 30)
    private String numCpf;

    @Column(name = "dth_nascimento",nullable = false)
    private Date dataNascimento ;

    public CustomerModel(String endereco, String cidade, String uf, String genero, String nome, String sobrenome, String numCpf, Date dataNascimento) {
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.genero = genero;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.numCpf = numCpf;
        this.dataNascimento = dataNascimento;
    }
}
