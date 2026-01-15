package com.forum.project_forum.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;   // <-- adiciona aqui
    private String login;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String login, String senha) {  // <-- ajusta o construtor
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    // getters e setters
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }  // <-- adiciona setter

    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
}
