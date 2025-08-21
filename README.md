# 🛠️ API de Itens Favoritos do League of Legends

Gerencie seus itens favoritos do **League of Legends** com esta API REST simples e eficiente.  
Ideal para catalogar, organizar e testar operações CRUD com Spring Boot.

---

## 🎯 Problema Resolvido

Muitos jogadores do LoL tem itens favoritos, mas não têm onde registrá-los de forma estruturada.  
Esta API permite **cadastrar, listar, atualizar e remover** itens favoritos, com validação de dados e resposta em JSON.

---

## 🚀 Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot** – Criação rápida de API REST
- **Spring Data JPA** – Persistência de dados
- **H2 Database** – Banco de dados em memória (não precisa de instalação)
- **Maven** – Gerenciamento de dependências
- **JSON** – Formato de entrada e saída
- **Validação com Bean Validation** – Garante dados consistentes

---

## 📦 Como Rodar a API

### 1. Clone o repositório 
git clone https://github.com/onlyluc/league-api.git
   cd api-test
   
### 2. Execute com Maven
mvn spring-boot:run

### 3. Acesse a API
A API estará disponível em:
👉 http://localhost:8080/itens

### ROTAS DA API
GET /itens – Listar todos os itens
Retorna uma lista com todos os itens cadastrados.
Método: GET
URL: http://localhost:8080/itens
Resposta (200 OK):
[
  {
    "id": 1,
    "nome": "Poção de Cura",
    "tipo": "Consumível",
    "preco": 50
  },
  {
    "id": 2,
    "nome": "Espada de Diamante",
    "tipo": "Arma",
    "preco": 2000
  }
]

### GET /itens/{id} – Buscar item por ID
Retorna um item específico pelo seu ID.
Método: GET
URL: http://localhost:8080/itens/1
{
  "id": 1,
  "nome": "Poção de Cura",
  "tipo": "Consumível",
  "preco": 50
}

Se não encontrado: 404 Not Found

### POST /itens – Criar um novo item
Adiciona um novo item à lista.
Método: POST
URL: http://localhost:8080/itens
Corpo da requisição (JSON)

{
  "nome": "Capa da Invisibilidade",
  "tipo": "Acessório",
  "preco": 1500
}

Resposta (201 Created):

### Validação:
nome: obrigatório (não pode ser vazio)
tipo: obrigatório
preco: obrigatório
Se inválido: 400 Bad Request com mensagem de erro

### PUT /itens/{id} – Atualizar um item
Atualiza todos os campos de um item existente.

Método: PUT
URL: http://localhost:8080/itens/1
Corpo da requisição:
{
  "nome": "Poção de Cura Máxima",
  "tipo": "Consumível",
  "preco": 75
}

### Resposta (200 OK): Item atualizado
### Se o ID não existir: 404 Not Found


### DELETE /itens/{id} – Remover um item
Remove um item pelo ID.
Método: DELETE
URL: http://localhost:8080/itens/1
Resposta: 204 No Content (sem corpo)
Se não existir: 404 Not Found


### Teste com Curl
# Listar todos os itens
curl http://localhost:8080/itens

# Criar um novo item
curl -X POST http://localhost:8080/itens \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Botas de Velocidade",
    "tipo": "Movimento",
    "preco": 300
  }'

# Atualizar um item
curl -X PUT http://localhost:8080/itens/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Poção Forte",
    "tipo": "Consumível",
    "preco": 80
  }'

# Deletar um item
curl -X DELETE http://localhost:8080/itens/1


💾 H2 Console (banco de dados em memória)
Acesse o banco de dados diretamente em:
👉 http://localhost:8080/h2-console

Configuração:
JDBC URL: jdbc:h2:mem:testdb
Username: sa
Password: (vazio)
Driver Class: org.h2.Driver
Clique em Connect para ver a tabela itens e os dados.

📂 Dependências (pom.xml)
spring-boot-starter-web – API REST
spring-boot-starter-data-jpa – JPA / Hibernate
h2 – Banco de dados em memória
jakarta.validation – Validação de campos
