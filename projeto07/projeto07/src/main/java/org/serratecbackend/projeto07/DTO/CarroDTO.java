package org.serratecbackend.projeto07.DTO;

import java.io.Serializable;

public class CarroDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer idCarro;
    private Integer idCliente;
	private String modelo;
	private String marca;
	private String ano;

	
	public CarroDTO() {
		
	}
	
	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
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
	
}
