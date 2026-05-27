# CRUD de Usuários com Interface Web

API REST + Interface Web para gerenciamento de usuários, desenvolvida com **Spring Boot**, **JPA/Hibernate**, **Data Base H2**, **Flyway** e **Thymeleaf**.

## Funcionalidades

- Criar, listar, buscar, atualizar e deletar usuários via API REST
- Interface web para gerenciamento visual dos usuários

## Tecnologias utilizadas

- **Java 21**
- **Spring Boot** (Web, Data JPA, Thymeleaf)
- **Hibernate / JPA**
- **Flyway** (Migração de banco de dados)
- **Lombok**
- **DTO** (Data Transfer Object)
- **Mapper** (ModelMapper ou MapStruct)
- **Banco de dados H2** (com suporte para MySQL/PostgreSQL)

## Aprendizados com o projeto

### Spring Boot & Arquitetura REST
- Compreensão prática do padrão MVC adaptado para APIs REST
- Organização clara das camadas: Controller → Service → Repository
- Mapeamento correto de verbos HTTP (@PostMapping, @GetMapping, @PutMapping, @DeleteMapping)

### JPA / Hibernate
- Uso de anotações como @Entity, @Table, @Id, @GeneratedValue
- Configuração de constraints no banco (ex: unique = true para e-mail)
- Entendimento de como o Spring Data JPA abstrai operações complexas com JpaRepository

### DTO (Data Transfer Object)
- Importância de não expor a entidade diretamente nas camadas externas
- Controle granular sobre quais campos são trafegados na API
- Segurança e flexibilidade para evoluir o modelo interno sem quebrar contratos da API

### Mapper
- Implementação da conversão entre Entity e DTO de forma centralizada e reutilizável
- Evitar código repetitivo e espalhado pela aplicação

### Flyway
- Versionamento e controle de mudanças na estrutura do banco de dados
- Garantia de consistência entre ambientes (desenvolvimento, teste, produção)
- Evolução do schema de forma controlada e rastreável

### Interface Web com Thymeleaf
- Integração de uma interface gráfica com a API REST no mesmo projeto
- Organização de controllers separados para UI e API
- Criação de páginas dinâmicas com templates HTML

### Injeção de Dependências
- Uso de injeção via construtor (boa prática recomendada pelo Spring)
- Facilidade para testabilidade e desacoplamento das classes

### Boas práticas de desenvolvimento
- Tratamento de Optional no retorno de busca por ID
- Separação de responsabilidades (cada camada com seu papel bem definido)
- Versionamento de banco de dados com Flyway
- Código limpo, organizado e de fácil manutenção