# Baozi Store

**Baozi Store** é uma API REST desenvolvida em Java utilizando o framework Spring Boot.

## 🚀 Tecnologias Utilizadas

O projeto foi criado utilizando as seguintes tecnologias:

*   **Java 21**
*   **Spring Boot** (versão 4.0.4)
    *   Spring Data JPA (Persistência de dados)
    *   Spring Web (Construção da API REST)
*   **MySQL** (Banco de dados relacional)
*   **Docker Compose** (Gerenciamento do container do banco de dados)
*   **Maven** (Gerenciamento de dependências e build)

## 📋 Pré-requisitos

Antes de começar, você precisará ter instalado em sua máquina as seguintes ferramentas:

*   [Java Development Kit (JDK) 21](https://adoptium.net/)
*   [Maven](https://maven.apache.org/)
*   [Docker](https://www.docker.com/) e Docker Compose (para rodar o banco de dados MySQL localmente)

## ⚙️ Como Executar o Projeto

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/VitorBuera/BaoziStoreApi.git
    cd baozi.store
    ```

2.  **Inicie o banco de dados (MySQL) usando Docker Compose:**
    O projeto já está configurado com `spring-boot-docker-compose`, então o Spring Boot subirá o container do banco de dados automaticamente ao rodar a aplicação, desde que o Docker esteja em execução. 
    *Alternativamente*, você pode subir o banco separadamente com:
    ```bash
    docker-compose up -d
    ```

3.  **Compile e execute a aplicação:**
    Utilizando o Maven:
    ```bash
    mvn spring-boot:run
    ```

4.  **Acesse a API:**
    A aplicação estará rodando tipicamente em `http://localhost:8080` (verifique as portas no log de execução ou no `application.properties`).

## 🛠️ Estrutura do Projeto

*   `/src/main/java`: Contém todo o código-fonte Java da API.
*   `/src/main/resources`: Arquivos de configuração (como `application.properties`).
*   `/pom.xml`: Arquivo de configuração do Maven com todas as dependências do projeto.
*   `compose.yaml`: Arquivo de configuração para subir o banco de dados MySQL no Docker.
