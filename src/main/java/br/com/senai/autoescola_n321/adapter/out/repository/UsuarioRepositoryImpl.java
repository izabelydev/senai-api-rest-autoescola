package br.com.senai.autoescola_n321.adapter.out.repository;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.adapter.out.repository.mapper.UsuarioEntityMapper;
import br.com.senai.autoescola_n321.adapter.out.repository.persistence.UsuarioJpaRepository;
import br.com.senai.autoescola_n321.application.ports.out.UsuarioRepository;

public class UsuarioRepositoryImpl implements UsuarioRepository {

    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioEntityMapper mapper;

    public UsuarioRepositoryImpl(UsuarioJpaRepository usuarioJpaRepository, UsuarioEntityMapper mapper) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.mapper = mapper;
    }

    @Override
    public UsuarioEntity save(UsuarioEntity usuario) {
        return mapper.toDomain(usuarioJpaRepository.save(usuario));
    }
}
