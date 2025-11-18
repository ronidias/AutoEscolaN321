package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.infra.exception.ValidacaoException;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.repository.InstrutorRepository;
import br.com.senai.autoescolan321.repository.ValidadorAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorInstrutorAtivo implements ValidadorAgendamento {

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor() == null){
            return;
        }

        Boolean instrutorAtivo = instrutorRepository.findInstrutorAtivoById(dados.idInstrutor());

        if(!instrutorAtivo){
            throw new ValidacaoException("Instrutor não está ativo no sistema.");
        }

    }
}

