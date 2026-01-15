package com.forum.project_forum.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    // Chave secreta para assinar o token (deve ser longa e segura)
    private static final String chaveSecreta = "minha-super-chave-secreta-para-jwt-2026";

    // Gerar token
    public String gerarToken(String login) {
        return Jwts.builder()
                .setSubject(login)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hora
                .signWith(Keys.hmacShaKeyFor(chaveSecreta.getBytes(StandardCharsets.UTF_8)))
                .compact();
    }

    // Validar token e retornar login
    public String validarToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(chaveSecreta.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
