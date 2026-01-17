🧵 API Fórum – Spring Boot

API REST para um sistema de fórum, com cadastro de usuários, autenticação com JWT e gerenciamento completo de tópicos.
Projeto desenvolvido como desafio prático de formação, simulando um cenário real de backend corporativo.

📌 Contexto do Projeto

Este projeto faz parte da formação Oracle Next Education (ONE), realizada em parceria com a Alura, cujo foco é preparar desenvolvedores para atuar em ambientes profissionais, utilizando Java e Spring Boot, com atenção a segurança, boas práticas e arquitetura de APIs REST.

O Fórum foi proposto como um projeto desafiador, exigindo a implementação completa de autenticação, autorização e controle de acesso a recursos sensíveis.

🚀 Funcionalidades
👤 Usuários

Cadastro de usuários

Listagem de usuários

Busca de usuário por ID

Atualização de usuário (rota protegida por JWT)

Exclusão de usuário (rota protegida por JWT)

📝 Tópicos

Cadastro de tópicos

Listagem de tópicos

Busca de tópico por ID

Atualização de tópico (rota protegida por JWT)

Exclusão de tópico (rota protegida por JWT)

🔐 Autenticação e Segurança

Login com credenciais do usuário

Geração de token JWT

Validação de token via filtro de segurança

Bloqueio automático de rotas protegidas sem token válido (403)

🛠️ Tecnologias Utilizadas

Java 17

Spring Boot

Spring Web

Spring Data JPA

Spring Security

JWT (JSON Web Token)

MySQL

Maven

Insomnia (testes de API)

🗂️ Estrutura do Projeto
src/main/java/com/forum/project_forum
│
├── controller
│   ├── UsuarioController
│   ├── TopicoController
│   └── LoginController
│
├── domain / model
│   ├── Usuario
│   └── Topico
│
├── repository
│   ├── UsuarioRepository
│   └── TopicoRepository
│
├── dto
│   ├── usuario
│   └── topico
│
├── security
│   ├── SecurityConfig
│   ├── JwtAuthFilter
│   └── JwtService
│
└── ProjectForumApplication

🔑 Autenticação JWT
Login

POST /login

{
"login": "usuario@email.com",
"senha": "123456"
}


Resposta:

{
"token": "eyJhbGciOiJIUzI1NiJ9..."
}

Uso do Token

Para acessar rotas protegidas:

Authorization: Bearer SEU_TOKEN_AQUI


Sem token → 403 Forbidden

Token inválido → 401 Unauthorized

Token válido → acesso permitido

🔗 Principais Endpoints
Usuários

POST /usuarios

GET /usuarios

GET /usuarios/{id}

PUT /usuarios/{id} (JWT)

DELETE /usuarios/{id} (JWT)

Tópicos

POST /topicos

GET /topicos

GET /topicos/{id}

PUT /topicos/{id} (JWT)

DELETE /topicos/{id} (JWT)

🎯 Objetivo

Consolidar conhecimentos adquiridos na formação Oracle Next Education (ONE) + Alura, aplicando:

Criação de APIs REST

Autenticação e autorização com JWT

Segurança com Spring Security

Organização de projeto backend

Uso de DTOs e camadas bem definidas

Integração com banco de dados relacional

▶️ Execução do Projeto

Configure o banco MySQL

Ajuste o application.properties

Execute a aplicação

Teste as rotas via Insomnia ou Postman

📌 Considerações Finais

Este projeto representa um marco de evolução técnica, indo além de exemplos simples e abordando problemas reais de backend, como controle de acesso, segurança e padronização de código — exatamente como exigido em ambientes profissionais.