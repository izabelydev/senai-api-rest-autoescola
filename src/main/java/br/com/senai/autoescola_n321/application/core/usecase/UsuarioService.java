package br.com.senai.autoescola_n321.application.core.usecase;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoPerfilUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoSenhaUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosCadastramentoUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.mapper.UsuarioMapper;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.ports.out.UsuarioRepository;
import br.com.senai.autoescola_n321.exception.types.business.UsuarioNaoExisteException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public DadosDetalhamentoUsuario cadastrar(DadosCadastramentoUsuario dados) {
        UsuarioEntity usuario = usuarioMapper.toEntity(dados, passwordEncoder);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDetailsDto(usuario);
    }

    public Page<DadosDetalhamentoUsuario> listar(Pageable paginacao) {
        return usuarioRepository.findAllByAtivoTrue(paginacao).map(usuarioMapper::toDetailsDto);
    }

    @Transactional
    public DadosDetalhamentoUsuario atualizarPerfil(DadosAtualizacaoPerfilUsuario dados) {
        UsuarioEntity usuario = getUsuario(dados.id());
        usuarioMapper.atualizarPerfilDtoToEntity(dados, usuario);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDetailsDto(usuario);
    }

    @Transactional
    public void atualizarSenha(DadosAtualizacaoSenhaUsuario dados) {
        UsuarioEntity usuario = getUsuario(dados.id());

        usuarioMapper.atualizarSenhaDtoToEntity(dados, passwordEncoder, usuario);
        usuarioRepository.save(usuario);
    }

    @Transactional
    public DadosDetalhamentoUsuario apagar(Long id) {
        UsuarioEntity usuario = getUsuario(id);
        usuario.setAtivo(false);
        usuarioRepository.save(usuario);
        return usuarioMapper.toDetailsDto(usuario);
    }

    public DadosDetalhamentoUsuario detalhar(Long id) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não encontrado"));

        return usuarioMapper.toDetailsDto(usuario);
    }

    private UsuarioEntity getUsuario(Long id) {
        return usuarioRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não encontrado ou inativo"));
    }
}
