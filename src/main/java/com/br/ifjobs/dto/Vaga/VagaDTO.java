package com.br.ifjobs.dto.Vaga;

import com.br.ifjobs.enums.StatusVagaEnum;
import com.br.ifjobs.enums.TipoJornadaVagaEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VagaDTO {

    private Integer idVaga;
    private Integer idEmpresa;
    private String nmVaga;
    private String descVaga;
    private TipoJornadaVagaEnum tipoJornada;
    private StatusVagaEnum statusVaga;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
