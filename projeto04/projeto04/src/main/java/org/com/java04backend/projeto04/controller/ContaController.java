package org.com.java04backend.projeto04.controller;

import java.util.List;

import org.com.java04backend.projeto04.exception.ContaException;
import org.com.java04backend.projeto04.model.Conta;
import org.com.java04backend.projeto04.service.ContaService;
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
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	ContaService contaService;

	// Lista todas as contas funcionando
	@GetMapping("/lista")
	public List<Conta> listaCliente() {
		return contaService.listarTodasContas();
	}

	// Lista só uma conta 
	@GetMapping("/{idConta}")
	public ResponseEntity<Conta> buscarClientePorId(@PathVariable Integer idConta) {
		return ResponseEntity.ok(contaService.listarContaPorId(idConta));
	}

	// Insere uma nova conta 
	@PostMapping("/adicionar")
	public ResponseEntity<Void> adicionarConta(@RequestBody Conta conta) {
		contaService.adicionarConta(conta);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// Deleta uma conta existente porem a id é como vetor ex 0,1,2
	@DeleteMapping("/delete/{idConta}")
	public ResponseEntity<Void> deletar(@PathVariable int idConta) {
		contaService.deletarConta(idConta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	// Atualiza uma conta porem a id é como vetor ex 0,1,2
	@PutMapping("/atualizar/{idConta}")
	public ResponseEntity<Void> atualizarConta(@PathVariable Integer idConta, @RequestBody Conta conta) {
		contaService.atualizarConta(idConta, conta);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	// Adiciona crédito a uma conta porem a id é como vetor ex 0,1,2
	@PutMapping("/{idConta}/credito/{valorOperacao}")
	public ResponseEntity<Void> creditarConta(@PathVariable Integer idConta, @PathVariable Double valorOperacao) {
		contaService.creditarConta(idConta, valorOperacao);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}

	// Debita um valor na conta porem a id é como vetor ex 0,1,2
	@PutMapping("/{idConta}/debito/{valorOperacao}")
	public ResponseEntity<Void> debitarConta(@PathVariable Integer idConta, @PathVariable Double valorOperacao)
			throws ContaException {
		contaService.debitarConta(idConta, valorOperacao);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
