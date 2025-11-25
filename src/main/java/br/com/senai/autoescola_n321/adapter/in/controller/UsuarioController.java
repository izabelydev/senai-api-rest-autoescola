package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoPerfilUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoSenhaUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosCadastramentoUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.core.usecase.UsuarioService;
import br.com.senai.autoescola_n321.exception.types.business.UsuarioNaoExisteException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@AllArgsConstructor
@RestController
@RequestMapping("/usuario")
@PreAuthorize("hasAnyRole('OWNER', 'ADM')")
public class UsuarioController {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrarUsuario(
            @RequestBody @Valid DadosCadastramentoUsuario dados,
            UriComponentsBuilder uriBuilder
    ) {
        DadosDetalhamentoInstrucao dto = usuarioService.cadastrar(dados);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    @GetMapping("/listar-usuarios")
    public ResponseEntity<Page<DadosDetalhamentoUsuario>> listarUsuarios (
            @PageableDefault(size=5, sort={"login"}) Pageable paginacao
    ) {
        Page<DadosDetalhamentoUsuario> page = usuarioJpaRepository.findAllByAtivoTrue(paginacao)
                .map(DadosDetalhamentoUsuario::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PatchMapping("/atualizar-perfil")
    public ResponseEntity<DadosDetalhamentoUsuario> atualizarPerfil (
            @RequestBody @Valid DadosAtualizacaoPerfilUsuario dados
    ) {
        UsuarioEntity usuario = getUsuario(dados.id());
        usuario.atualizarPerfil(dados);
        usuarioJpaRepository.save(usuario);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @Transactional
    @PatchMapping("/atualizar-senha")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> atualizarSenha (
            @RequestBody @Valid DadosAtualizacaoSenhaUsuario dados
    ) {
        UsuarioEntity usuario = (UsuarioEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(!passwordEncoder.matches(dados.senhaAtual(), usuario.getSenha())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Senha incorreta");
        }

        usuario.atualizarSenha(dados, passwordEncoder);
        usuarioJpaRepository.save(usuario);
        return ResponseEntity.ok("Senha atualizada com sucesso");
    }

    @Transactional
    @DeleteMapping("/apagar-usuario/{id}")
    public ResponseEntity<Void> apagarUsuario (@PathVariable Long id) {
        UsuarioEntity usuario = getUsuario(id);
        usuario.apagar();
        usuarioJpaRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUsuario> detalharUsuario (@PathVariable Long id) {
        UsuarioEntity usuario = usuarioJpaRepository.findById(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não encontrado"));

        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    private UsuarioEntity getUsuario(Long id) {
        return usuarioJpaRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new UsuarioNaoExisteException("Usuário não encontrado ou inativo"));
    }
}
