package br.com.senai.autoescola_n321.adapter.in.dto.usuario;

import br.com.senai.autoescola_n321.adapter.out.domain.entity.Usuario;
import br.com.senai.autoescola_n321.adapter.in.dto.usuario.enums.Perfil;

public record DadosDetalhamentoUsuario(
        Long id,
        Boolean ativo,
        String login,
        Perfil perfil
) {
    public DadosDetalhamentoUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getAtivo(),
                usuario.getLogin(),
                usuario.getPerfil()
        );
    }
}
