package br.com.senai.autoescola_n321.application.ports.out;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UsuarioRepository {
    Usuario save(UsuarioEntity usuario);

    Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao);

    Optional<UsuarioEntity> findByIdAndAtivoTrue(Long id);

    Optional<UsuarioEntity> findById(Long id);
}
