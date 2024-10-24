package com.br.ifjobs.dto.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String idUsuario;
    private String login;
    private String cpfUsuario;
    private String senhaUsuario;
    private String nmUsuario;
    private LocalDate dtNascimento;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
