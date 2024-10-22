package com.br.ifjobs.controller;

import com.br.ifjobs.dto.Usuario.UsuarioCreateDTO;
import com.br.ifjobs.dto.Usuario.UsuarioDTO;
import com.br.ifjobs.dto.Usuario.UsuarioLoginRequestDTO;
import com.br.ifjobs.dto.Usuario.UsuarioLoginResponseDTO;
import com.br.ifjobs.entity.UsuarioEntity;
import com.br.ifjobs.exception.RegraDeNegocioException;
import com.br.ifjobs.security.TokenService;
import com.br.ifjobs.service.UsuarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.Token;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Endpoints for authentication")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<UsuarioLoginResponseDTO> login(@RequestBody @Valid UsuarioLoginRequestDTO usuarioLoginRequestDTO) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(usuarioLoginRequestDTO.getLogin(), usuarioLoginRequestDTO.getSenha());

        try {
            var auth = authenticationManager.authenticate(usernamePassword);
            var validateUser = tokenService.generateToken((UsuarioEntity) auth.getPrincipal());

            String userId = this.usuarioService.findUserByIdReturningIdOnly(usuarioLoginRequestDTO.getLogin());

            return new ResponseEntity<>(new UsuarioLoginResponseDTO(userId, validateUser), HttpStatus.OK);
        } catch (AuthenticationException | RegraDeNegocioException e) {
            throw new BadCredentialsException("Senha ou e-mail inválidos");
        }
    }

    @PostMapping("/cadastro")
    public ResponseEntity<UsuarioDTO> register(@RequestBody @Valid UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {
        return new ResponseEntity<>(usuarioService.register(usuarioCreateDTO), HttpStatus.CREATED);
    }
}
