package br.com.senai.autoescola_n321.adapter.in.controller.dto.response.usuario;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Usuario;
import br.com.senai.autoescola_n321.application.core.domain.enums.Perfil;

public record DadosDetalhamentoUsuario(
        Long id,
        Boolean ativo,
        String login,
        Perfil perfil
) {
    public DadosDetalhamentoUsuario(UsuarioEntity usuario) {
        this(
                usuario.getId(),
                usuario.getAtivo(),
                usuario.getLogin(),
                usuario.getPerfil()
        );
    }
}
