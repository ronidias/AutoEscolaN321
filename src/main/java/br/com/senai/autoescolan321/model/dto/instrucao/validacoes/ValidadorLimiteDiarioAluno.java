package br.com.senai.autoescolan321.model.dto.instrucao.validacoes;

import br.com.senai.autoescolan321.model.dto.instrucao.DadosAgendamentoInstrucao;
import br.com.senai.autoescolan321.repository.InstrucaoRepository;
import br.com.senai.autoescolan321.repository.ValidadorAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidadorLimiteDiarioAluno implements ValidadorAgendamento {

  @Autowired
  private InstrucaoRepository instrucaoRepository;


    @Override
    public void validar(DadosAgendamentoInstrucao dados) {

        LocalDateTime inicioExpediente = dados.data().withHour(6);
        LocalDateTime fimExpediente = dados.data().withHour(21 - 1);
        Boolean alunoReiniciaDia = instrucaoRepository.existsByAlunoIdAndDataBetweenAndCanceladaFalse(dados.idAluno(), inicioExpediente, fimExpediente);

        if(alunoReiniciaDia) {
            throw new RuntimeException("O Aluno já atingiu o limite diário de instruções agendadas.");

    }
  }
}
