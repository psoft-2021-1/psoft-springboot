package com.exemplo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusTrabalhoEnum {
    TRABALHA("Trabalha"),
    FOLGA("Não trabalha");
    private String trabalha;

    StatusTrabalhoEnum(String trabalha) {
        this.trabalha = trabalha;
    }

    @JsonValue
    public String getTrabalha() {
        return trabalha;
    }

    //Você vai instanciar um StatusTrabalhoEnum baseado no texto do teu requestBody
    // os possíveis valores são "Trabalha" ou "Não Trabalha".
    @JsonCreator
    public static StatusTrabalhoEnum fromText(String texto) {
        for(StatusTrabalhoEnum status : StatusTrabalhoEnum.values()){
            if(status.getTrabalha().equals(texto))
                return status;
        }
        return null;
    }
}
