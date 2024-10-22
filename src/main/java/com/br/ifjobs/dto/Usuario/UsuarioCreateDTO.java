package com.br.ifjobs.dto.Usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateDTO {

    @Email(message = "Este campo deve estar no formato de e-mail válido")
    @NotNull(message = "Login não deve ser nulo")
    @NotBlank(message = "O e-mail para login é obrigatório")
    @Schema(description = "Email do usuário", example = "rafael@email.com")
    private String login;

    @CPF(message = "O CPF deve ser válido")
    @NotNull(message = "O CPF não pode ser nulo")
    @Size(max = 11, min = 11, message = "O CPF deve ter exclusivamente 11 caracteres.")
    @Schema(description = "cpf do usuario", example = "23050385006")
    private String cpf;

    @NotNull
    @NotBlank
    @Size(min = 6, max = 30, message = "A senha deve ter entre 6 e 30 caracteres")
    @Schema(description = "senha do usuario", example = "Rafael123")
    private String senhaUsuario;

    @NotNull
    @NotBlank
    @Schema(description = "nome do usuario", example = "Rafael Ramos")
    private String nmUsuario;

    @Past
    @NotNull
    @Schema(description = "data de nascimento (dd/mm/yyyy)", example = "14/07/2003")
    private LocalDate dtNascimento;
}
