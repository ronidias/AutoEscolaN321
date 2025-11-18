package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.infra.exception.ValidacaoException;
import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.repository.ValidadorAgendamento;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamento {
    @Override
    public void validar(DadosAgendamentoInstrucao dados) {

        LocalDateTime dataAgendamento = dados.data();
        LocalDateTime agora = LocalDateTime.now();

        Long antecedencia = Duration.between(agora, dataAgendamento).toMinutes();

        if(antecedencia < 30) {
            throw new ValidacaoException("As instruções devem ser agendadas com no mínimo 30 minutos de antecedência.");
        }

    }


}
