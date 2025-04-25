# Projeto: Microsserviços de Gestão da Inovação

Este repositório agrupa os microsserviços que compõem o sistema de **Gestão de Projetos de Inovação**, estruturado com base na arquitetura de microserviços. Cada serviço é responsável por um domínio específico dentro do ecossistema da aplicação.

---

## Estrutura dos Microsserviços

```
ms-projetos/
│
├── acompanhamento-inovacao-microservice
├── financeiro-microservice
├── ideas-microservice-management
├── innovation-project-management
├── notificacoes-microservice
└── usuarios
```

---

## Descrição dos Microsserviços

### 1. acompanhamento-inovacao-microservice
Gerencia o acompanhamento dos projetos de inovação:
- Registro de marcos e atividades.
- Monitoramento de prazos e status.
- Geração de relatórios de progresso.

### 2. financeiro-microservice
Responsável pelo controle financeiro dos projetos:
- Cadastro de orçamentos por projeto.
- Lançamento e rastreamento de despesas.
- Integração com sistema de pagamentos ou ERP (se aplicável).

### 3. ideas-microservice-management
Administra o pipeline de ideias inovadoras:
- Submissão e avaliação de ideias.
- Filtro de viabilidade.
- Transformação de ideias em projetos.

### 4. innovation-project-management
Coordena os projetos de inovação:
- Cadastro de projetos.
- Definição de escopo, metas e equipe.
- Interface com os demais microsserviços.

### 5. notificacoes-microservice
Gerencia o envio de notificações:
- Notificações por e-mail e/ou push.
- Alertas de prazos e status de projeto.
- Confirmação de recebimento e logs de entrega.

### 6. usuarios
Administração de usuários e permissões:
- Cadastro e autenticação de usuários.
- Perfis e níveis de acesso.
- Integração com autenticação via JWT ou OAuth2.

---

## Tecnologias Utilizadas
- Java 17
- Spring Boot
- Spring Cloud
- Docker
- PostgreSQL
- RabbitMQ (para notificações, se aplicável)

---

## Como Executar

Cada microserviço é independente. Para rodar localmente:

```bash
cd ms-ms-Innovativeprojects
./mvnw spring-boot:run
```

Recomenda-se o uso de Docker Compose para orquestração local.

---

## 📄 Licença

Este projeto está licenciado sob os termos da licença MIT.
