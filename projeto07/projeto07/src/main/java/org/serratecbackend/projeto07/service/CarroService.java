package org.serratecbackend.projeto07.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratecbackend.projeto07.DTO.CarroDTO;
import org.serratecbackend.projeto07.exception.CarroException;
import org.serratecbackend.projeto07.model.Carro;
import org.serratecbackend.projeto07.repository.CarroRepository;
import org.serratecbackend.projeto07.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarroService {

	@Autowired
	CarroRepository carroRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public CarroDTO transformarModelEmDTO(Carro carro, CarroDTO carroDTO) {
		
		carroDTO.setIdCarro(carro.getIdCarro());
		carroDTO.setIdCliente(carro.getCliente().getIdCliente()); //certo??
		carroDTO.setModelo(carro.getModelo());
		carroDTO.setMarca(carro.getMarca());
		carroDTO.setAno(carro.getAno());	
		
		return carroDTO;
	}
	
	 public Carro transformarDTOEmModel(Carro carro, CarroDTO carroDTO) throws CarroException {
		 
		 if(carroDTO.getModelo() == null) {
			 throw new CarroException("Modelo do carro naõ informado. "); 
		 }
		 
		 if(carroDTO.getMarca() == null) {
			 throw new CarroException("Marca do carro não informado. ");
		 }
		 
		 if(carroDTO.getAno() == null) {
			 throw new CarroException("Ano do carro não informado. ");
		 }
		 
		// o id é cadastrado automaticamente
		 carro.setModelo(carroDTO.getModelo());
		 carro.setMarca(carroDTO.getMarca());
		 carro.setAno(carroDTO.getAno());
		 carro.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
		 return carro;
	 }
	 
	 public String salvar(CarroDTO carroDTO) throws CarroException {
		 Carro carro = new Carro();
		 transformarDTOEmModel(carro, carroDTO);
		 carroRepository.save(carro);
		 return "O carro criado foi com a id: " + carro.getIdCarro();
	 }
	 
	 public CarroDTO buscarPorId(Integer idCarro) throws CarroException{
		 Optional<Carro> carro = carroRepository.findById(idCarro);
		 Carro carroNoBanco = new Carro();
		 CarroDTO carroDTO = new CarroDTO();
		 if(carro.isPresent()) {
			 carroNoBanco = carro.get();
			 transformarModelEmDTO(carroNoBanco, carroDTO);
			 return carroDTO;
		 }
		 throw new CarroException("Carro com a id informada não foi encontardo"); 
	 }
	 
	 public void deletar(Integer idCarro) {
		 carroRepository.deleteById(idCarro);
	 }
	 
	 public String atualizar(Integer idCarro, CarroDTO carroDTO) throws CarroException{
		 Optional<Carro> carro = carroRepository.findById(idCarro);
		 Carro carroBanco = new Carro();
		 if(carro.isPresent()) {
			 carroBanco = carro.get();
			 if(carroDTO.getModelo() != null) {
				 carroBanco.setModelo(carroDTO.getModelo());
			 }
			 
			 if(carroDTO.getMarca() != null) {
				 carroBanco.setMarca(carroDTO.getMarca());
			 }
			 
			 if(carroDTO.getAno() != null) {
				 carroBanco.setAno(carroDTO.getAno());
			 }
			 
			 if(carroDTO.getIdCliente() == null) {
				 carroBanco.setCliente(clienteRepository.findById(carroDTO.getIdCliente()).get());
			 }
				 
			 carroRepository.save(carroBanco);
			 return "O Carro com a id " + carroBanco.getIdCarro()+ " foi atualizado";
		 }
		 throw new CarroException("O carro não foi atualizado");
	 }
	 
	 public List<CarroDTO> buscarTodos(){
		 List<Carro> listaCarroModel = carroRepository.findAll();
		 List<CarroDTO> listaCarroDTO = new ArrayList<>();
		 for(Carro carro :listaCarroModel) {
			 CarroDTO carroDTO = new CarroDTO();
			 transformarModelEmDTO(carro, carroDTO);
			 listaCarroDTO.add(carroDTO);
		 }
		 return listaCarroDTO;
	 }
	 
	 public void salvarListaCarro(List<CarroDTO> listaCarroDTO) throws CarroException {
		 List<Carro> listaCarro = new ArrayList<>();
		 
		 for(CarroDTO carroDTO : listaCarroDTO) {
			 Carro carro = new Carro();
			 transformarDTOEmModel(carro, carroDTO);
			 listaCarro.add(carro);
		 }
		 carroRepository.saveAll(listaCarro);
	 }
}
