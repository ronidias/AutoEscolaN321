package br.com.senai.autoescolan321.service;

import br.com.senai.autoescolan321.domain.Usuario;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    public String gerarToken(Usuario usuario) {

        try {
            Algorithm algorithm = Algorithm.HMAC256("12345678");
            return JWT.create()
                    .withIssuer("API Auto Escola N321")
                    .withSubject(usuario.getLogin())
                    .withExpiresAt(instanteExpiracao())
                    .sign(algorithm);
        } catch (JWTCreationException e){
            throw new RuntimeException(("Erro ao gerar o token JWT"), e);
        }



    }

    private Instant instanteExpiracao() {
        return LocalDateTime.now().plusMinutes(30).toInstant(ZoneOffset.of("-03:00"));
    }


}
