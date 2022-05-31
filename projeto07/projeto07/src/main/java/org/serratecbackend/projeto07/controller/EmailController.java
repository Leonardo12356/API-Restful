package org.serratecbackend.projeto07.controller;

import javax.mail.MessagingException;

import org.serratecbackend.projeto07.DTO.ServPrestadoDTO;
import org.serratecbackend.projeto07.exception.EmailException;
import org.serratecbackend.projeto07.service.ClienteService;
import org.serratecbackend.projeto07.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping("/email")
	public void enviarEmail(ServPrestadoDTO sPrestadoDTO) throws MessagingException, EmailException{
		emailService.emailTeste(sPrestadoDTO);
	}
}