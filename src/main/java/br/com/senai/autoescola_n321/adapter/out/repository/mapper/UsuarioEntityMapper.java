package br.com.senai.autoescola_n321.adapter.out.repository.mapper;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioEntityMapper {

    public UsuarioEntity toEntity(Usuario domain) {
        return new UsuarioEntity(
                domain.getId(),
                domain.getLogin(),
                domain.getSenha(),
                domain.getPerfil(),
                domain.getAtivo()
        );
    }

    public Usuario toDomain(UsuarioEntity entity) {
        return new Usuario(
                entity.getId(),
                entity.getLogin(),
                entity.getSenha(),
                entity.getPerfil(),
                entity.getAtivo()
        );
    }
}
