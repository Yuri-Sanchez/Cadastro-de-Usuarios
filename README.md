# CRUD de Usuários

API REST para gerenciamento de usuários, desenvolvida com **Spring Boot** e **JPA/Hibernate**. Permite realizar operações básicas de cadastro, listagem, atualização e remoção de usuários em um banco de dados relacional.

## Funcionalidades

- Criar um novo usuário
- Listar todos os usuários cadastrados
- Buscar um usuário específico por ID
- Atualizar os dados de um usuário
- Deletar um usuário

## Tecnologias utilizadas

- **Java 26**
- **Spring Boot** (Web, Data JPA)
- **Hibernate / JPA**
- **Lombok**
- **DTO** (Data Transfer Object)
- **Mapper** (ModelMapper ou MapStruct)
- **Banco de dados H2** (ou outro de sua preferência, como MySQL/PostgreSQL)


## Este projeto foi fundamental para consolidar e aprofundar meus conhecimentos nas seguintes áreas:

## Spring Boot & Arquitetura REST
- Compreensão na prática do padrão MVC (Model-View-Controller) adaptado para APIs REST

- Organização clara das camadas: Controller → Service → Repository

- Mapeamento correto de verbos HTTP (@PostMapping, @GetMapping, @PutMapping, @DeleteMapping)

## JPA / Hibernate
- Uso de anotações como @Entity, @Table, @Id, @GeneratedValue

- Configuração de constraints no banco como unique = true para o e-mail

- Entendimento de como o Spring Data JPA abstrai operações complexas com JpaRepository

## DTO (Data Transfer Object)
- Entendimento da importância de não expor a entidade diretamente nas camadas externas

- Controle granular sobre quais campos são trafegados na API

- Segurança e flexibilidade para evoluir o modelo interno sem quebrar contratos da API

## Mapper
- Implementação da conversão entre Entity e DTO de forma centralizada e reutilizável

- Evitar código repetitivo e espalhado pela aplicação

- Preparação para evoluir para ferramentas mais robustas como MapStruct (mapeamento em tempo de compilação)

## Injeção de Dependências
- Uso de injeção via construtor (boa prática recomendada pelo Spring)

- Facilidade para testabilidade e desacoplamento das classes

## Boas práticas de desenvolvimento
- Tratamento de Optional no retorno de busca por ID

- Separação de responsabilidades (cada camada tem seu papel bem definido)

- Código limpo, organizado e de fácil manutenção