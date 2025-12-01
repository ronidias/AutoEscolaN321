package br.com.senai.autoescolan321.application.ports.out;

import br.com.senai.autoescolan321.application.core.domain.model.Instrucao;

import java.util.Optional;

public interface InstrucaoRepository {
    Instrucao save(Instrucao instrucao);
    Optional<Instrucao> findById(Long id);
}