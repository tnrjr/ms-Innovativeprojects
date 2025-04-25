# 📬 Microserviço de Notificações

Este microserviço faz parte do sistema **Innovation Manager** e é responsável por **registrar e gerenciar notificações** relacionadas a projetos, ideias, finanças e outras ações no ecossistema de inovação.

---

## Funcionalidades

- Registrar notificações (e-mail, push, sistema)
- Listar notificações por destinatário
- Buscar notificação por ID
- Marcar envio de notificação (via campo `enviada`)
- Documentação via Swagger UI

---

## Tecnologias utilizadas

- Java 17
- Spring Boot 3.4.2
- Spring Web
- Spring Data JPA
- H2 Database (ambiente de desenvolvimento)
- Springdoc OpenAPI (Swagger)
- Lombok

---

## Executando o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/TN-Junior/notificacoes-microservice.git
```

### 2. Compile e execute
```bash
./mvnw spring-boot:run
```

### 3. Acesse no navegador:
- Swagger UI: http://localhost:8085/swagger-ui.html
- H2 Console: http://localhost:8085/h2-console

## Exemplo de requisição JSON (POST /notificacoes)
```bash
{
  "titulo": "Projeto aprovado!",
  "mensagem": "O projeto Inova Recife foi aprovado pela comissão.",
  "destinatario": "joao@recife.pe.gov.br",
  "tipo": "EMAIL",
  "dataEnvio": "2025-04-10T18:00:00",
  "enviada": false
}
```


