# cartas-alunos-matera
Processo seletivo - Java back-end Matera

Thiago Hernandes de Souza
----------------------------------------------
OBS: devido a incompatibilidade entre as versões do: Java 8 (que foi usado em funções), Wildfly 10 
e principalmente com o Spring Boot, tive que de última hora fazer o envio de e-mails utilizando o JavaMail para completar o processo
----------------------------------------------
------------ Instruções ------------  
ATENÇÃO! É preciso colocar os dados da conta do Gmail na aplicação nas variáveis da classe: Utils.java

Exemplo:
static String contaGoogle = "fulano@gmail.com";
static String senhaGoogle = "123456";

Também, após logada na conta do Gmail, ir até: https://myaccount.google.com/lesssecureapps 
e habilitar:
Aplicativos menos seguros:
Permitir aplicativos menos seguros: ATIVADA

Em seguida, compilar e gerar o artefato para poder testar.
No meu caso utilizei o Postman.

git clone https://github.com/thiagohernandes/cartas-alunos-matera.git

OBS: dados em memória - banco de dados

Passos a seguir:

1 - Após clonar o projeto, importar para Eclipse como projeto do Maven;
2 - Configurar o JDK/JRE para Java 8;
3 - Realizar o download do Wildfly 10;
4 - No diretório raiz do projeto, fazer :
	4.1 - mvn clean compile
	4.2 - mvn clean package
5 - Copiar o artefato (cartas-alunos-matera.war) gerado no diretório "targed" para o
diretório "widlfly10/standalone/deployments"
6 - acessar as funcionalidades em: 
6.1 - http://localhost:8080/cartas-alunos-matera/api/alunos/todos - retorna todos os alunos e respectivas notas/disciplinas
6.2 - http://localhost:8080/cartas-alunos-matera/api/alunos/1478963211/notas - retorna as notas/disciplinas de um aluno específico por CPF
(CPFs fictícios cadastrados em memória: 123456789, 987456321 e 1478963211)
6.3 http://localhost:8080/cartas-alunos-matera/api/alunos/notabaixa - retorna os alunos que possuem notas abaixo da média - usar o CPF: 123456789 que contém uma nota abaixo da média
6.4 http://localhost:8080/cartas-alunos-matera/api/alunos/maladireta - processamento do envio de e-mails




