package org.serratecbackend.projeto07.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.serratecbackend.projeto07.DTO.RelatorioDTO;
import org.serratecbackend.projeto07.DTO.ServPrestadoDTO;
import org.serratecbackend.projeto07.exception.EmailException;
import org.serratecbackend.projeto07.exception.ServPrestadoException;
import org.serratecbackend.projeto07.model.ServPrestado;
import org.serratecbackend.projeto07.repository.CarroRepository;
import org.serratecbackend.projeto07.repository.ServPrestadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServPrestadoService {

	@Autowired
	ServPrestadoRepository servRepository;
	
	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	EmailService emailService;
	
	public ServPrestadoDTO transformarModelEmDTO(ServPrestado sPrestado, ServPrestadoDTO sPrestadoDTO) {
		sPrestadoDTO.setIdServico(sPrestado.getIdServico());
		sPrestadoDTO.setIdCarro(sPrestado.getCarro().getIdCarro());
		sPrestadoDTO.setServico(sPrestado.getServico());
		sPrestadoDTO.setValor(sPrestado.getValor());
		sPrestadoDTO.setData(sPrestado.getData());
		sPrestadoDTO.setCarroModelo(sPrestado.getCarroModelo());
		return sPrestadoDTO;
	}
	
	public ServPrestado transformarDTOEmModel (ServPrestado sPrestado, ServPrestadoDTO sPrestadoDTO) throws ServPrestadoException {
		
		if(sPrestadoDTO.getValor() == null) {
			throw new ServPrestadoException("O valor do serviço não foi informado. ");
		}
		
		if(sPrestadoDTO.getData() == null) {
			throw new ServPrestadoException("A data do serviço não foi informado.");
		}
		
	
		
		// o id é cadastrado automaticamente
		sPrestado.setServico(sPrestadoDTO.getServico());
		sPrestado.setValor(sPrestadoDTO.getValor());
		sPrestado.setData(sPrestadoDTO.getData());
		sPrestado.setCarro(carroRepository.findById(sPrestadoDTO.getIdCarro()).get());
		sPrestado.setCarroModelo(sPrestadoDTO.getCarroModelo());
		return sPrestado;
	}
	public String salvar(ServPrestadoDTO sPrestadoDTO) throws ServPrestadoException, MessagingException, EmailException {
		ServPrestado sPrestado = new ServPrestado();
		transformarDTOEmModel(sPrestado, sPrestadoDTO);
		emailService.emailTeste(sPrestadoDTO);
		servRepository.save(sPrestado);
		
		return "O serviço prestado foi criado com uma id: " + sPrestado.getIdServico();
	}
	
	public ServPrestadoDTO buscarPorId(Integer idServico ) throws ServPrestadoException{
		Optional<ServPrestado> sPrestado = servRepository.findById(idServico);
		ServPrestado sPrestadoNoBanco = new ServPrestado();
		ServPrestadoDTO sPrestadoDTO = new ServPrestadoDTO();
		if(sPrestado.isPresent()) {
			sPrestadoNoBanco = sPrestado.get();
			transformarModelEmDTO(sPrestadoNoBanco, sPrestadoDTO);
			return sPrestadoDTO;
		}
		throw new ServPrestadoException("O carro com a id informada não foi encontrado");
	}
	
	public void deletar(Integer idServico) {
		servRepository.deleteById(idServico);
	}
	
	public String atualizar(Integer idServico, ServPrestadoDTO sPrestadoDTO) throws ServPrestadoException{
		Optional<ServPrestado> sPrestado = servRepository.findById(idServico);
		ServPrestado sPrestadoBanco = new ServPrestado();
		if(sPrestado.isPresent()) {
			sPrestadoBanco = sPrestado.get();
			if(sPrestadoDTO.getValor() != null) {
				sPrestadoBanco.setValor(sPrestadoDTO.getValor());
			}
			
			if(sPrestadoDTO.getData() != null) {
				sPrestadoBanco.setData(sPrestadoDTO.getData());
			}
			
			if(sPrestadoDTO.getIdCarro() != null) {
				sPrestadoBanco.setCarro(carroRepository.findById(sPrestadoDTO.getIdCarro()).get());
			}
			servRepository.save(sPrestadoBanco);
			return "O servico com a id " + sPrestadoBanco.getIdServico()+" foi atualizado!";
		}
		throw new ServPrestadoException("O servico não foi atualizado");
		
	}
	
	public List<ServPrestadoDTO> buscarTodos(){
		List<ServPrestado> servPrestadoModel = servRepository.findAll();
		List<ServPrestadoDTO> listaServPrestadoDTO = new ArrayList<>();
		for(ServPrestado sPrestado : servPrestadoModel) {
			ServPrestadoDTO sPrestadoDTO = new ServPrestadoDTO();
			transformarModelEmDTO(sPrestado, sPrestadoDTO);
			listaServPrestadoDTO.add(sPrestadoDTO);
		}
		return listaServPrestadoDTO;
	}
	
	public void salvarListaServico(List<ServPrestadoDTO> listaServPrestadoDTO) throws ServPrestadoException {
		List<ServPrestado> listaServPrestado = new ArrayList<>();
		
		for(ServPrestadoDTO sPrestadoDTO : listaServPrestadoDTO) {
			ServPrestado sPrestado = new ServPrestado();
			transformarDTOEmModel(sPrestado, sPrestadoDTO);
			listaServPrestado.add(sPrestado);
		}
		servRepository.saveAll(listaServPrestado);
	}
	
	public List<RelatorioDTO> relatorio(){
		return servRepository.relatorio();
	}
	
}
