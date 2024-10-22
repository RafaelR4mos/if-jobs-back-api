package com.br.ifjobs.dto.Usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioLoginRequestDTO {

    @Schema(description = "E-mail do usuário", example = "rafael@email.com")
    @NotNull(message = "login é obrigatório.")
    @Email(message = "login deve ser um e-mail.")
    private String login;

    @Schema(description = "Senha do usuário", example = "Rafael123")
    @NotNull(message = "senha é obrigatório.")
    @Size(min = 6, max = 30, message = "A senha deve conter de 6 a 30 caracteres.")
    private String senha;
}
