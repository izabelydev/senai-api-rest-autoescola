package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.dto.usuario.DadosAtualizacaoPerfilUsuario;
import br.com.senai.autoescola_n321.adapter.in.dto.usuario.DadosAtualizacaoSenhaUsuario;
import br.com.senai.autoescola_n321.adapter.in.dto.usuario.DadosCadastramentoUsuario;
import br.com.senai.autoescola_n321.adapter.in.dto.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Usuario;
import br.com.senai.autoescola_n321.adapter.out.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class UsuarioController {

    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity<DadosDetalhamentoUsuario> cadastrarUsuario(
            @RequestBody @Valid DadosCadastramentoUsuario dados,
            UriComponentsBuilder uriBuilder
    ) {
        Usuario usuario = new Usuario(dados, passwordEncoder);
        usuarioRepository.save(usuario);
        URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoUsuario(usuario));
    }

    @GetMapping("/listar-usuarios")
    public ResponseEntity<Page<DadosDetalhamentoUsuario>> listarUsuarios (
            @PageableDefault(size=5, sort={"login"}) Pageable paginacao
    ) {
        Page<DadosDetalhamentoUsuario> page = usuarioRepository.findAllByAtivoTrue(paginacao)
                .map(DadosDetalhamentoUsuario::new);
        return ResponseEntity.ok(page);
    }

    @Transactional
    @PatchMapping("/atualizar-perfil")
    public ResponseEntity<DadosDetalhamentoUsuario> atualizarPerfil (
            @RequestBody @Valid DadosAtualizacaoPerfilUsuario dados
    ) {
        Usuario usuario = getUsuario(dados.id());
        usuario.atualizarPerfil(dados);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    @Transactional
    @PatchMapping("/atualizar-senha")
    public ResponseEntity<String> atualizarSenha (
            @RequestBody @Valid DadosAtualizacaoSenhaUsuario dados
    ) {
        Usuario usuario = getUsuario(dados.id());

        if(!passwordEncoder.matches(dados.senhaAtual(), usuario.getSenha())) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Senha incorreta");
        }

        usuario.atualizarSenha(dados, passwordEncoder);
        usuarioRepository.save(usuario);
        return ResponseEntity.ok("Senha atualizada com sucesso");
    }

    @Transactional
    @DeleteMapping("/apagar-usuario/{id}")
    public ResponseEntity<Void> apagarUsuario (@PathVariable Long id) {
        Usuario usuario = getUsuario(id);
        usuario.apagar();
        usuarioRepository.save(usuario);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoUsuario> detalharUsuario (@PathVariable Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        return ResponseEntity.ok(new DadosDetalhamentoUsuario(usuario));
    }

    private Usuario getUsuario(Long id) {
        return usuarioRepository.findByIdAndAtivoTrue(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado ou inativo"));
    }
}
