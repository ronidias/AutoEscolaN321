package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.infra.exception.ValidacaoException;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamento implements ValidadorAgendamento {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataAgendamento = dados.data();
        Boolean domingo = dataAgendamento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        Boolean preAbertura = dataAgendamento.getHour() < 6;
        Boolean posFechamento = dataAgendamento.getHour() > (21 - 1);

        if(domingo || preAbertura || posFechamento) {
            throw new ValidacaoException("Horário fora do funcionamento da autoescola");
        }
    }
}
