package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.out.repository.persistence.AlunoJpaRepository;
import br.com.senai.autoescola_n321.application.ports.out.AlunoRepository;
import org.springframework.stereotype.Component;

@Component
public class AlunoRepositoryImpl implements AlunoRepository {

    private final AlunoJpaRepository repository;

    public AlunoRepositoryImpl(AlunoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean existsByIdAndAtivoTrue(Long id) {
        return repository.existsByIdAndAtivoTrue(id);
    }
}
