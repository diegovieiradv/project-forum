package com.forum.project_forum.controller;

import com.forum.project_forum.model.Topico;
import com.forum.project_forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository repository;

    // GET - listar todos os tópicos
    @GetMapping
    public List<Topico> listar() {
        return repository.findAll();
    }

    // GET - buscar um tópico pelo id
    @GetMapping("/{id}")
    public Topico buscar(@PathVariable Long id) {
        return repository.findById(id).get();
    }

    // POST - cadastrar um novo tópico
    @PostMapping
    public Topico cadastrar(@RequestBody Topico topico) {
        return repository.save(topico);
    }

    // PUT - atualizar um tópico
    @PutMapping("/{id}")
    public Topico atualizar(
            @PathVariable Long id,
            @RequestBody Topico dados) {

        Topico topico = repository.findById(id).get();
        topico.setTitulo(dados.getTitulo());
        topico.setMensagem(dados.getMensagem());

        return repository.save(topico);
    }

    // DELETE - deletar tópico
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
