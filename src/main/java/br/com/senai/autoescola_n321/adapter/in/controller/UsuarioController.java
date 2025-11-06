package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.dto.usuario.DadosCadastramentoUsuario;
import br.com.senai.autoescola_n321.adapter.in.dto.usuario.DadosDetalhamentoUsuario;
import br.com.senai.autoescola_n321.adapter.out.domain.entity.Usuario;
import br.com.senai.autoescola_n321.adapter.out.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<Page<DadosDetalhamentoUsuario>> listarUsuarios(
            @PageableDefault(size=5, sort={"login"}) Pageable paginacao
    ) {
        Page<DadosDetalhamentoUsuario> page = usuarioRepository.findAll(paginacao)
                .map(DadosDetalhamentoUsuario::new);
        return ResponseEntity.ok(page);
    }
}
