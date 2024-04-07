# Projeto Desafio PROSPERTECH

Este é um projeto de uma API RESTful desenvolvida em Java com o framework Spring Boot.

## Configuração do Banco de Dados

O projeto utiliza um banco de dados PostgreSQL. Para executar localmente, é necessário ter o Docker instalado e executar o seguinte comando na raiz do projeto:

```
docker-compose up -d

```

Isso iniciará um contêiner Docker com o PostgreSQL em execução.


## Configuração do Aplicativo

O arquivo `application.properties` contém as configurações do aplicativo, incluindo a URL, nome de usuário e senha do banco de dados.

```properties
spring.application.name=desafio
spring.datasource.url=jdbc:postgresql://localhost:5432/prospertech
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

# Endpoints da API
## Listar todos os produtos

```
GET /produto

```
Retorna uma lista de todos os produtos.

## Detalhar um produto

```
GET /produto/{id}

```

Retorna os detalhes de um produto específico com o ID fornecido.

## Cadastrar um novo produto
```
POST /produto

```
Cria um novo produto com os detalhes fornecidos no corpo da solicitação.

## Atualizar um produto existente

```
PUT /produto/{id}

```
Atualiza os detalhes de um produto existente com o ID fornecido.

## Deletar um produto

```
DELETE /produto/{id}

```
Remove um produto existente com o ID fornecido.

# Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker


# Como Executar

Certifique-se de ter o Java 17 e o Docker instalados em sua máquina.

Clone este repositório.

Execute o comando ``` docker-compose up -d``` para iniciar o banco de dados PostgreSQL.

Compile e execute o projeto Spring Boot.

```
mvn spring-boot:run
```






















