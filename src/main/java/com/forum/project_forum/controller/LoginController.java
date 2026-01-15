package com.forum.project_forum.controller;

import com.forum.project_forum.model.Usuario;
import com.forum.project_forum.repository.UsuarioRepository;
import com.forum.project_forum.security.JwtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private JwtService jwtService;

    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody @Valid Usuario usuarioLogin) {

        return repository.findByLogin(usuarioLogin.getLogin())
                .filter(u -> u.getSenha().equals(usuarioLogin.getSenha())) // futuramente bcrypt
                .map(u -> {
                    String token = jwtService.gerarToken(u.getLogin());
                    return ResponseEntity.ok(Map.of("token", token));
                })
                .orElse(ResponseEntity.status(401).build());
    }
}
