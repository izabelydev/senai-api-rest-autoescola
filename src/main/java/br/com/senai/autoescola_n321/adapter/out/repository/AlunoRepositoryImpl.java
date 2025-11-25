package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.AlunoEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.mapper.AlunoEntityMapper;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.AlunoJpaRepository;
import br.com.senai.autoescola_n321.application.core.domain.model.Aluno;
import br.com.senai.autoescola_n321.application.ports.out.AlunoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AlunoRepositoryImpl implements AlunoRepository {

    private final AlunoJpaRepository repository;
    private final AlunoEntityMapper mapper;

    public AlunoRepositoryImpl(AlunoJpaRepository repository, AlunoEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Boolean existsByIdAndAtivoTrue(Long id) {
        return repository.existsByIdAndAtivoTrue(id);
    }

    @Override
    public Optional<AlunoEntity> findByIdAndAtivoTrue(Long id) {
        return repository.findByIdAndAtivoTrue(id);
    }

    @Override
    public Aluno save(AlunoEntity aluno) {
        return mapper.toDomain(repository.save(aluno));
    }

    @Override
    public Page<AlunoEntity> findAllByAtivoTrue(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao);
    }

    @Override
    public Optional<AlunoEntity> findById(Long id) {
        return repository.findById(id);
    }
}
