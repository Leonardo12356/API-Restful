package org.serratecbackend.projeto07.controller;

import java.util.List;

import javax.mail.MessagingException;

import org.serratecbackend.projeto07.DTO.RelatorioDTO;
import org.serratecbackend.projeto07.DTO.ServPrestadoDTO;
import org.serratecbackend.projeto07.exception.EmailException;
import org.serratecbackend.projeto07.exception.ServPrestadoException;
import org.serratecbackend.projeto07.service.ServPrestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servico")
public class ServPrestadoController {

	@Autowired
	ServPrestadoService sPrestadoService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ServPrestadoDTO sPrestadoDTO) throws ServPrestadoException, MessagingException, EmailException{
		return ResponseEntity.ok(sPrestadoService.salvar(sPrestadoDTO));
	}
	
	@GetMapping("/buscar/{idServico}")
	public ResponseEntity<ServPrestadoDTO> buscarPorId(@PathVariable Integer idServico) throws ServPrestadoException{
		return ResponseEntity.ok(sPrestadoService.buscarPorId(idServico));
	}
	
	@DeleteMapping("/{idServico}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idServico){
		sPrestadoService.deletar(idServico);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idServico}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idServico, @RequestBody ServPrestadoDTO sPrestadoDTO) throws ServPrestadoException{
		return ResponseEntity.ok(sPrestadoService.atualizar(idServico, sPrestadoDTO));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ServPrestadoDTO>> listarTodos(){
		return ResponseEntity.ok(sPrestadoService.buscarTodos());
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<ServPrestadoDTO> sPrestadoDTO){
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/relatorio")
	public List<RelatorioDTO> relatorio(){
		return sPrestadoService.relatorio();
	}
}
