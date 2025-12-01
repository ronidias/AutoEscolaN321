package br.com.senai.autoescolan321.application.core.validations.instrucao.impl.agendamento;

import br.com.senai.autoescolan321.adapters.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.adapters.out.repository.persistence.InstrucaoJpaRepository;
import br.com.senai.autoescolan321.exception.types.instrucao.ValidacaoException;
import br.com.senai.autoescolan321.application.core.validations.instrucao.interfaces.ValidadoresAgendamento;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorLimiteDiarioAluno implements ValidadoresAgendamento {
    private final InstrucaoJpaRepository instrucaoJpaRepository;

    public ValidadorLimiteDiarioAluno(InstrucaoJpaRepository instrucaoJpaRepository) {
        this.instrucaoJpaRepository = instrucaoJpaRepository;
    }

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime inicioExpediente = dados.data().withHour(6);
        LocalDateTime fimExpediente = dados.data().withHour(21 - 1);
        Boolean alunoReincidenciaDiaria = instrucaoJpaRepository
                .existsByAlunoIdAndDataBetweenAndCanceladaFalse(dados.idAluno(), inicioExpediente, fimExpediente);

        if(alunoReincidenciaDiaria) {
            throw new ValidacaoException("Permitido o agendamento de apenas uma instrução por dia, para cada aluno!");
        }
    }
}