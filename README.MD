**Sistema Gerenciador de Pedidos**
==================================

Este projeto é um sistema simples para gerenciamento de pedidos, desenvolvido com foco em aprendizado e testes de conhecimentos em Spring Boot, autenticação JWT e otimizações de consulta.

## Descrição

O sistema possui dois serviços principais:

1. **Serviço Aberto**:
   - Permite que os usuários cadastrem seus pedidos diretamente, sem necessidade de autenticação.
   - Não foi implementado cadastro de usuários, deixando essa funcionalidade aberta para simplificação.

2. **Serviço Fechado**:
   - Oferece funcionalidades para gestão de pedidos.
   - Protegido por autenticação baseada em tokens JWT, utilizando Spring Security.
   - Estruturado de forma simples, com o objetivo de demonstrar conceitos básicos de segurança e autenticação.

## Tecnologias Utilizadas

- **Java 17**
- **Spring Boot 3.x**
- **Spring Security**
- **JWT (JSON Web Token)**
- **H2 Database (em memória)**
- **Flyway** para controle de migrações no banco de dados
- **Swagger** para documentação da API

## Funcionalidades Implementadas

- Cadastro de pedidos (serviço aberto).
- Gestão de pedidos autenticada (serviço fechado).
- Otimização de consultas utilizando o campo `pedido_hash` com índice no banco de dados.

## Melhorias Futuras

1. **Cache**:
   - A inclusão de um mecanismo de cache para reduzir a carga sobre o banco de dados e melhorar a performance das consultas.

2. **Paginação**:
   - Implementar paginação nas consultas para tornar o sistema mais eficiente no gerenciamento de grandes volumes de dados.

## Endpoints e Links Úteis

- **Link para a aplicação**: [http://localhost:8080](http://localhost:8080)
- **Swagger (Documentação da API)**: [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
- **Console do H2**: [http://localhost:8080/h2-console/login.jsp](http://localhost:8080/h2-console/login.jsp)
  - **JDBC URL**: `jdbc:h2:mem:orderdb`
  - **Usuário**: `SA`
  - **Senha**: *(sem senha)*