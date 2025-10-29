package br.com.senai.autoescolan321.repository;




import br.com.senai.autoescolan321.entity.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor,Long> {
    Page <Instrutor> findAllByAtivoTrue(Pageable paginacao);
}
