package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import org.springframework.stereotype.Component;

@Component
public class ValidadorLimiteDiarioAluno implements ValidadorAgendamento {

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        int limiteDiario = 1;
        int instrucoesAgendadasHoje = 0;
        if (instrucoesAgendadasHoje >= limiteDiario) {
            throw new RuntimeException("O aluno atingiu o limite diário de instruções agendadas.");
        }


    }
}
