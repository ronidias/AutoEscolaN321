package br.com.senai.autoescolan321.application.ports.out;

import br.com.senai.autoescolan321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescolan321.application.core.domain.model.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface InstrutorRepository {
    Instrutor save(Instrutor instrutor);
    Page<Instrutor> findAllByAtivoTrue(Pageable paginacao);
    Optional<Instrutor> findById(Long id);
    Instrutor escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data);
}