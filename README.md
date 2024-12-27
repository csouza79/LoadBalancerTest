Load Balancer em Java

Este repositório apresenta um exemplo funcional de um sistema de Load Balancer em Java, implementado com a estratégia Round Robin para distribuir requisições entre múltiplos servidores simulados.

Índice

Visão Geral

Requisitos

Arquitetura

Como Executar

Testando o Sistema

Tecnologias Utilizadas

Visão Geral

A solução inclui:

Servidores: Três servidores simulados que processam requisições.

Load Balancer: Gerencia a distribuição de requisições entre os servidores.

Cliente: Envia requisições ao Load Balancer.

A estratégia de balanceamento utilizada é o Round Robin, garantindo que as requisições sejam distribuídas de forma equitativa entre os servidores.

Requisitos

Java 11 ou superior

IDE ou terminal com o javac e java configurados

Arquitetura

Server: Representa os servidores que respondem às requisições do cliente.

LoadBalancer: Distribui as requisições recebidas entre os servidores usando Round Robin.

Client: Simula um cliente enviando requisições ao Load Balancer.

Como Executar

Clone o Repositório

git clone https://github.com/seu-usuario/seu-repositorio.git
cd seu-repositorio

Compile os Arquivos
Compile todos os arquivos Java:

javac Server.java LoadBalancer.java Client.java

Inicie os Servidores
Em três terminais diferentes, execute os servidores:

java Server 8081 Server1
java Server 8082 Server2
java Server 8083 Server3

Inicie o Load Balancer
Em um terminal separado, execute o Load Balancer:

java LoadBalancer

Execute o Cliente
Finalmente, execute o cliente para enviar requisições:

java Client

Testando o Sistema

Os servidores exibem logs das requisições que recebem.

O Load Balancer distribui as requisições alternadamente entre os servidores.

O cliente exibe as respostas dos servidores no terminal.

Exemplo de saída do cliente:

Cliente enviando requisição 1
Resposta do servidor: Response from Server1
Cliente enviando requisição 2
Resposta do servidor: Response from Server2
Cliente enviando requisição 3
Resposta do servidor: Response from Server3

Tecnologias Utilizadas

Java 11: Linguagem principal.

HTTPServer: Usado para simular servidores.

Sinta-se à vontade para enviar pull requests ou abrir issues para melhorias!

