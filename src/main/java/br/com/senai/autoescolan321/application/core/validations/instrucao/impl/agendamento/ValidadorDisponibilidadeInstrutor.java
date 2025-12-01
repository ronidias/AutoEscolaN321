package br.com.senai.autoescolan321.application.core.validations.instrucao.impl.agendamento;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrucaoJpaRepository;
import br.com.senai.autoescolan321.exception.types.instrucao.ValidacaoException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresAgendamento;
import org.springframework.stereotype.Component;

@Component
public class ValidadorDisponibilidadeInstrutor implements ValidadoresAgendamento {
    private final InstrucaoJpaRepository instrucaoJpaRepository;

    public ValidadorDisponibilidadeInstrutor(InstrucaoJpaRepository instrucaoJpaRepository) {
        this.instrucaoJpaRepository = instrucaoJpaRepository;
    }

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Boolean instutorOcupado = instrucaoJpaRepository.existsByInstrutorIdAndDataAndCanceladaFalse(dados.idInstrutor(), dados.data());

        if(instutorOcupado) {
            throw new ValidacaoException("Instrutor ocupado na data e horário informados!");
        }
    }
}