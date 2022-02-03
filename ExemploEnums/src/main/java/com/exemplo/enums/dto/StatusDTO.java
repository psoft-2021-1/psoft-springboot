package com.exemplo.enums.dto;

import com.exemplo.enums.StatusTrabalhoEnum;

public class StatusDTO {

    private String tipo;

    public StatusDTO(){}

    public StatusDTO(String tipo) {
        this.tipo = tipo;
    }

    public StatusDTO(StatusTrabalhoEnum value){
        this.tipo = value.toString();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
