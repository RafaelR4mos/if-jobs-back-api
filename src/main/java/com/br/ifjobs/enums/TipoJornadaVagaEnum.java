package com.br.ifjobs.enums;

import lombok.Getter;

@Getter
public enum TipoJornadaVagaEnum {
    PRESENCIAL("Presencial"),
    HIBRIDO("Híbrido"),
    REMOTO("Remoto");

    private String tipo;

    TipoJornadaVagaEnum(String tipo) {
        this.tipo = tipo;
    }
}
