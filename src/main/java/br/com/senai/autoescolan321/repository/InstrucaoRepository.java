package br.com.senai.autoescolan321.repository;

import br.com.senai.autoescolan321.domain.Instrucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {
}
