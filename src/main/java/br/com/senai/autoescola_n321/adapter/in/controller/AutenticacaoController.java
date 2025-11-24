package br.com.senai.autoescola_n321.adapter.in.controller;

import br.com.senai.autoescola_n321.adapter.in.controller.dto.request.autenticacao.DadosAutenticacao;
import br.com.senai.autoescola_n321.adapter.in.controller.dto.response.autenticacao.DadosTokenJwt;
import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Usuario;
import br.com.senai.autoescola_n321.infra.security.auth.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJwt> efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        Authentication auth = manager.authenticate(token);

        String tokenJwt = tokenService.gerarToken((UsuarioEntity) auth.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));
    }
}
