package br.com.senai.autoescolan321.repository;

import br.com.senai.autoescolan321.domain.Instrucao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {
    Boolean existsByInstrutorIdAndDataAndCanceladaFalse(Long id, LocalDateTime data);
}
