package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.in.dto.instrutor.enums.Especialidade;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface InstrutorRepository extends JpaRepository<Instrutor, Long> {
    Page<Instrutor> findAllByAtivoTrue(Pageable paginacao);

    Optional<Instrutor> findByIdAndAtivoTrue(Long id);

    @Query("""
            SELECT i FROM Instrutor i
            WHERE i.ativo = true
                AND i.especialidade = :especialidade
                AND i.id NOT IN (
                    SELECT a.instrutor.id
                    WHERE a.data = :data
                        AND a.cancelada = false
                )
            ORDER BY RAND() LIMIT 1
            """)
    Instrutor escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data);
}
