package br.com.senai.autoescolan321.adapters.in.controller.mapper;

import br.com.senai.autoescolan321.adapters.in.controller.response.instrucao.DadosDetalhamentoCancelamento;
import br.com.senai.autoescolan321.adapters.in.controller.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescolan321.application.core.domain.model.Aluno;
import br.com.senai.autoescolan321.application.core.domain.model.Instrucao;
import br.com.senai.autoescolan321.application.core.domain.model.Instrutor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class InstrucaoMapper {
    public Instrucao toEntity(Aluno aluno, Instrutor instrutor, LocalDateTime data) {
        return new Instrucao(
                null,
                aluno,
                instrutor,
                data,
                false,
                null,
                null
        );
    }

    public DadosDetalhamentoInstrucao toDetailsDTO(Instrucao instrucao) {
        return new DadosDetalhamentoInstrucao(
                instrucao.getId(),
                instrucao.getAluno().getNome(),
                instrucao.getInstrutor().getNome(),
                instrucao.getInstrutor().getEspecialidade(),
                instrucao.getData(),
                instrucao.getCancelada()
        );
    }

    public DadosDetalhamentoCancelamento toDetailsCancelDTO(Instrucao instrucao) {
        return new DadosDetalhamentoCancelamento(
                instrucao.getId(),
                instrucao.getDataCancelamento(),
                instrucao.getMotivo()
        );
    }
}