package br.com.senai.autoescolan321.model.dto.instrucao;

import br.com.senai.autoescolan321.domain.Instrucao;
import br.com.senai.autoescolan321.enumeration.Motivo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoCancelamento(

        Long id,

        @JsonFormat (pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime dataCancelamento,

        Motivo motivo){

        public DadosDetalhamentoCancelamento (Instrucao instrucao){
            this(
                    instrucao.getId(),
                    instrucao.getDataCancelamento(),
                    instrucao.getMotivo()
        );
    }
}

