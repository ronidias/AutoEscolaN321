package br.com.senai.autoescolan321.adapters.in.controller.mapper;

import br.com.senai.autoescolan321.adapters.in.controller.request.endereco.DadosEndereco;
import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
    public Endereco toEntity(DadosEndereco dados) {
        return new Endereco(
                dados.logradouro(),
                dados.numero(),
                dados.complemento(),
                dados.bairro(),
                dados.cidade(),
                dados.uf(),
                dados.cep()
        );
    }

    public DadosEndereco toDTO(Endereco endereco) {
        return new DadosEndereco(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getCep()
        );
    }

    public void updateVOFromDTO(DadosEndereco dados, Endereco endereco) {
        if(dados.logradouro() != null) {
            endereco.setLogradouro(dados.logradouro());
        }
        if(dados.numero() != null) {
            endereco.setNumero(dados.numero());
        }
        if(dados.complemento() != null) {
            endereco.setComplemento(dados.complemento());
        }
        if(dados.bairro() != null) {
            endereco.setBairro(dados.bairro());
        }
        if(dados.cidade() != null) {
            endereco.setCidade(dados.cidade());
        }
        if(dados.uf() != null) {
            endereco.setUf(dados.uf());
        }
        if(dados.cep() != null) {
            endereco.setCep(dados.cep());
        }
    }
}