package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.InstrutorEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.mapper.InstrutorEntityMapper;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.InstrutorJpaRepository;
import br.com.senai.autoescola_n321.application.core.domain.enums.Especialidade;
import br.com.senai.autoescola_n321.application.core.domain.model.Instrutor;
import br.com.senai.autoescola_n321.application.ports.out.InstrutorRepository;
import br.com.senai.autoescola_n321.exception.types.business.InstrutorIndisponivelException;
import br.com.senai.autoescola_n321.exception.types.business.InstrutorNaoExisteException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
public class InstrutorRepositoryImpl implements InstrutorRepository {

    private final InstrutorJpaRepository repository;
    private final InstrutorEntityMapper mapper;

    public InstrutorRepositoryImpl(InstrutorJpaRepository repository, InstrutorEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Instrutor> findAllByAtivoTrue(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(mapper::toDomain);
    }

    @Override
    public Optional<Instrutor> findByIdAndAtivoTrue(Long id) {
        return repository.findByIdAndAtivoTrue(id).map(mapper::toDomain)
                .orElseThrow(() -> new InstrutorNaoExisteException("Instrutor não encontrado ou inativo"));
    }

    @Override
    public Optional<Instrutor> escolherInstrutorDisponivel(Especialidade especialidade, LocalDateTime data) {
        return Optional.ofNullable(repository.escolherInstrutorDisponivel(especialidade, data)
                .orElseThrow(() -> new InstrutorIndisponivelException(
                        "Nenhum instrutor com horário disponível para a data: " + data.toString())));
    }

    @Override
    public Instrutor save(Instrutor instrutor) {
        InstrutorEntity entity = mapper.toEntity(instrutor);
        return mapper.toDomain(repository.save(entity));
    }

    @Override
    public Optional<Instrutor> findById(Long id) {
        return Optional.ofNullable(repository.findById(id).map(mapper::toDomain)
                .orElseThrow(() -> new InstrutorNaoExisteException("Instrutor não existe.")));
    }
}
