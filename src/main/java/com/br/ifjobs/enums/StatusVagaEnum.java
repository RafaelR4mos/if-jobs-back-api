package com.br.ifjobs.enums;

import lombok.Getter;

@Getter
public enum StatusVagaEnum {
    INATIVA("Inativa"),
    ATIVA("Ativa"),
    ENCERRADA("Encerrada");

    private String status;

    StatusVagaEnum(String status) {
        this.status = status;
    }
}
