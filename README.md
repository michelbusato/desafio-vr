# Desafio VR

Desafio técnico de uma API de Mini Autorizador

## Características

- API RESTful
- Validation
- MockMVC

## Stacks

- Java JDK 11
- Apache Maven 3.8.6
- MySql 8
- Docker (Opcional)

## Execução

```
$ git clone https://github.com/michelbusato/desafio-vr.git

$ cd prova-vr
```

## Utilizando Maven

Para rodar o projeto com Maven, é necessário ter a versão 3.8.6 instalada.<br>
Além disso, é preciso ter o Java 11 e o MySql 8 instalado.<br>

Tendo tudo configurado e rodando localmente e necessário executar o comando abaixo:

```
$ cd miniautorizador
$ mvn clean spring-boot:run -Dspring-boot.run.profiles=dev
```

Caso não tenha o Maven instalado ou tenha outra versão, pode usar o comando ./mvnw (no Linux) ou mvnw.cmd (no Windows).

## Utilizando Docker 

Para executar o projeto via Docker-Compose, basta o comando:

```
$ cd docker
$ docker-compose up
```

Aguarde baixar as dependências e carregar todo o projeto, esse processo é demorado. <br>
Caso conclua e não rode pela primeira vez, tente novamente executando o mesmo comando. <br>

Para encerrar tudo digite:

```
$ docker-compose down
```

Aguarde carregar todo o serviço web. <br>
Após concluído, digite um dos endereços abaixo em seu navegador. <br>

Listar cartões cadastrados: <br>
http://localhost:8080/cartoes

Listar transações cadastradas: <br>
http://localhost:8080/transacoes

## Swagger 

Documentação da API RESTful: <br>

http://localhost:8080/swagger-ui.html

## SonarQube

Para verificar a cobertura de testes, primeiro acesse o seguinte endereço: <br>
http://localhost:9000

Depois efetue o login preenchendo "admin" no usuário e senha (login padrão). <br>
Ao se logar crie um novo projeto e gere o token.

Feito isso, entre no container criado da api:

```
$ docker exec -it api bash
```

Execute o seguinte comando do sonar:

```
$ mvn clean verify sonar:sonar -Dsonar.projectKey=NOME_PROJETO_GERADO -Dsonar.host.url=http://sonarqube:9000 -Dsonar.login=TOKEN_GERADO
```

Após executado, acesse o seguinte endereço: <br>

http://localhost:9090/dashboard?id=desafio-vr-api

## Testes

Para realizar os testes, execute o seguinte comando no terminal:

```
$ cd miniautorizador
$ mvn test
```


