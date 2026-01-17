package com.forum.project_forum.dto.usuario;

public class DadosUsuarioResponse {

    private String nome;
    private String email;

    public DadosUsuarioResponse(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }


    public String getNome() { return nome; }
    public String getEmail() { return email; }
}
