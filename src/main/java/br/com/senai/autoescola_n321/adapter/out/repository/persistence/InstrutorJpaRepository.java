package br.com.senai.autoescola_n321.adapter.out.repository.persistence;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface InstrutorJpaRepository extends JpaRepository<InstrutorEntity, Long> {
    Page<Instrutor> findAllByAtivoTrue(Pageable paginacao);

    Optional<Instrutor> findByIdAndAtivoTrue(Long id);

    @Query("""
            SELECT i FROM Instrutor i
            WHERE i.ativo = true
                AND i.especialidade = :especialidade
                AND i.id NOT IN (
                    SELECT a.instrutor.id FROM Instrucao a
                    WHERE a.data = :data
                        AND a.cancelada = false
                )
            ORDER BY RAND() LIMIT 1
            """)
    Optional<Instrutor> escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data);
}
