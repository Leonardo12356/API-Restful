package org.serratecbackend.projeto07.DTO;

import java.io.Serializable;
import java.time.LocalDate;

public class ServPrestadoDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer idServico;
	private String servico;
	private Double valor;
	private LocalDate data;
	private String carroModelo;
	private Integer idCarro;
	
	public ServPrestadoDTO() {
		
	}
	
	public Integer getIdServico() {
		return idServico;
	}

	public void setIdServico(Integer idServico) {
		this.idServico = idServico;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getCarroModelo() {
		return carroModelo;
	}

	public void setCarroModelo(String carroModelo) {
		this.carroModelo = carroModelo;
	}

	public Integer getIdCarro() {
		return idCarro;
	}

	public void setIdCarro(Integer idCarro) {
		this.idCarro = idCarro;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}



}
