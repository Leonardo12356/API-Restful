package org.serratecbackend.projeto07.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratecbackend.projeto07.DTO.ServPrestadoDTO;
import org.serratecbackend.projeto07.exception.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailService {

	@Autowired
	private JavaMailSender emailSender;
	
	@Value("${spring.mail.username}")
	private String userName;
	
	@Value("${spring.mail.host}")
	private String host;
	
	@Value("${spring.mail.password}")
	private String senha;
	
	@Value("${spring.mail.destinatario}")
	private String emailDestinatario;
	
	
	public JavaMailSender javaMailSender() {
		
		JavaMailSenderImpl enviarEmail = new JavaMailSenderImpl();
		Properties prop = new Properties();
		
		enviarEmail.setHost(host);
		enviarEmail.setPort(465);
		enviarEmail.setUsername(userName);
		enviarEmail.setPassword(senha);
		enviarEmail.setProtocol("smtp");
		enviarEmail.setDefaultEncoding("UTF-8");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.ssl.enable", true);
		enviarEmail.setJavaMailProperties(prop);
		
		return enviarEmail;
	}
	
	public void sendMessage(String to, String subject, String text) {

		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(userName);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
	
	public void emailTeste(ServPrestadoDTO sPrestadoDTO) throws MessagingException, EmailException{
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		try {
			helper.setFrom("squad6serratec@gmail.com");
			helper.setTo(emailDestinatario);
			
			helper.setSubject("Assunto do Email");
			
			StringBuilder sBuilder = new StringBuilder();
			
			sBuilder.append("<html lang=\"en\">\r\n"
					+ "\r\n"
					+ "<body>\r\n"
					+ "<h3>Seu carro  está finalizado!</h3>"
					+ "<a>Segue abaixo nota de serviço:</a>"
					+ "<br></br>"
					+ "<a>-----------------------------------------</a>"
					+ "<br></br>"
					+ "<a>Data: </a>" + sPrestadoDTO.getData() 
					+ "<br></br>"
					+ "<a>Descrição: </a>" + sPrestadoDTO.getServico()
					+ "<br></br>"
					+ "<a>Valor: </a>" + sPrestadoDTO.getValor()
					+ "<br></br>"
					+ "<a>------------------------------------------</a>"
					+ "</body>\r\n"
					+ "\r\n"
					+ "</html>");
			helper.setText(sBuilder.toString(),true);
			
			emailSender.send(message);
		}catch(Exception e) {
			throw new EmailException("houve erro ao enviar o email " + e.getMessage());
		}
	}
	
}
