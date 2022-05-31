package org.serratecbackend.projeto07.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="servPrestado")
public class ServPrestado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="servico_cd_id")
	private Integer idServico;
	
	@Column(name="servico_tx_servico")
	private String servico;
	
	@Column(name="servico_valor")
	@NotNull
	private Double valor;
	
	@Column(name="servico_data")
	@NotNull
	private LocalDate data;
	
	@Column(name="servico_tx_carro")
	@NotNull
	private String carroModelo;
	
	@ManyToOne
	@JoinColumn(name = "servico_carro", referencedColumnName = "carro_cd_id")
	private Carro carro;
	
	
	public ServPrestado() {
		
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

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public String getServico() {
		return servico;
	}

	public void setServico(String servico) {
		this.servico = servico;
	}
	
}
