package br.com.senai.autoescolan321.adapters.out.repository.persistence;

import br.com.senai.autoescolan321.application.core.domain.model.Instrucao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {
    Boolean existsByInstrutorIdAndDataAndCanceladaFalse(Long id, LocalDateTime data);

    Boolean existsByAlunoIdAndDataBetweenAndCanceladaFalse(Long aluno_id, LocalDateTime inicioExpediente, LocalDateTime fimExpediente);
}