package org.com.java04backend.projeto04.service;

import java.util.ArrayList;
import java.util.List;

import org.com.java04backend.projeto04.exception.ContaException;
import org.com.java04backend.projeto04.model.Conta;
import org.springframework.stereotype.Service;

@Service
public class ContaService {

	List<Conta> contaBanco = new ArrayList<>();

	public List<Conta> listarTodasContas() {
		return this.contaBanco;
	}
	
	public void adicionarConta(Conta numeroConta) {
		contaBanco.add(numeroConta);
	}

	public void deletarConta(int numeroConta) {
		contaBanco.remove(numeroConta);
	}

	public void atualizarConta(Integer numeroConta, Conta contaAPI) {
		Conta attConta = contaBanco.get(numeroConta);
		attConta.setSaldo(contaAPI.getSaldo());
		attConta.setNumero(contaAPI.getNumero());
		attConta.setTitular(contaAPI.getTitular());
	}

	

	public Conta listarContaPorId(Integer idConta) {
		Conta contaAPI = new Conta();
		for (Conta conta : contaBanco) {
			if (conta.getNumero().equals(idConta)) {
				contaAPI = conta;
			}
		}
		return contaAPI;
	}

	public void creditarConta(Integer idConta, Double valorCredito) {
		Conta contaUtilizada = contaBanco.get(idConta);
		contaUtilizada.setSaldo(contaUtilizada.getSaldo() + valorCredito);
	}

	public void debitarConta(Integer idConta, Double valorDebito) throws ContaException {
		Conta contaUtilizada = contaBanco.get(idConta);
		if (contaUtilizada.getSaldo() >= valorDebito) {
			contaUtilizada.setSaldo(contaUtilizada.getSaldo() - valorDebito);
		} else {
			throw new ContaException(idConta);
		}
	}

}