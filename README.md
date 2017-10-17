# cartas-alunos-matera
Processo seletivo - Java back-end Matera

Thiago Hernandes de Souza
----------------------------------------------
OBS: devido a incompatibilidade entre as vers�es do: Java 8 (que foi usado em fun��es), Wildfly 10 
e principalmente com o Spring Boot, tive que de �ltima hora fazer o envio de e-mails utilizando o JavaMail para completar o processo
----------------------------------------------
------------ Instru��es ------------  
ATEN��O! � preciso colocar os dados da conta do Gmail na aplica��o nas vari�veis da classe: Utils.java

Exemplo:
static String contaGoogle = "fulano@gmail.com";
static String senhaGoogle = "123456";

Tamb�m, ap�s logada na conta do Gmail, ir at�: https://myaccount.google.com/lesssecureapps 
e habilitar:
Aplicativos menos seguros:
Permitir aplicativos menos seguros: ATIVADA

Em seguida, compilar e gerar o artefato para poder testar.
No meu caso utilizei o Postman.

git clone https://github.com/thiagohernandes/cartas-alunos-matera.git

OBS: dados em mem�ria - banco de dados

Passos a seguir:

1 - Ap�s clonar o projeto, importar para Eclipse como projeto do Maven;
2 - Configurar o JDK/JRE para Java 8;
3 - Realizar o download do Wildfly 10;
4 - No diret�rio raiz do projeto, fazer :
	4.1 - mvn clean compile
	4.2 - mvn clean package
5 - Copiar o artefato (cartas-alunos-matera.war) gerado no diret�rio "targed" para o
diret�rio "widlfly10/standalone/deployments"
6 - acessar as funcionalidades em: 
6.1 - http://localhost:8080/cartas-alunos-matera/api/alunos/todos - retorna todos os alunos e respectivas notas/disciplinas
6.2 - http://localhost:8080/cartas-alunos-matera/api/alunos/1478963211/notas - retorna as notas/disciplinas de um aluno espec�fico por CPF
(CPFs fict�cios cadastrados em mem�ria: 123456789, 987456321 e 1478963211)
6.3 http://localhost:8080/cartas-alunos-matera/api/alunos/notabaixa - retorna os alunos que possuem notas abaixo da m�dia - usar o CPF: 123456789 que cont�m uma nota abaixo da m�dia
6.4 http://localhost:8080/cartas-alunos-matera/api/alunos/maladireta - processamento do envio de e-mails




