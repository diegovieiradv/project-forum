package com.forum.project_forum.controller;

import com.forum.project_forum.dto.topico.DadosCadastroDoTopico;
import com.forum.project_forum.dto.topico.DadosAtualizacaoTopico;
import com.forum.project_forum.dto.topico.DadosListagemTopico;
import com.forum.project_forum.model.Topico;
import com.forum.project_forum.repository.TopicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    // GET - lista
    @GetMapping
    public List<DadosListagemTopico> listar() {
        return repository.findAll()
                .stream()
                .map(t -> new DadosListagemTopico(t.getId(), t.getTitulo()))
                .collect(Collectors.toList());
    }

    // GET - busca
    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemTopico> buscar(@PathVariable Long id) {
        return repository.findById(id)
                .map(t -> ResponseEntity.ok(new DadosListagemTopico(t.getId(), t.getTitulo())))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST - cadastra
    @PostMapping
    public ResponseEntity<DadosListagemTopico> cadastrar(@RequestBody @Valid DadosCadastroDoTopico dados) {
        Topico topico = new Topico(dados.getTitulo(), dados.getMensagem());
        repository.save(topico);
        return ResponseEntity.ok(new DadosListagemTopico(topico.getId(), topico.getTitulo()));
    }

    // PUT - atualiza
    @PutMapping("/{id}")
    public ResponseEntity<DadosListagemTopico> atualizar(
            @PathVariable Long id,
            @RequestBody @Valid DadosAtualizacaoTopico dados) {

        return repository.findById(id)
                .map(topico -> {
                    topico.setTitulo(dados.getTitulo());
                    topico.setMensagem(dados.getMensagem());
                    repository.save(topico);
                    return ResponseEntity.ok(new DadosListagemTopico(topico.getId(), topico.getTitulo()));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - deleta
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return repository.findById(id)
                .map(topico -> {
                    repository.delete(topico);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
