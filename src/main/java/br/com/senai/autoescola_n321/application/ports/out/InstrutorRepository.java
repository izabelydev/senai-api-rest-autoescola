package br.com.senai.autoescola_n321.application.ports.out;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface InstrutorRepository {
    Page<InstrutorEntity> findAllByAtivoTrue(Pageable paginacao);

    Optional<InstrutorEntity> findByIdAndAtivoTrue(Long id);

    Optional<InstrutorEntity> escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data);

    InstrutorEntity save(InstrutorEntity instrutor);

    Optional<InstrutorEntity> findById(Long id);
}
