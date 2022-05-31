package org.serratecbackend.projeto07.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "carro")
public class Carro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carro_cd_id")
	private Integer idCarro;
	
	@Column(name = "modelo_tx_carro")
	@NotNull
	private String modelo;

	@Column(name = "marca_tx_carro")
	@NotNull
	private String marca;

	@Column(name = "ano_tx_carro")
	@NotNull
	private String ano;

	@OneToMany(mappedBy = "carro")
	private List<ServPrestado> listaServico;
	
	@ManyToOne
    @JoinColumn(name = "cliente_proprietario", referencedColumnName = "cliente_cd_id")
    private Cliente cliente;

	
	public Carro() {

	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}
	


	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public List<ServPrestado> getListaServico() {
		return listaServico;
	}

	public void setListaServico(List<ServPrestado> listaServico) {
		this.listaServico = listaServico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
