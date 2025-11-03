package br.com.senai.autoescola_n321.adapter.out.domain.repository;

import br.com.senai.autoescola_n321.adapter.out.domain.entity.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);
}
