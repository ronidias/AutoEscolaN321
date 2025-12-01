package br.com.senai.autoescolan321.adapters.out.viacep.mapper;

import br.com.senai.autoescolan321.adapters.in.controller.request.endereco.DadosEndereco;
import br.com.senai.autoescolan321.adapters.in.controller.response.viacep.DadosEnderecoViaCEPResponse;
import br.com.senai.autoescolan321.adapters.in.controller.response.viacep.DadosViaCEPResponse;
import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;
import org.springframework.stereotype.Component;

@Component
public class ViaCEPMapper {
    public DadosEnderecoViaCEPResponse toDetailsDTO(Endereco endereco) {
        return new DadosEnderecoViaCEPResponse(
                endereco.getLogradouro(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf()
        );
    }

    public DadosEndereco toDadosEndereco(DadosViaCEPResponse dados) {
        return new DadosEndereco(
                dados.logradouro(),
                null,
                null,
                dados.bairro(),
                dados.localidade(),
                dados.uf(),
                dados.cep()
        );
    }
}