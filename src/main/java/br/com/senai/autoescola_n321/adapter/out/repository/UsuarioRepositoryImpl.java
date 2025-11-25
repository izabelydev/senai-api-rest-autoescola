package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.mapper.UsuarioEntityMapper;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.UsuarioJpaRepository;
import br.com.senai.autoescola_n321.application.core.domain.model.Usuario;
import br.com.senai.autoescola_n321.application.ports.out.UsuarioRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final UsuarioJpaRepository repository;
    private final UsuarioEntityMapper mapper;

    public UsuarioRepositoryImpl(UsuarioJpaRepository usuarioJpaRepository, UsuarioEntityMapper mapper) {
        this.repository = usuarioJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Usuario save(UsuarioEntity usuario) {
        return mapper.toDomain(repository.save(usuario));
    }

    @Override
    public Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao);
    }

    @Override
    public Optional<UsuarioEntity> findByIdAndAtivoTrue(Long id) {
        return repository.findByIdAndAtivoTrue(id);
    }

    @Override
    public Optional<UsuarioEntity> findById(Long id) {
        return repository.findById(id);
    }
}
