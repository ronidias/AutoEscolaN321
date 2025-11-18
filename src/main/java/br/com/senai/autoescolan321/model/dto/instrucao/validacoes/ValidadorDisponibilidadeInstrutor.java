package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.infra.exception.ValidacaoException;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.repository.InstrucaoRepository;
import br.com.senai.autoescolan321.repository.ValidadorAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDisponibilidadeInstrutor implements ValidadorAgendamento {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
       Boolean instrutorOcupado = instrucaoRepository.existsByInstrutorIdAndDataAndCanceladaFalse(dados.idInstrutor(), dados.data());
       if(instrutorOcupado) {
           throw new ValidacaoException("Instrutor não está disponível nesse horário.");
       }

    }
}
