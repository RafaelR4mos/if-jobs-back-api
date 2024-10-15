package com.br.ifjobs.dto.Vaga;

import com.br.ifjobs.enums.StatusVagaEnum;
import com.br.ifjobs.enums.TipoJornadaVagaEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;


@Getter
@Setter
@AllArgsConstructor
public class VagaUpdateDTO {

    @Schema(description = "Id da empresa da vaga", example = "2", nullable = true)
    private Integer idEmpresa;

    @Size(max = 100)
    @Schema(description = "Nome da vaga", example = "Desenvolvedor Frontend")
    private String nmVaga;

    @Schema(description = "Descrição da vaga", example = "Profissional Sênior com mais de 3 anos de experiência de mercado.")
    private String descVaga;

    @Schema(description = "Tipo da jornada", example = "REMOTO")
    private TipoJornadaVagaEnum tipoJornada;

    @Schema(description = "Status da vaga", example = "INATIVA")
    private StatusVagaEnum statusVaga;
}
