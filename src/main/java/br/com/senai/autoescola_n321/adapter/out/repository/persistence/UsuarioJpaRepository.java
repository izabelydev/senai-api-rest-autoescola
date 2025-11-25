package br.com.senai.autoescola_n321.adapter.out.repository.persistence;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Usuario;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {

    UserDetails findByLogin(String login);

    Page<UsuarioEntity> findAllByAtivoTrue(Pageable paginacao);

    Optional<UsuarioEntity> findByIdAndAtivoTrue(@NotNull Long id);
}
