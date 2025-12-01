package br.com.senai.autoescolan321.application.ports.out;

import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;

public interface ViaCEPPort {
    Endereco buscarEnderecoPorCEP(String cep);
}