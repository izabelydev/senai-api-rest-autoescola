package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoPerfilUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosAtualizacaoSenhaUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.usuario.DadosCadastramentoUsuario;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescola_n321.application.core.usecase.UsuarioService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
        DadosDetalhamentoUsuario dto = usuarioService.cadastrar(dados);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping("/listar-usuarios")
    public ResponseEntity<Page<DadosDetalhamentoUsuario>> listarUsuarios (
            @PageableDefault(size=5, sort={"login"}) Pageable paginacao
    ) {
        return ResponseEntity.ok(usuarioService.listar(paginacao));
    }

    @PatchMapping("/atualizar-perfil")
    public ResponseEntity<DadosDetalhamentoUsuario> atualizarPerfil (
            @RequestBody @Valid DadosAtualizacaoPerfilUsuario dados
    ) {
        return ResponseEntity.ok(usuarioService.atualizarPerfil(dados));
    }

    
    @PatchMapping("/atualizar-senha")
    @PreAuthorize("hasAnyRole('USER')")
    public ResponseEntity<String> atualizarSenha (
            @RequestBody @Valid DadosAtualizacaoSenhaUsuario dados
    ) {
        usuarioService.atualizarSenha(dados);
        return ResponseEntity.ok("Senha atualizada com sucesso.");
    }

    
    @DeleteMapping("/apagar-usuario/{id}")
    public ResponseEntity<DadosDetalhamentoUsuario> apagarUsuario (@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.apagar(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUsuario> detalharUsuario (@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.detalhar(id));
    }
}
