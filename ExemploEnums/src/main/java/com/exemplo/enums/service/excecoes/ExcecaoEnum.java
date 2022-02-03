package com.exemplo.enums.service.excecoes;

public class ExcecaoEnum extends RuntimeException {
    public ExcecaoEnum(String msg) {
        super(String.format("Erro no enum, valores aceitos: %s", msg));
    }
}
