package br.com.senai.autoescolan321.service;

import br.com.senai.autoescolan321.domain.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    private final String ISSEUR = "API Auto Escola N321";

    public String gerarToken(Usuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withIssuer(ISSEUR)
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(instanteExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException(("Erro ao gerar o token JWT"), e);
        }


    }

    public String getSubject(String tokenJWT) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer(ISSEUR)
                    .build()
                    .verify(tokenJWT)
                    .getSubject();


        } catch (JWTVerificationException e) {
            throw new RuntimeException("Erro ao gerar o token JWT", e);
        }

    }

    private Instant instanteExpiracao() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }


    }

