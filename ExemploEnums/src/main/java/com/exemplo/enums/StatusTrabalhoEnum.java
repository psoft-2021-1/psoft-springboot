package com.exemplo.enums;

public enum StatusTrabalhoEnum {
    TRABALHA("Trabalha"),
    FOLGA("Está de folga");
    private String trabalha;

    StatusTrabalhoEnum(String trabalha) {
        this.trabalha = trabalha;
    }

    public String getTrabalha() {
        return trabalha;
    }

}
