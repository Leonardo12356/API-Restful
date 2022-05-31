package org.serratecbackend.projeto07.DTO;

import java.io.Serializable;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idCliente;
	private Integer idCarro;
	private String nome;
	private String cpf;
	private String numeroTelefone;
	private String email;
	
	public ClienteDTO() {
		
	}

	

	public Integer getIdCliente() {
		return idCliente;
	}



	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	


	public Integer getIdCarro() {
		return idCarro;
	}



	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
