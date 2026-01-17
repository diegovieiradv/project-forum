package com.forum.project_forum.dto.topico;

import jakarta.validation.constraints.NotBlank;

public class DadosAtualizacaoTopico {
    @NotBlank
    private String titulo;

    @NotBlank
    private String mensagem;


    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}