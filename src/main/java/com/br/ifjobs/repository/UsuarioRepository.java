package com.br.ifjobs.repository;

import com.br.ifjobs.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, String> {

    UserDetails findByLogin(String login);

    @Query("SELECT idUsuario FROM UsuarioEntity u WHERE u.login = :login")
    Optional<String> findUserByLoginReturningIdOnly(String login);
}
