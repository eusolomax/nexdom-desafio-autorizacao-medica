# Tecnologias
- Java 8
- Maven
- JSP
- Servlets
- JDBC
- H2
- Liquibase
- Tomcat 9

## Requisitos
- Java 8
- Maven 3.8+
- Apache Tomcat 9

---
## Aviso Tomcat
Tutorial de <a href="https://www.digitalocean.com/community/tutorials/install-tomcat-on-linux#how-to-install-tomcat-on-linux" target="_blank">como instalar o Tomcat no Linux</a>
1. A versão que o tutorial apresenta (**v9.0.34**) parece não existir mais no mirror da Apache, então substitua pela versão **v9.0.118**.
2. No arquivo service, o tutorial mostra o environment do Java na versão 1.11.0; Se necessário, mude para a sua versão (em: **/usr/lib/jvm/**)

## Aviso sobre as migrations
O banco é gerado automaticamente durante a inicialização da aplicação usando o Liquibase, então não é necessário criar as tabelas manualmente

# Instalação:

## 1. Clone o repositório
Após instalar o Tomcat no Linux, clone o repositório:
```bash
git clone https://github.com/eusolomax/nexdom-desafio-autorizacao-medica.git
```

## 2. Entre no diretório
```bash
cd nexdom-desafio-autorizacao-medica
```


## 3. Gerar o WAR
Dentro da pasta, rode o comando:
```bash
mvn clean package
```

O build fica gerado em:
```text
target/autorizacao-medica.war
```

---

## 4. Deploy no Tomcat
Copiar o arquivo WAR para a pasta webapps do Tomcat:
```bash
sudo cp target/autorizacao-medica.war /opt/tomcat/updated/webapps/
```

(Caso não tenha o symlink `updated` do Tomcat, substitua no path pela sua versão)

---

## 5. Acessar aplicação
Tela principal:

```text
http://localhost:8080/autorizacao-medica
```

Listagem de solicitações:
```text
http://localhost:8080/autorizacao-medica/solicitacoes
```

---

# Funcionalidades

<img width="542" height="256" alt="image" src="https://github.com/user-attachments/assets/722ab0f1-f7bc-4cb9-b076-48324b1fd679" />

### Consulta de autorização

Permite consultar uma autorização médica informando no form:
- Procedimento
- Idade
- Sexo

O sistema verifica as regras cadastradas e retorna:
```text
Procedimento autorizado!
```

ou

```text
Procedimento negado ou inexistente.
```

---

### Registro de solicitações

Todas as consultas válidas realizadas são registradas na tabela:

```text
solicitacao_autorizacao
```

que é possivel ser acesso na âncora **Solicitações** da página principal (rota: `/solicitacoes`)

---

### Listagem de solicitações

Permite visualizar o histórico completo das solicitações realizadas.

---

## Executar testes
```bash
mvn test
```

---

## Banco de Dados
Tabelas:

```text
regra_autorizacao
solicitacao_autorizacao
```
