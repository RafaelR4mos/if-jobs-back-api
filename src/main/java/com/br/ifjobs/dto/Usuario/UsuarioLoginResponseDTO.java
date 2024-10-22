package com.br.ifjobs.dto.Usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioLoginResponseDTO {

    private String idUsuario;
    private String token;
}
