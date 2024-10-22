package com.br.ifjobs.service;

import com.br.ifjobs.dto.Usuario.UsuarioCreateDTO;
import com.br.ifjobs.dto.Usuario.UsuarioDTO;
import com.br.ifjobs.entity.UsuarioEntity;
import com.br.ifjobs.exception.RegraDeNegocioException;
import com.br.ifjobs.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final ObjectMapper objectMapper;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }

    public UsuarioDTO register(UsuarioCreateDTO usuarioCreateDTO) throws RegraDeNegocioException {
        if (usuarioRepository.findByLogin(usuarioCreateDTO.getLogin()) != null)
            throw new RegraDeNegocioException("Usuário já existe na base de dados");

        String encryptedPassword = new BCryptPasswordEncoder().encode(usuarioCreateDTO.getSenhaUsuario());
        UsuarioEntity newUser = new UsuarioEntity(
                usuarioCreateDTO.getLogin(),
                encryptedPassword,
                usuarioCreateDTO.getNmUsuario(),
                usuarioCreateDTO.getCpf(),
                usuarioCreateDTO.getDtNascimento()
        );

        return objectMapper.convertValue(usuarioRepository.save(newUser), UsuarioDTO.class);
    }

    public String findUserByIdReturningIdOnly(String login) throws RegraDeNegocioException {
        return usuarioRepository.findUserByLoginReturningIdOnly(login).orElseThrow(() -> new RegraDeNegocioException("Usuário não encontrado"));
    }
}
