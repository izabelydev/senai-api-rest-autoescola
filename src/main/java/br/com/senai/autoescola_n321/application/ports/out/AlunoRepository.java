package br.com.senai.autoescola_n321.application.ports.out;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface AlunoRepository {
    Boolean existsByIdAndAtivoTrue(Long aLong);

    Optional<AlunoEntity> findByIdAndAtivoTrue(Long id);

    Aluno save(AlunoEntity aluno);

    Page<AlunoEntity> findAllByAtivoTrue(Pageable paginacao);

    Optional<AlunoEntity> findById(Long id);
}
