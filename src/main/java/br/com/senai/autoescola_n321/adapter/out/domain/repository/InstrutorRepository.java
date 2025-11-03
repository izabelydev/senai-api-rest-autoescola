package br.com.senai.autoescola_n321.adapter.out.domain.repository;

import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    Page<Instrutor> findAllByAtivoTrue(Pageable paginacao);

    Instrutor findByIdAndAtivoTrue(Long id);
}
