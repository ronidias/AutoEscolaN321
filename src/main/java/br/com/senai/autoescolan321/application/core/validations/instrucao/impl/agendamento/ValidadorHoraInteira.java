package br.com.senai.autoescolan321.application.core.validations.instrucao.impl.agendamento;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.exception.types.instrucao.ValidacaoException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresAgendamento;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorHoraInteira implements ValidadoresAgendamento {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataAgendamento = dados.data();

        if(dataAgendamento.getMinute() != 0) {
            throw new ValidacaoException("Preencher somente horas inteiras (ex: 08:00, 10:00, ...!");
        }
    }
}