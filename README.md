# 🛒 WebService Project - E-commerce System

Sistema completo de e-commerce com backend Spring Boot e frontend em JavaScript vanilla, incluindo autenticação, gerenciamento de usuários, catálogo de produtos e processamento de pedidos.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![JavaScript](https://img.shields.io/badge/JavaScript-ES6+-yellow)
![H2 Database](https://img.shields.io/badge/Database-H2-blue)

---

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Como Executar](#como-executar)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [API Endpoints](#api-endpoints)
- [Credenciais de Teste](#credenciais-de-teste)
- [Capturas de Tela](#capturas-de-tela)
- [Autor](#autor)

---

## 🎯 Sobre o Projeto

Sistema de e-commerce full-stack desenvolvido com Spring Boot no backend e JavaScript vanilla no frontend. O projeto implementa um sistema completo de loja online com autenticação de usuários, gerenciamento de produtos, carrinho de compras e processamento de pedidos.

### Características Principais:

- ✅ **Autenticação e Autorização** - Sistema de login com roles (Admin/Cliente)
- ✅ **Gerenciamento de Usuários** - CRUD completo para administradores
- ✅ **Catálogo de Produtos** - Visualização de produtos com imagens e preços
- ✅ **Carrinho de Compras** - Adicionar, remover e ajustar quantidades
- ✅ **Processamento de Pedidos** - Criação e visualização de pedidos
- ✅ **Dashboard Administrativo** - Estatísticas e métricas do sistema
- ✅ **Interface Moderna** - Design responsivo com tema dark e glassmorphism

---

## ⚡ Funcionalidades

### Para Administradores:
- 📊 Dashboard com estatísticas (usuários, produtos, pedidos, receita)
- 👥 Gerenciamento completo de usuários (criar, editar, excluir)
- 📦 Visualização de todos os produtos
- 🛒 Criação de pedidos para qualquer cliente
- 📋 Visualização de todos os pedidos do sistema

### Para Clientes:
- 🔐 Login e registro de conta
- 🛍️ Navegação pelo catálogo de produtos
- 🛒 Carrinho de compras funcional
- ✅ Criação de pedidos
- 📜 Visualização dos próprios pedidos

---

## 🚀 Tecnologias Utilizadas

### Backend:
- **Java 17**
- **Spring Boot 3.x**
  - Spring Web
  - Spring Data JPA
  - Spring Boot DevTools
- **H2 Database** (em memória para desenvolvimento)
- **Maven** (gerenciamento de dependências)

### Frontend:
- **HTML5**
- **CSS3** (com variáveis CSS e animações)
- **JavaScript ES6+** (Vanilla JS, sem frameworks)
- **Fetch API** (comunicação com backend)

### Arquitetura:
- **REST API** (comunicação frontend-backend)
- **CORS** configurado para desenvolvimento local
- **MVC Pattern** no backend
- **Component-based** no frontend

---

## 📋 Pré-requisitos

Antes de executar o projeto, você precisa ter instalado:

1. **Java Development Kit (JDK) 17 ou superior**
   - Download: https://www.oracle.com/java/technologies/downloads/

2. **IntelliJ IDEA** (Community ou Ultimate)
   - Download: https://www.jetbrains.com/idea/download/

3. **Maven** (geralmente já vem com IntelliJ)

4. **Navegador Web Moderno** (Chrome, Firefox, Edge, Safari)

---

## 🎮 Como Executar

### 1. Clone o Repositório
```bash
git clone <url-do-repositorio>
cd WebServiceProject
```

### 2. Abra o Projeto no IntelliJ
1. Abra o IntelliJ IDEA
2. File → Open
3. Selecione a pasta `WebServiceProject`
4. Aguarde a indexação e download das dependências

### 3. Execute o Backend
1. Localize `WebServiceProjectApplication.java`
2. Clique com botão direito → Run
3. Aguarde até ver: `Started WebServiceProjectApplication`
4. Backend rodando em: `http://localhost:8080`

### 4. Abra o Frontend
1. Navegue até a pasta `frontend`
2. Abra `login.html` no navegador
3. Ou use Live Server (VS Code) para melhor experiência

### 5. Faça Login
- **Admin:** `johann@gmail.com` / `johann`
- **Cliente:** `maria@gmail.com` / `12345`

📖 **Documentação completa:** Veja [COMO_EXECUTAR.md](COMO_EXECUTAR.md)

---

## 📁 Estrutura do Projeto

```
WebServiceProject/
├── src/
│   └── main/
│       └── java/io/github/johann0301/webserviceproject/
│           ├── config/
│           │   ├── CorsConfig.java          # Configuração CORS
│           │   └── TestConfig.java          # População de dados de teste
│           ├── entities/
│           │   ├── User.java                # Entidade Usuário
│           │   ├── Product.java             # Entidade Produto
│           │   ├── Order.java               # Entidade Pedido
│           │   ├── OrderItem.java           # Entidade Item de Pedido
│           │   ├── Category.java            # Entidade Categoria
│           │   └── Payment.java             # Entidade Pagamento
│           ├── repositories/
│           │   ├── UserRepository.java
│           │   ├── ProductRepository.java
│           │   ├── OrderRepository.java
│           │   ├── OrderItemRepository.java
│           │   └── CategoryRepository.java
│           ├── services/
│           │   ├── UserService.java
│           │   ├── ProductService.java
│           │   └── OrderService.java
│           ├── resources/
│           │   ├── UserResource.java        # Endpoints de usuários
│           │   ├── ProductResource.java     # Endpoints de produtos
│           │   └── OrderResource.java       # Endpoints de pedidos
│           ├── dto/
│           │   └── OrderDTO.java            # DTO para criação de pedidos
│           └── WebServiceProjectApplication.java
│
├── frontend/
│   ├── index.html                           # Interface principal
│   ├── login.html                           # Página de login
│   ├── app.js                               # Lógica principal
│   ├── login.js                             # Lógica de autenticação
│   └── styles.css                           # Estilos (dark theme)
│
├── pom.xml                                  # Dependências Maven
├── README.md                                # Este arquivo
└── COMO_EXECUTAR.md                         # Guia de execução
```

---

## 🔌 API Endpoints

### Usuários
- `GET /users` - Lista todos os usuários
- `GET /users/{id}` - Busca usuário por ID
- `POST /users` - Cria novo usuário
- `PUT /users/{id}` - Atualiza usuário
- `DELETE /users/{id}` - Remove usuário

### Produtos
- `GET /products` - Lista todos os produtos
- `GET /products/{id}` - Busca produto por ID

### Pedidos
- `GET /orders` - Lista todos os pedidos
- `GET /orders/{id}` - Busca pedido por ID
- `POST /orders` - Cria novo pedido

### Categorias
- `GET /categories` - Lista todas as categorias
- `GET /categories/{id}` - Busca categoria por ID

---

## 🔑 Credenciais de Teste

### Administrador:
- **Email:** johann@gmail.com
- **Senha:** johann

### Clientes:
| Nome | Email | Senha |
|------|-------|-------|
| Maria Silva | maria@gmail.com | 12345 |
| João Santos | joao@gmail.com | 54321 |
| Ana Costa | ana@gmail.com | senha123 |
| Pedro Oliveira | pedro@gmail.com | pedro2024 |
| Julia Ferreira | julia@gmail.com | julia@123 |

---

## 📊 Dados de Teste

O sistema vem pré-populado com:
- ✅ **5 Usuários** de teste
- ✅ **15 Produtos** com imagens reais
- ✅ **5 Categorias** (Eletrônicos, Livros, Computadores, Games, Acessórios)
- ✅ **10 Pedidos** com status variados

---

## 🎨 Capturas de Tela

### Login
Interface de login com opções para cliente e administrador.

### Dashboard (Admin)
Estatísticas gerais, usuários recentes e produtos em destaque.

### Produtos
Catálogo de produtos com imagens, preços e botão de compra.

### Carrinho
Visualização do carrinho com ajuste de quantidades.

### Pedidos
Lista de pedidos com status coloridos e filtros por usuário.

---

## 🛠️ Desenvolvimento

### Executar em Modo de Desenvolvimento
```bash
# Backend (IntelliJ)
Run 'WebServiceProjectApplication'

# Frontend
Abrir index.html no navegador
```

### Acessar Console H2
```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (deixe vazio)
```

---

## 📝 Funcionalidades Futuras

- [ ] Upload de imagens de produtos
- [ ] Sistema de pagamento integrado
- [ ] Filtros e busca de produtos
- [ ] Avaliações e comentários
- [ ] Histórico de pedidos detalhado
- [ ] Notificações por email
- [ ] Relatórios e gráficos avançados

---

## 👨‍💻 Autor

**Johann**
- GitHub: [@johann0301](https://github.com/johann0301)

---

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.

---

## 🙏 Agradecimentos

Desenvolvido como projeto de estudo de Spring Boot e desenvolvimento full-stack.

---

**⭐ Se este projeto foi útil para você, considere dar uma estrela!**
