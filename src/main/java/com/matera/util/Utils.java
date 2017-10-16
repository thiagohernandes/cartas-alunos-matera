package com.matera.util;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.matera.model.Aluno;

/**
 * Classe utilitária do back-end
 * @author Thiago Hernandes de Souza
 * @since 16-10-2017
 * */
public class Utils {
	
	static Properties props;
	static Session getMailSession;
	static MimeMessage generateMailMessage;
	static String contaGoogle = "";
	static String senhaGoogle = "";
	
	protected int aux = 0;
	
	/** 
	 * Processamento de email por alunos
	 * */
	public int processEmail(List<Aluno> alunos) {
		alunos.stream().forEach(aluno -> {
		    try {
				sendEmail(aluno.getEmail());
			} catch (MessagingException e) {
				System.err.print("Problemas no envio do e-mail! - Erro -> "+e);
			}
				aux++;				
		});	
		return aux;
	}
	
	/** 
	 * Método responsável pelo envio de e-mails
	 * */
	protected void sendEmail(String emailAluno) throws AddressException, MessagingException{
		props = System.getProperties();
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
 
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
		    protected PasswordAuthentication getPasswordAuthentication() {
		        return new PasswordAuthentication(contaGoogle, senhaGoogle);
		    }
		  });
		
		getMailSession = session;
		generateMailMessage = new MimeMessage(session);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAluno));
		generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(contaGoogle));
		generateMailMessage.setSubject("Aviso de nota abaixo da média");
		String emailBody = "ATENÇÃO! Você possui nota(s) abaixo da média. Favor, verificar o quanto antes" 
						  + "<br><br> Att, <br>Matera Systems";
		generateMailMessage.setContent(emailBody, "text/html");
		Transport transport = getMailSession.getTransport("smtp");
		transport.connect("smtp.gmail.com", contaGoogle, senhaGoogle);
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();	
	}
			
}
