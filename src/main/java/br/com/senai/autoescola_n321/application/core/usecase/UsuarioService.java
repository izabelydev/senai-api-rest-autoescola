package br.com.senai.autoescola_n321.application.core.usecase;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosCadastramentoUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.mapper.UsuarioMapper;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.ports.out.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public DadosDetalhamentoInstrucao cadastrar(@Valid DadosCadastramentoUsuario dados) {
        UsuarioEntity usuario = usuarioMapper.toEntity(dados);
        usuarioRepository.save(usuario);
    }
}
