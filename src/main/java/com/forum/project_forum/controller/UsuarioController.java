package com.forum.project_forum.controller;

import com.forum.project_forum.model.Usuario;
import com.forum.project_forum.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    // POST - cadastra
    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario) {
        repository.save(usuario);
        return ResponseEntity.ok(usuario);
    }

    // GET - lista
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        List<Usuario> usuarios = repository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    // GET - consulta
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultarPorId(@PathVariable Long id) {
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT - atualiza
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody @Valid Usuario dados) {
        Optional<Usuario> usuarioExistente = repository.findById(id);
        if (usuarioExistente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioExistente.get();
        usuario.setNome(dados.getNome());
        usuario.setLogin(dados.getLogin());
        usuario.setSenha(dados.getSenha());
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    // DELETE - remove
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
