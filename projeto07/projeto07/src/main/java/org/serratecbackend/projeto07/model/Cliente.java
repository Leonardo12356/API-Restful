package org.serratecbackend.projeto07.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cliente_cd_id")
	private Integer idCliente;
	
	@Column(name="cliente_tx_nome")
	@NotNull
	private String nome;
	
	@Column(name="cliente_tx_cpf", unique = true)
	@NotNull
	private String cpf;
	
	@Column(name="cliente_tx_numero_telefone")
	private String numeroTelefone;
	
	@Column(name="cliente_tx_email")
	private String email;
	
	//atributo que vai ser relacionar com outra classe, mais como? lembra a classe email
	@OneToMany(mappedBy = "cliente")
    private List<Carro> listaCarro;
	
	
	public Cliente() {
		
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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

	public List<Carro> getListaCarro() {
		return listaCarro;
	}

	public void setListaCarro(List<Carro> listaCarro) {
		this.listaCarro = listaCarro;
	}
	
	
	
}
