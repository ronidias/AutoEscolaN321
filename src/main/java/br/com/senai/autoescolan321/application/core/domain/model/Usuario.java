package br.com.senai.autoescolan321.application.core.domain.model;

import br.com.senai.autoescolan321.application.core.domain.enums.Perfil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class Usuario implements UserDetails {
    private Long id;
    private String login;
    private String senha;
    private Perfil perfil;
    private Boolean ativo;

    public Usuario() {}

    public Usuario(
            Long id,
            String login,
            String senha,
            Perfil perfil,
            Boolean ativo) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.perfil = perfil;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + perfil));
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

    public void atualizarPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public Boolean isAtivo() {
        return ativo;
    }

    /*public void excluir() {
        this.ativo = false;
    }*/
}