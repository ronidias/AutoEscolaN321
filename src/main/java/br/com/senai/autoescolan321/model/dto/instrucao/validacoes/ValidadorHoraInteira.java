package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.infra.exception.ValidacaoException;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;

import java.time.LocalDateTime;

public class ValidadorHoraInteira implements ValidadorAgendamento {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime dataAgendamento = dados.data();
        if(dataAgendamento.getMinute() != 0 || dataAgendamento.getSecond() != 0) {
            throw new ValidacaoException("A instrução deve ser agendada em hora cheia(ex: 08:88, 10:00, ...");
        }
    }
}
