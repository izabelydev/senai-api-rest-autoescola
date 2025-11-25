package br.com.senai.autoescola_n321.application.ports.out;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;

public interface UsuarioRepository {
    UsuarioEntity save(UsuarioEntity usuario);

}
