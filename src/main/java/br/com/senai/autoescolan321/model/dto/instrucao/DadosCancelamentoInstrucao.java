package br.com.senai.autoescolan321.model.dto.instrucao;

import br.com.senai.autoescolan321.enumeration.Motivo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosCancelamentoInstrucao(

    @NotNull
    Long idInstrucao,

    @NotNull
    Motivo motivo,

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    LocalDateTime dataCancelamento

) {
}
