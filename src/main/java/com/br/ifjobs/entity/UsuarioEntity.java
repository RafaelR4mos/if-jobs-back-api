package com.br.ifjobs.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "TB_USUARIOS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario")
    private String idUsuario;

    @Column(name = "login_usuario")
    private String login;

    @Column(name = "cpf_usuario")
    private String cpfUsuario;

    @Column(name = "senha_usuario")
    private String senhaUsuario;

    @Column(name = "nm_usuario")
    private String nmUsuario;

    @Column(name = "dt_nascimento")
    private LocalDate dtNascimento;

    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return senhaUsuario;
    }

    @Override
    public String getUsername() {
        return senhaUsuario;
    }

    public UsuarioEntity(String login, String senhaUsuario, String nmUsuario, String cpfUsuario, LocalDate dtNascimento) {
        this.login = login;
        this.senhaUsuario = senhaUsuario;
        this.nmUsuario = nmUsuario;
        this.cpfUsuario = cpfUsuario;
        this.dtNascimento = dtNascimento;
    }
}
