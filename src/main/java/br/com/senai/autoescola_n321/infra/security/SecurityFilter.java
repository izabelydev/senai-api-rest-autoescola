package br.com.senai.autoescola_n321.infra.security;

import static java.util.Objects.isNull;

import br.com.senai.autoescola_n321.adapter.out.repository.UsuarioRepository;
import br.com.senai.autoescola_n321.service.auth.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = recuperToken(request);

        if(!isNull(token)) {
            String subject = tokenService.getSubject(token);
            UserDetails usuario = usuarioRepository.findByLogin(subject);
            UsernamePasswordAuthenticationToken autenticacao =
                    new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autenticacao);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperToken(HttpServletRequest request) {
        String cabecalhoAutorizacao = request.getHeader("Authorization");

        if(!isNull(cabecalhoAutorizacao)) {
            return cabecalhoAutorizacao.replace("Bearer ", "");
        }

        return null;
    }
}
