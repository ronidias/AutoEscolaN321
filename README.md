📘 Projeto AutoEscola - Agendamento de Aulas
Este é um projeto de estudos desenvolvido no SENAI com o objetivo de criar um aplicativo para agendamento de aulas em uma autoescola. O sistema foi construído utilizando tecnologias modernas e boas práticas de desenvolvimento backend.

🛠 Tecnologias Utilizadas
- Java 25
- Spring Boot
- API RESTful
- MySQL
- Postman (para testes de API)

🎯 Objetivo do Projeto
Desenvolver uma aplicação backend capaz de:
- Gerenciar alunos, instrutores e veículos
- Realizar agendamento de aulas práticas e teóricas
- Persistir dados em banco de dados relacional
- Expor endpoints HTTP para operações CRUD completas

📌 Funcionalidades Implementadas
- [x] Cadastro de alunos
- [x] Cadastro de instrutores
- [x] Cadastro de veículos
- [x] Agendamento de aulas
- [x] Consulta de agendamentos
- [x] Atualização e cancelamento de aulas
- [x] Validações básicas de dados
- [x] Integração com banco de dados MySQL

📂 Estrutura do Projeto
src/
├── main/
│   ├── java/
│   │   └── br.senai.autoescola/
│   │       ├── controller/
│   │       ├── model/
│   │       ├── repository/
│   │       └── service/
│   └── resources/
│       ├── application.properties
│       └── data.sql



🔗 Endpoints REST
Exemplos de endpoints disponíveis:
- GET /alunos → Lista todos os alunos
- POST /instrutores → Cadastra novo instrutor
- PUT /aulas/{id} → Atualiza agendamento
- DELETE /veiculos/{id} → Remove veículo
- GET /aulas?alunoId=1 → Consulta aulas por aluno

🧪 Testes
Os testes estão sendo realizados via Postman, com simulações de chamadas HTTP para verificar:
- Persistência no banco
- Validação de dados
- Respostas corretas da API
