🧭 MonoGestor
MonoGestor é um sistema completo de gestão de Departamentos e Funcionários, desenvolvido com Spring Boot, Thymeleaf, JPA/Hibernate e banco de dados relacional. O projeto oferece uma interface web para administração e uma API REST para integração externa.

🚀 Tecnologias Utilizadas
✅ Java 17+

✅ Spring Boot 3+

✅ Spring Data JPA

✅ Thymeleaf

✅ Lombok

✅ H2 / MySQL (ou outro banco relacional)

✅ Maven

🛠️ Como Rodar o Projeto
1. Clone o repositório
   bash
   git clone https://github.com/Phhenrique3/MonoGestor.git
2. Abra no seu IDE favorito
   Compatível com IntelliJ, Eclipse, VSCode, etc.

3. Configure o banco de dados em application.properties
   properties
   spring.datasource.url=jdbc:mysql://localhost:3306/monogestor
   spring.datasource.username=root
   spring.datasource.password=root
   spring.jpa.hibernate.ddl-auto=update
   💡 Você pode usar H2 para testes locais ou outro banco relacional de sua preferência.

4. Execute a aplicação
   bash
   mvn spring-boot:run
   🌐 Acesso via Navegador
   Front-end (Thymeleaf):

http://localhost:8080/departamentos

http://localhost:8080/funcionarios

API REST (JSON):

http://localhost:8080/departamentos-html

http://localhost:8080/funcionarios-html

📋 Rotas do Front-End (Thymeleaf)
🔹 Departamentos
Método	URL	Descrição
GET	/departamentos	Lista todos os departamentos
POST	/departamentos/salvar	Cria ou atualiza um departamento
GET	/departamentos/editar/{id}	Carrega departamento para edição
POST	/departamentos/deletar/{id}	Deleta um departamento
🔹 Funcionários
Método	URL	Descrição
GET	/funcionarios	Lista todos os funcionários
POST	/funcionarios/add	Adiciona um novo funcionário
GET	/funcionarios/edit/{id}	Carrega funcionário para edição
POST	/funcionarios/update/{id}	Atualiza funcionário
POST	/funcionarios/delete/{id}	Deleta funcionário
📡 Rotas da API REST (JSON)
🔹 Departamentos
Listar todos: GET /departamentos-html

Buscar por ID: GET /departamentos-html/{id}

Criar: POST /departamentos-html

Atualizar: PUT /departamentos-html/{id}

Deletar: DELETE /departamentos-html/{id}

📦 Exemplo de criação
json
{
"nome": "Financeiro",
"localizacao": "Rio de Janeiro"
}
🔹 Funcionários
Listar todos: GET /funcionarios-html

Buscar por ID: GET /funcionarios-html/{id}

Criar: POST /funcionarios-html

Atualizar: PUT /funcionarios-html/{id}

Deletar: DELETE /funcionarios-html/{id}

📦 Exemplo de criação
json
{
"nome": "Pedro Henrique",
"cpf": "123.456.789-00",
"email": "pedro@empresa.com",
"dataAdmissao": "2025-10-09",
"departamento": {
"id": 1
}
}
⚠️ Observações Importantes
🔒 Validação de exclusão: Departamentos com funcionários vinculados não podem ser deletados via front-end (gera IllegalStateException).

🛑 Tratamento global de erros: Implementado via GlobalExceptionHandler, com redirecionamento para a página error.html.

🧩 Integração com Thymeleaf: Campos de formulário são vinculados com th:field para facilitar criação e edição de registros.