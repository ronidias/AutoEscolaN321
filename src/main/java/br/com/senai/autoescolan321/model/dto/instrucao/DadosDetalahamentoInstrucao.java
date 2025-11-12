package br.com.senai.autoescolan321.model.dto.instrucao;

import br.com.senai.autoescolan321.domain.Instrucao;
import br.com.senai.autoescolan321.enumeration.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalahamentoInstrucao(
        Long id,
        String nomeAluno,
        String nomeInstrutor,
        Especialidade especialidade,
        @JsonFormat (pattern = "dd/MM/yyyy - HH:mm")
        LocalDateTime data,
        Boolean cancelada) {

    public DadosDetalahamentoInstrucao (Instrucao instrucao){
        this(
                instrucao.getId(),
                instrucao.getAluno().getNome(),
                instrucao.getInstrutor().getNome(),
                instrucao.getInstrutor().getEspecialidade(),
                instrucao.getData(),
                instrucao.getCancelada()
        );

    }

}
