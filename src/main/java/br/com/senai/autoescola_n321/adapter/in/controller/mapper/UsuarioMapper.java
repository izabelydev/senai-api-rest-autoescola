package br.com.senai.autoescola_n321.adapter.in.controller.mapper;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoPerfilUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoSenhaUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosCadastramentoUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public UsuarioEntity toEntity(DadosCadastramentoUsuario dados) {
        return new UsuarioEntity(
               null,
                dados.login(),
                dados.senha(),
                dados.perfil(),
                null
        );
    }

    public DadosDetalhamentoUsuario toDetailsDto(UsuarioEntity dados) {
        return new DadosDetalhamentoUsuario(
                dados.getId(),
                dados.getAtivo(),
                dados.getLogin(),
                dados.getPerfil()
        );
    }

    public void atualizarPerfilDtoToEntity(DadosAtualizacaoPerfilUsuario dados, UsuarioEntity usuario) {
        if(!isNull(dados.perfil())) {
            usuario.setPerfil(dados.perfil());
        }
    }

    public void atualizarSenhaDtoToEntity(DadosAtualizacaoSenhaUsuario dados, BCryptPasswordEncoder passwordEncoder, UsuarioEntity usuario) {
        if(!isNull(dados.novaSenha())) {
            usuario.setSenha(passwordEncoder.encode(dados.novaSenha()));
        }
    }
}
