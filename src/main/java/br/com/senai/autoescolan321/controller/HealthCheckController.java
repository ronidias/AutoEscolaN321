package br.com.senai.autoescolan321.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health-check")
public class HealthCheckController {

    @GetMapping
    public String healthCheck() {
        return "Verificação de integridade da API da Auto Escola N-321!";
    }
}