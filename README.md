# 🚧 - Project Fintech: SMARTFINANCE

- <strong>CAP 11</strong> - Manipulação de Banco de Dados em Java;
  
## 📱- Screen SmartFinance:

![image](https://github.com/user-attachments/assets/371ae396-8b9b-49bb-867b-b9b63f736f43)
![image](https://github.com/user-attachments/assets/fab17775-0d10-47bd-9f6d-45e3ceb945dd)
![image](https://github.com/user-attachments/assets/f44710ae-5a4e-4a6b-a1a9-1620bb7c3e32)
![image](https://github.com/user-attachments/assets/36afb9c8-0d00-4c23-a446-788e59a8d78a)

## 📂 - Estrutura de Pastas:
```
├── fintech
│   ├── br
│   |  ├── com
│   |  |  ├── fiap
│   |  |  |  ├── constants
│   |  |  |  ├── dao
|   |  |  |  |  ├── accounts
|   |  |  |  |  |  ├── impl
|   |  |  |  |  ├── cards
|   |  |  |  |  |  ├── impl
|   |  |  |  |  ├── notes
|   |  |  |  |  |  ├── impl
|   |  |  |  |  ├── statistics
|   |  |  |  |  |  ├── impl
|   |  |  |  |  ├── transactions
|   |  |  |  |  |  ├── impl
|   |  |  |  |  ├── users
|   |  |  |  |  |  ├── impl
│   |  |  |  ├── exception
│   |  |  |  ├── factory
|   |  |  |  |  ├── accounts
|   |  |  |  |  ├── cards
|   |  |  |  |  ├── notes
|   |  |  |  |  ├── statistics
|   |  |  |  |  ├── transactions
|   |  |  |  |  ├── users
│   |  |  |  ├── menu
│   |  |  |  ├── model
|   |  |  |  |  ├── builder
│   |  |  |  ├── utils
│   |  |  |  ├── view
|   |  |  |  |  ├── accounts
|   |  |  |  |  |  ├── operationsMock
|   |  |  |  |  ├── cards
|   |  |  |  |  |  ├── operationsMock
|   |  |  |  |  ├── notes
|   |  |  |  |  |  ├── operationsMock
|   |  |  |  |  ├── statistics
|   |  |  |  |  |  ├── operationsMock
|   |  |  |  |  ├── transactions
|   |  |  |  |  |  ├── operationsMock
|   |  |  |  |  ├── users
|   |  |  |  |  |  ├── operationsMock
```

## ✅ - Padrões Utilizados:

<strong>Padrões Criacionais:</strong> oferecem diversas alternativas de criação de objetos, o que aumenta a flexibilidade e a reutilização de código.

- Factory Method;
- Abstract Factory;
- Builder;

## 🎲 - Interface JDBC:

![image](https://github.com/user-attachments/assets/89ffe1ff-b810-4f8c-8d41-148803cc4a8d)

## 📃- Requisitos do Sistema:

- <strong>Classe DAO:</strong> Criar a classe DAO responsável por acessar o banco de dados Oracle para a continuação do sistema FINTECH;
- <strong>Consulta de dados:</strong> Implementar o método getAll na classe DAO. Este método deverá recuperar todos os dados no banco através de um comando SELECT;
- <strong>Tratamento de Exceções:</strong> Implementar tratamento de exceções para lidar com possíveis problemas durante o acesso ao banco de dados, como indisponibilidade do banco ou tabela inexistente;
- <strong>Cadastrar dados:</strong> Adicionar o método insert na classe DAO que permite registrar informações no banco de dados.

## 📄- Intruções para Testes:

- <strong>Teste de cadastro:</strong> Utilizar o método insert para cadastrar pelo menos 5 (cinco) novos registros no banco de dados;
- <strong>Teste de consulta:</strong> Testar o método getAll apos a inserção dos registros, garantindo que ele recupere e apresente corretamente as informações recuperadas;
- <strong>Adaptação para Outras Entidades:</strong> Replicar o desenvolvimento feito até agora para outras entidades do sistema.

## 📑- Pré-requisitos Técnicos:

- <strong>Linguagem de programação:</strong> Java na versão 17;
- <strong>Banco de dados:</strong> utilize Oracle;
- <strong>Modelagem de banco de dados</strong>;
- Manipulação de tipos de dados no Java.
