MonoGestor

Projeto MonoGestor – Sistema de Gestão de Departamentos e Funcionários, construído com Spring Boot, Thymeleaf, JPA/Hibernate e banco de dados relacional.

Este projeto possui front-end via Thymeleaf e API REST para consumo externo.

🔹 Tecnologias Utilizadas

Java 17+

Spring Boot 3+

Spring Data JPA

Thymeleaf

Lombok

H2 / MySQL (ou outro banco)

Maven

🔹 Rodando o Projeto

Clone o repositório:

git clone https://github.com/Phhenrique3/MonoGestor.git


Abra no seu IDE (IntelliJ, Eclipse, VSCode).

Configure o banco de dados em application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/monogestor
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update


Execute a aplicação:

mvn spring-boot:run


Acesse no navegador:

Front-end: http://localhost:8080/departamentos
e http://localhost:8080/funcionarios

API REST: http://localhost:8080/departamentos-html
e http://localhost:8080/funcionarios-html

🔹 Rotas do Front-End (Thymeleaf)
Departamentos
Método	URL	Descrição
GET	/departamentos	Lista todos os departamentos e exibe formulário
POST	/departamentos/salvar	Cria ou atualiza um departamento
GET	/departamentos/editar/{id}	Carrega departamento para edição
POST	/departamentos/deletar/{id}	Deleta um departamento
Funcionários
Método	URL	Descrição
GET	/funcionarios	Lista todos os funcionários e exibe formulário
POST	/funcionarios/add	Adiciona um novo funcionário
GET	/funcionarios/edit/{id}	Carrega funcionário para edição
POST	/funcionarios/update/{id}	Atualiza funcionário
POST	/funcionarios/delete/{id}	Deleta funcionário
🔹 Rotas da API REST (JSON)
Departamentos

Listar todos os departamentos

GET /departamentos-html


Exemplo de resposta:

[
{
"id": 1,
"nome": "TI",
"localizacao": "São Paulo"
}
]


Buscar departamento por ID

GET /departamentos-html/{id}


Exemplo de resposta:

{
"id": 1,
"nome": "TI",
"localizacao": "São Paulo"
}


Criar departamento

POST /departamentos-html
Content-Type: application/json


Exemplo de request:

{
"nome": "Financeiro",
"localizacao": "Rio de Janeiro"
}


Atualizar departamento

PUT /departamentos-html/{id}


Exemplo de request:

{
"nome": "Financeiro Atualizado",
"localizacao": "Rio de Janeiro"
}


Deletar departamento

DELETE /departamentos-html/{id}

Funcionários

Listar todos os funcionários

GET /funcionarios-html


Buscar funcionário por ID

GET /funcionarios-html/{id}


Criar funcionário

POST /funcionarios-html
Content-Type: application/json


Exemplo de request:

{
"nome": "Pedro Henrique",
"cpf": "123.456.789-00",
"email": "pedro@empresa.com",
"dataAdmissao": "2025-10-09",
"departamento": {
"id": 1
}
}


Atualizar funcionário

PUT /funcionarios-html/{id}


Exemplo de request:

{
"nome": "Pedro H. Atualizado",
"cpf": "123.456.789-00",
"email": "pedro@empresa.com",
"dataAdmissao": "2025-10-09",
"departamento": {
"id": 1
}
}


Deletar funcionário

DELETE /funcionarios-html/{id}

🔹 Observações

Validação de exclusão: Departamentos com funcionários não podem ser deletados via front-end (IllegalStateException).

Tratamento global de erros via GlobalExceptionHandler com página error.html.

Os campos de formulário são vinculados com th:field do Thymeleaf para criar e atualizar registros.