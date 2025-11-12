package br.com.senai.autoescolan321.repository;


import br.com.senai.autoescolan321.domain.Aluno;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);


    @Query("""
            SELECT a.ativo
            FROM Aluno a
            WHERE a.id = :id
            """)
    Boolean findAlunoAtivoById( Long id);
}
