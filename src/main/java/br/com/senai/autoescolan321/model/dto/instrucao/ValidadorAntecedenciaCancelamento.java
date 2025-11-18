package br.com.senai.autoescolan321.model.dto.instrucao;

import br.com.senai.autoescolan321.infra.exception.ValidacaoException;
import br.com.senai.autoescolan321.repository.InstrucaoRepository;
import br.com.senai.autoescolan321.repository.ValidadorCancelamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
public class ValidadorAntecedenciaCancelamento implements ValidadorCancelamento {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Override
    public void validar(DadosCancelamentoInstrucao dados) {
        LocalDateTime dataAgendamento = instrucaoRepository.getReferenceById(dados.idInstrucao()).getData();
        LocalDateTime agora = LocalDateTime.now();

        Long antecedencia = Duration.between(agora, dataAgendamento).toHours();

        if(antecedencia < 24) {
            throw new ValidacaoException("As instruções devem ser agendadas com no mínimo 24 horas de antecedência.");
        }

    }

    }

