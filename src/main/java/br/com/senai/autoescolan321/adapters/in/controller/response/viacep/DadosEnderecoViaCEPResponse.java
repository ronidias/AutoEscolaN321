package br.com.senai.autoescolan321.adapters.in.controller.response.viacep;

public record DadosEnderecoViaCEPResponse(
        String logradouro,
        String bairro,
        String cidade,
        String uf) {
}