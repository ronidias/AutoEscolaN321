package br.com.senai.autoescolan321.domain;

import br.com.senai.autoescolan321.enumeration.Perfil;
import br.com.senai.autoescolan321.model.dto.usuario.DadosAtualizacaoUsuario;
import br.com.senai.autoescolan321.model.dto.usuario.DadosCadastroUsuario;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity (name = "usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String senha;
    private LocalDateTime dtCriacao;


    @Enumerated(EnumType.STRING)
    private Perfil perfil;
    private Boolean ativo;

    public Usuario(DadosCadastroUsuario dados) {
        this.login = dados.login();
        this.senha = dados.senha();
        this.perfil = dados.perfil();
        this.ativo = true;
        this.dtCriacao = LocalDateTime.now();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + perfil.name()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoUsuario dados) {
    }

    public void excluir() {
    }
}
