package br.com.senai.autoescolan321.adapters.in.controller.response.viacep;

public record DadosViaCEPResponse(
        String cep,
        String logradouro,
        String complemento,
        String unidade,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String regiao,
        String ibge,
        String gia,
        String ddd,
        String siafi) {
}