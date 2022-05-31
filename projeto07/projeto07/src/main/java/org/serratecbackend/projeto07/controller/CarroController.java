package org.serratecbackend.projeto07.controller;

import java.util.List;

import org.serratecbackend.projeto07.DTO.CarroDTO;
import org.serratecbackend.projeto07.exception.CarroException;
import org.serratecbackend.projeto07.service.CarroService;
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
@RequestMapping("/carro")
public class CarroController {

	@Autowired
	CarroService carroService;
	
	@PostMapping("/salvar")
	public ResponseEntity<String> salvar(@RequestBody CarroDTO carroDTO) throws CarroException{
		return ResponseEntity.ok(carroService.salvar(carroDTO));
	}
	
	@GetMapping("/buscar/{idCarro}")
	public ResponseEntity<CarroDTO> buscarPorId(@PathVariable Integer idCarro) throws CarroException{
		return ResponseEntity.ok(carroService.buscarPorId(idCarro));
	}
	
	@DeleteMapping("/{idCarro}")
	public ResponseEntity<Void> deletar(@PathVariable Integer idCarro){
		carroService.deletar(idCarro);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/atualizar/{idCarro}")
	public ResponseEntity<String> atualizar(@PathVariable Integer idCarro, @RequestBody CarroDTO carroDTO) throws CarroException{
		return ResponseEntity.ok(carroService.atualizar(idCarro, carroDTO));
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<CarroDTO>> listarTodos(){
		return ResponseEntity.ok(carroService.buscarTodos());
	}
	
	@PostMapping("/salvar-lista")
	public ResponseEntity<Void> salvarLista(@RequestBody List<CarroDTO> listaCarroDTO){
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
