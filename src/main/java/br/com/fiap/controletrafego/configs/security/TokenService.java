package br.com.fiap.controletrafego.configs.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.fiap.controletrafego.model.Usuario;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TokenService {
	
	@Value("${minha.chave.secreta}")
	private String palavraSecreta;
	
	public String gerarToken(Usuario usuario) {
		
		try {
			Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
			String token = JWT
					.create().withIssuer("monitoramentos")
					.withSubject(usuario.getEmail())
					.withExpiresAt(gerarDataExpiracao())
					.sign(algorithm);
			return token;
		} catch(JWTCreationException e) {
			log.info("Erro ao gerar token! "+ e.getMessage());
			throw new RuntimeException("Não foi possivel gerar o token!");
		}
	}
	
	public String validarToken(String token) {
		
		try {
			Algorithm algorithm = Algorithm.HMAC256(palavraSecreta);
			return JWT.require(algorithm)
					.withIssuer("monitoramentos")
					.build()
					.verify(token)
					.getSubject();
		} catch (JWTVerificationException e) {
			log.info("Token invalido! "+ e.getMessage());
			return "";
		}
	}
	
	public Instant gerarDataExpiracao() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
