package com.br.ifjobs.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public enum StatusEmpresaEnum {
    INATIVA("Inativo"),
    ATIVA("Ativo");

    private String status;

    StatusEmpresaEnum(String status) {
        this.status = status;
    }
}
