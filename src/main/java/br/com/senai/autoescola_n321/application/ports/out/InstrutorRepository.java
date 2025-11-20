package br.com.senai.autoescola_n321.application.ports.out;

import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.Optional;

public interface InstrutorRepository {
    Page<Instrutor> findAllByAtivoTrue(Pageable paginacao);

    Optional<Instrutor> findByIdAndAtivoTrue(Long id);

    Optional<Instrutor> escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data);

    Instrutor save(Instrutor instrutor);

    Optional<Instrutor> findById(Long id);
}
