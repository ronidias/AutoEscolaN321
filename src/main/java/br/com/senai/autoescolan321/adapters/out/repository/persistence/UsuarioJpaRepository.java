package br.com.senai.autoescolan321.adapters.out.repository.persistence;

import br.com.senai.autoescolan321.adapters.out.repository.entity.UsuarioEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByLogin(String login);
    Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao);
}