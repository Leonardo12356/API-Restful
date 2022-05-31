package org.serratec.backend.projeto05.service;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.serratec.backend.projeto05.DTO.CartaoDTO;
import org.serratec.backend.projeto05.exception.EmailException;
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
	
	@Value("${spring.mail.email.remetente}")
	private String emailRemetente;
	
	
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
		message.setFrom(emailRemetente);
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}
	
	public void emailTeste(CartaoDTO cartaoDTO) throws MessagingException, EmailException{
		
		this.emailSender = javaMailSender();
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message,true);
		
		try {
			helper.setFrom("serratecRenan@gmail.com");
			helper.setTo(emailRemetente);
			
			helper.setSubject("Assunto do Email");
			
			StringBuilder sBuilder = new StringBuilder();
			
			sBuilder.append("<html>\r\n" + "<body>\r\n" + "<div>\r\n" + "<br/>" + "---------------------<br/>"
                    + "O cartao foi criado com sucesso!!\r\n"
                    + "\r\n"
                    + "Segue os dados do seu cartão:\r\n"
                    + "\r\n"
                    + "Nome:" + cartaoDTO.getNomeTitular() + "\r\n"
                    + "Numero do Cartão:" + cartaoDTO.getNumeroCartao() +"\r\n"
                    + "\r\n" 
                    + "Att,\r\n"
                    + "Equipe do Banco sua pobreza nossa alegria agradece!!!!<br/>"
                    + "---------------------------------------------------------------------------------<br/>"
                    + "<br/>" + "Att: Leonardo <br/>" + "div>\r\n"
                    + "</div>" + "</body>\r\n" + "</html>\r\n ");
			helper.setText(sBuilder.toString(),true);
			
			emailSender.send(message);
		}catch(Exception e) {
			throw new EmailException("houve erro ao enviar o email " + e.getMessage());
		}
	}
	
}
