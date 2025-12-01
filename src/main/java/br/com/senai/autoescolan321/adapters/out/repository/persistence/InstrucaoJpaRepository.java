package br.com.senai.autoescolan321.adapters.out.repository.persistence;

import br.com.senai.autoescolan321.adapters.out.repository.entity.InstrucaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface InstrucaoJpaRepository extends JpaRepository<InstrucaoEntity, Long> {
    Boolean existsByInstrutorIdAndDataAndCanceladaFalse(Long id, LocalDateTime data);
    Boolean existsByAlunoIdAndDataBetweenAndCanceladaFalse(Long aluno_id, LocalDateTime inicioExpediente, LocalDateTime fimExpediente);
}