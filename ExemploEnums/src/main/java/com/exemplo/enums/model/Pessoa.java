package com.exemplo.enums.model;


import com.exemplo.enums.StatusTrabalhoEnum;

import javax.persistence.*;

@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    //@Enumerated(EnumType.ORDINAL) os enums são armazenados de forma ordinal, então trocar a ordem
    //dos valores do enum, pode impactar no sistema

    // o STRING, armazena no bd na forma que os valores estão nomeados, então a ordem não influencia,
    @Enumerated(EnumType.STRING)
    private StatusTrabalhoEnum statusTrabalho;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, StatusTrabalhoEnum statusTrabalho) {
        this.id = id;
        this.nome = nome;
        this.statusTrabalho = statusTrabalho;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public StatusTrabalhoEnum getStatusTrabalho() {
        return statusTrabalho;
    }

    public void setStatusTrabalho(StatusTrabalhoEnum statusTrabalhoEnum) {
        this.statusTrabalho = statusTrabalhoEnum;
    }
}
