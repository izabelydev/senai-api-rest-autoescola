package br.com.senai.autoescola_n321.infra.security.auth;

import br.com.senai.autoescola_n321.adapter.out.repository.entity.UsuarioEntity;
import br.com.senai.autoescola_n321.application.core.domain.model.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@Service
public class TokenService {

    private final String ISSUER = "API Autoescola n321";

    @Value("${api.security.token.secret}")
    private String secret;

    public String gerarToken(UsuarioEntity usuario) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(instanteExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao gerar token", e);
        }
    }

    public String getSubject(String tokenJwt) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(tokenJwt)
                    .getSubject();
        } catch (JWTVerificationException e){
            throw new RuntimeException("Token JWT invalido ou expirado", e);
        }
    }

    private Instant instanteExpiracao() {
        return LocalDateTime.now().plusMinutes(5).toInstant(ZoneOffset.of("-03:00"));
    }
}
