package br.com.senai.autoescolan321.adapters.in.controller;

import br.com.senai.autoescolan321.adapters.in.controller.response.viacep.DadosEnderecoViaCEPResponse;
import br.com.senai.autoescolan321.application.core.usecases.ViaCEPService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cep")
@SecurityRequirement(name = "bearer-key")
public class ViaCEPController {
    private final ViaCEPService viaCEPService;

    public ViaCEPController(ViaCEPService viaCEPService) {
        this.viaCEPService = viaCEPService;
    }

    @GetMapping("/{cep}")
    public ResponseEntity<DadosEnderecoViaCEPResponse> buscarEndereco(@PathVariable String cep) {
        return ResponseEntity.ok(viaCEPService.buscar(cep));
    }
}