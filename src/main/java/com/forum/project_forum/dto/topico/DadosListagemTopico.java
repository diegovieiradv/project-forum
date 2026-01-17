package com.forum.project_forum.dto.topico;

public class DadosListagemTopico {
    private Long id;
    private String titulo;

    public DadosListagemTopico(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }


    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
}
