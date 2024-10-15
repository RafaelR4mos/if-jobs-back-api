package com.br.ifjobs.dto.Empresa;

import com.br.ifjobs.enums.StatusEmpresaEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.lang.Nullable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaCreateDTO {

    @NotNull
    @NotBlank
    @Schema(description = "CNPJ da empresa", example = "02.081.839/0001-27")
    @Size(max = 20)
    @CNPJ(message = "o cnpj deve seguir o formato padrão brasileiro, como: 02.081.839/0001-27")
    private String cnpjEmpresa;

    @NotNull
    @NotBlank
    @Size(max = 200)
    @Schema(description = "Nome da empresa", example = "Nome Empresa teste 1")
    private String nomeEmpresa;

    @Nullable
    @Size(max = 255)
    @Schema(description = "Descrição da empresa", example = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book")
    private String descEmpresa;

    @NotNull
    @NotBlank
    @Schema(description = "Status da Empresa", example = "INATIVA")
    private StatusEmpresaEnum statusEmpresa;
}
