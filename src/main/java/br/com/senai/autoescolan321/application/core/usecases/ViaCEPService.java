package br.com.senai.autoescolan321.application.core.usecases;

import br.com.senai.autoescolan321.adapters.in.controller.response.viacep.DadosEnderecoViaCEPResponse;
import br.com.senai.autoescolan321.adapters.out.viacep.mapper.ViaCEPMapper;
import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;
import br.com.senai.autoescolan321.application.ports.out.ViaCEPPort;
import org.springframework.stereotype.Service;

@Service
public class ViaCEPService {
    private final ViaCEPPort viaCEPPort;
    private final ViaCEPMapper viaCEPMapper;

    public ViaCEPService(
            ViaCEPPort viaCEPPort,
            ViaCEPMapper viaCEPMapper) {
        this.viaCEPPort = viaCEPPort;
        this.viaCEPMapper = viaCEPMapper;
    }
    public DadosEnderecoViaCEPResponse buscar(String cep) {
        Endereco endereco = viaCEPPort.buscarEnderecoPorCEP(cep);
        return viaCEPMapper.toDetailsDTO(endereco);
    }
}