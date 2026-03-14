# Cadastro de Alunos (Aula 4)

Aplicação web em **Spring Boot + Thymeleaf** para cadastro, listagem, edição e exclusão de alunos.

## Tecnologias

- Java 25 (toolchain configurada no Gradle)
- Spring Boot 4
- Spring MVC
- Thymeleaf
- Gradle Wrapper

## Pré-requisitos

- JDK 25 instalado
- Permissão para executar o Gradle Wrapper

## Como executar o projeto

No Linux/macOS:

```bash
chmod +x gradlew
./gradlew bootRun
```

No Windows:

```bat
gradlew.bat bootRun
```

Após iniciar, acesse:

- http://localhost:8080/alunos

## Como usar o sistema

1. Abra `http://localhost:8080/alunos` para ver a lista de alunos.
2. Clique em **Cadastrar novo aluno** para abrir o formulário.
3. Preencha os campos obrigatórios:
	 - Nome
	 - Matrícula
	 - Curso
	 - Semestre (mínimo 1)
4. Clique em **Salvar** para cadastrar.
5. Na listagem, use:
	 - **Editar** para alterar os dados de um aluno.
	 - **Excluir** para remover um aluno.

## Endpoints

> Observação: este projeto usa rotas MVC (retorno de páginas HTML e redirects), não uma API REST JSON.

### 1) Listar alunos

- **Método:** `GET`
- **Rota:** `/alunos`
- **Descrição:** Exibe a página com todos os alunos cadastrados.
- **View retornada:** `alunos/alunos`

### 2) Página de cadastro

- **Método:** `GET`
- **Rota:** `/alunos/cadastro`
- **Descrição:** Exibe o formulário de cadastro de aluno.
- **View retornada:** `alunos/cadastro`

### 3) Cadastrar aluno

- **Método:** `POST`
- **Rota:** `/alunos/cadastrar`
- **Parâmetros de formulário:**
	- `nome` (String)
	- `matricula` (String)
	- `curso` (String)
	- `semestre` (int)
- **Descrição:** Cria um novo aluno e adiciona na lista em memória.
- **Resposta:** redirect para `/alunos`

### 4) Página de edição

- **Método:** `GET`
- **Rota:** `/alunos/editar/{id}`
- **Parâmetro de rota:**
	- `id` (int)
- **Descrição:** Exibe o formulário com os dados do aluno para edição.
- **Comportamento quando não encontra o ID:** redirect para `/alunos`
- **View retornada:** `alunos/editar`

### 5) Atualizar aluno

- **Método:** `POST`
- **Rota:** `/alunos/editar/{id}`
- **Parâmetro de rota:**
	- `id` (int)
- **Parâmetros de formulário:**
	- `nome` (String)
	- `matricula` (String)
	- `curso` (String)
	- `semestre` (int)
- **Descrição:** Atualiza os dados do aluno existente.
- **Resposta:** redirect para `/alunos`

### 6) Excluir aluno

- **Método:** `POST`
- **Rota:** `/alunos/excluir/{id}`
- **Parâmetro de rota:**
	- `id` (int)
- **Descrição:** Remove o aluno da lista.
- **Resposta:** redirect para `/alunos`

## Estrutura de dados do aluno

Entidade `Aluno`:

- `id` (int)
- `nome` (String)
- `matricula` (String)
- `curso` (String)
- `semestre` (int)

## Observações importantes

- Os dados são armazenados **em memória** (`ArrayList` no repositório).
- Ao reiniciar a aplicação, os alunos cadastrados são perdidos.
- Os IDs são gerados com base no tamanho atual da lista.