package br.com.senai.autoescolan321.adapters.in.controller;

import br.com.senai.autoescolan321.adapters.in.controller.request.usuario.DadosAutenticacao;
import br.com.senai.autoescolan321.application.core.usecases.LoginService;
import br.com.senai.autoescolan321.security.dto.DadosTokenJWT;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {
    private final LoginService loginService;

    public AutenticacaoController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping
    public ResponseEntity<DadosTokenJWT> efetuarLogin(
            @RequestBody @Valid DadosAutenticacao dados) {
        return ResponseEntity.ok(loginService.logar(dados));
    }
}