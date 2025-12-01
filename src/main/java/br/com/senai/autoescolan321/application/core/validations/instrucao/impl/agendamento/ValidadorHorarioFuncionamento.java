package br.com.senai.autoescolan321.application.core.validations.instrucao.impl.agendamento;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.exception.types.instrucao.ValidacaoException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresAgendamento;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamento implements ValidadoresAgendamento {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataAgendamento = dados.data();

        Boolean domingo = dataAgendamento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        Boolean preAbertura = dataAgendamento.getHour() < 6;
        Boolean posFechamento = dataAgendamento.getHour() > (21 - 1);

        if(domingo || preAbertura || posFechamento) {
            throw new ValidacaoException("Tentativa de agendamento fora do horário de fucionamento da auto-escola!");
        }
    }
}