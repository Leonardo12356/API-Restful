package org.serratecbackend.projeto07.controller;

import java.util.List;

import org.serratecbackend.projeto07.DTO.ClienteDTO;
import org.serratecbackend.projeto07.exception.ClienteException;
import org.serratecbackend.projeto07.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody ClienteDTO clienteDTO) throws ClienteException {
		return ResponseEntity.ok(clienteService.salvar(clienteDTO));
	}
	
	@GetMapping("/buscar/{idCliente}")
	public ResponseEntity<ClienteDTO> buscarPorId(@PathVariable Integer idCliente) throws ClienteException{
		return ResponseEntity.ok(clienteService.buscarPorId(idCliente));
	}
	
	@DeleteMapping("/{idCliente}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCliente){
		clienteService.deletar(idCliente);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idCliente}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idCliente, @RequestBody ClienteDTO clienteDTO)throws ClienteException{
		return ResponseEntity.ok(clienteService.atualizar(idCliente, clienteDTO));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<ClienteDTO>> listarTodos(){
		return ResponseEntity.ok(clienteService.buscarTodos());
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<ClienteDTO> listaClienteDTO){
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
