package br.com.senai.autoescola_n321.adapter.out.repository.persistence;

import br.com.senai.autoescola_n321.application.core.domain.model.Aluno;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);

    Optional<Aluno> findAllByIdAndAtivoTrue(@NotNull Long id);

    Boolean existsByIdAndAtivoTrue(@NotNull Long aLong);
}
