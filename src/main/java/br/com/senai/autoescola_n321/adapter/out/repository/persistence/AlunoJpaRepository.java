package br.com.senai.autoescola_n321.adapter.out.repository.persistence;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoJpaRepository extends JpaRepository<AlunoEntity, Long> {
    Page<AlunoEntity> findAllByAtivoTrue(Pageable paginacao);

    Optional<AlunoEntity> findAllByIdAndAtivoTrue(Long id);

    Boolean existsByIdAndAtivoTrue(Long aLong);
}
