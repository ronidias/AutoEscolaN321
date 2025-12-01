package br.com.senai.autoescolan321.adapters.out.viacep;

import br.com.senai.autoescolan321.adapters.in.controller.mapper.EnderecoMapper;
import br.com.senai.autoescolan321.adapters.in.controller.request.endereco.DadosEndereco;
import br.com.senai.autoescolan321.adapters.in.controller.response.viacep.DadosViaCEPResponse;
import br.com.senai.autoescolan321.adapters.out.viacep.mapper.ViaCEPMapper;
import br.com.senai.autoescolan321.application.core.domain.vo.Endereco;
import br.com.senai.autoescolan321.application.ports.out.ViaCEPPort;
import com.google.gson.Gson;
import org.apache.http.client.fluent.Request;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ViaCEPAdapter implements ViaCEPPort {
    private final String URL = "https://viacep.com.br/ws/%s/json/";
    private final EnderecoMapper enderecoMapper;
    private final ViaCEPMapper viaCEPMapper;

    public ViaCEPAdapter(
            EnderecoMapper enderecoMapper,
            ViaCEPMapper viaCEPMapper) {
        this.enderecoMapper = enderecoMapper;
        this.viaCEPMapper = viaCEPMapper;
    }

    @Override
    public Endereco buscarEnderecoPorCEP(String cep) {
        try {
            String url = URL.formatted(cep);
            String jsonResponse = Request.Get(url)
                    .connectTimeout(10000)
                    .socketTimeout(10000)
                    .execute()
                    .returnContent()
                    .asString();
            DadosViaCEPResponse viaCEP = new Gson()
                    .fromJson(jsonResponse, DadosViaCEPResponse.class);
            DadosEndereco dto = viaCEPMapper.toDadosEndereco(viaCEP);
            return enderecoMapper.toEntity(dto);
        } catch(IOException e) {
            throw new RuntimeException("Erro ao buscar o endereço! ", e);
        }
    }
}