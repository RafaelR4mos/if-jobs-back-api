package com.br.ifjobs.dto.Empresa;

import com.br.ifjobs.enums.StatusEmpresaEnum;
import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
public class EmpresaDTO {

    private Integer idEmpresa;

    private String cnpjEmpresa;

    private String nomeEmpresa;

    private String descEmpresa;

    private StatusEmpresaEnum statusEmpresa;

    private Timestamp createdAt;

    private Timestamp updatedAt;
}
