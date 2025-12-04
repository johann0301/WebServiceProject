# 🚀 Como Executar o Projeto

## 📋 Pré-requisitos (Para Quem Vai Usar Pela Primeira Vez)

Antes de executar o projeto, certifique-se de ter instalado:

### 1. **Java Development Kit (JDK) 17 ou superior**
- **Download:** https://www.oracle.com/java/technologies/downloads/
- **Verificar instalação:**
  ```bash
  java -version
  ```
  Deve mostrar: `java version "17.x.x"` ou superior

### 2. **IntelliJ IDEA** (Community ou Ultimate)
- **Download:** https://www.jetbrains.com/idea/download/
- A versão Community (gratuita) funciona perfeitamente

### 3. **Maven** (Geralmente já vem com o IntelliJ)
- Se não tiver, o IntelliJ baixa automaticamente
- **Verificar:**
  ```bash
  mvn -version
  ```

### 4. **Navegador Web Moderno**
- Chrome, Firefox, Edge, ou Safari
- Qualquer navegador atualizado funciona

---

## ⚙️ Configuração Inicial (Apenas na Primeira Vez)

### 1. **Abrir o Projeto no IntelliJ**
1. Abra o IntelliJ IDEA
2. Clique em **"Open"** ou **"Open Project"**
3. Navegue até a pasta do projeto `WebServiceProject`
4. Selecione a pasta e clique em **"OK"**

### 2. **Aguardar Indexação**
- O IntelliJ vai indexar o projeto (barra de progresso no canto inferior)
- Vai baixar as dependências do Maven automaticamente
- **Aguarde até terminar** (pode levar alguns minutos na primeira vez)

### 3. **Verificar SDK do Java**
1. Vá em **File → Project Structure** (Ctrl+Alt+Shift+S)
2. Em **Project Settings → Project**
3. Verifique se o **SDK** está configurado para **Java 17** ou superior
4. Se não estiver, clique em **"Add SDK"** e selecione o JDK instalado

---

## Passo 1: Iniciar o Backend no IntelliJ

1. Abra o projeto no **IntelliJ IDEA**
2. Localize a classe `WebServiceProjectApplication.java` em:
   ```
   src/main/java/io/github/johann0301/webserviceproject/WebServiceProjectApplication.java
   ```
3. Clique com o botão direito na classe e selecione **"Run 'WebServiceProjectApplication'"**
4. Aguarde o Spring Boot iniciar (você verá no console: `Started WebServiceProjectApplication`)
5. O backend estará rodando em: **http://localhost:8080**

## Passo 2: Abrir a Interface Frontend

### Opção A: Abrir Diretamente (Mais Simples)
1. Navegue até a pasta `frontend` no explorador de arquivos
2. Clique duas vezes no arquivo **`index.html`**
3. O navegador abrirá automaticamente

### Opção B: Usar Live Server (Recomendado se tiver problemas)
1. Instale a extensão **Live Server** no VS Code (se usar)
2. Clique com botão direito em `index.html` → **"Open with Live Server"**

### Opção C: Pelo IntelliJ
1. Clique com botão direito em `frontend/index.html`
2. Selecione **"Open In" → "Browser"**
3. Escolha seu navegador preferido

## ✅ Verificar se está Funcionando

Quando a interface abrir, você deve ver:

1. **Sidebar** à esquerda com menu de navegação
2. **Dashboard** com cards de estatísticas
3. **Indicador de API** no rodapé da sidebar:
   - 🟢 **Verde (API Conectada)** = Tudo funcionando!
   - 🔴 **Vermelho (API Offline)** = Backend não está rodando

## 🎯 Funcionalidades Disponíveis

### Dashboard
- Visualize estatísticas gerais
- Veja usuários recentes
- Veja produtos em destaque

### Usuários
- Clique em **"Usuários"** no menu lateral
- Clique em **"Novo Usuário"** para adicionar
- Use os botões **"Editar"** e **"Excluir"** na tabela

### Produtos
- Clique em **"Produtos"** para ver o catálogo
- Cards com imagens e preços

### Pedidos
- Clique em **"Pedidos"** para ver todos os pedidos
- Tabela com status coloridos

## 🐛 Solução de Problemas

### API Offline (Bolinha Vermelha)
- ✅ Certifique-se que o backend está rodando no IntelliJ
- ✅ Verifique se está na porta 8080
- ✅ Abra http://localhost:8080/users no navegador para testar

### Página em Branco
- ✅ Abra o Console do navegador (F12)
- ✅ Verifique se há erros de CORS
- ✅ A configuração CORS já foi adicionada em `CorsConfig.java`

### Dados Não Aparecem
- ✅ Verifique se o `TestConfig.java` está populando dados de teste
- ✅ Olhe o console do IntelliJ para ver se há erros

## 📁 Estrutura Criada

```
WebServiceProject/
├── frontend/                    ← NOVA PASTA
│   ├── index.html              ← Interface principal
│   ├── styles.css              ← Estilos modernos
│   ├── app.js                  ← Lógica JavaScript
│   └── README.md               ← Documentação detalhada
└── src/main/java/.../config/
    └── CorsConfig.java         ← NOVO (permite frontend acessar API)
```

## 🎨 Design

A interface possui:
- ✨ Tema escuro moderno
- 🌈 Gradientes e glassmorphism
- 🎭 Animações suaves
- 📱 Design responsivo
- 🎯 Ícones SVG integrados

## 💡 Dica

Mantenha o IntelliJ aberto com o backend rodando e a interface aberta no navegador. Qualquer mudança no backend será refletida automaticamente após reiniciar a aplicação no IntelliJ.

---

**Pronto para usar! 🎉**
