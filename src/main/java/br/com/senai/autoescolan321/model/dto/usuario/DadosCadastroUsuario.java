package br.com.senai.autoescolan321.model.dto.usuario;

import br.com.senai.autoescolan321.enumeration.Perfil;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public record DadosCadastroUsuario(

        @NotBlank
        String id,

        @NotBlank
        @Email
        String login,

        @NotBlank
        String senha,

        @NotNull
        Perfil perfil,

        @NotNull
        @Column(name = "dt_criacao")
        LocalDateTime dtCriacao) {

}