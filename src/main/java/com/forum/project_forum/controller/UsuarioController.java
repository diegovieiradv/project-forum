package com.forum.project_forum.controller;

import com.forum.project_forum.dto.topico.usuario.DadosCadastroUsuario;
import com.forum.project_forum.model.Usuario;
import com.forum.project_forum.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    // POST - cadastrar usuário
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid DadosCadastroUsuario dados) {
        Usuario usuario = new Usuario();
        usuario.setLogin(dados.getLogin());
        usuario.setSenha(dados.getSenha()); // futuramente vamos criptografar
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }
}
