package org.serratecbackend.projeto07.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.serratecbackend.projeto07.DTO.ClienteDTO;
import org.serratecbackend.projeto07.exception.ClienteException;
import org.serratecbackend.projeto07.model.Cliente;
import org.serratecbackend.projeto07.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteDTO transformarModelEmDTO(Cliente cliente, ClienteDTO clienteDTO) {

		clienteDTO.setIdCliente(cliente.getIdCliente());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());

		return clienteDTO;
	}

	public Cliente transformarDTOEmModel(Cliente cliente, ClienteDTO clienteDTO) throws ClienteException{
		
		if(clienteDTO.getCpf() == null) {
			throw new ClienteException("O CPF do cliente não foi informado.");
		}
		
		if(clienteDTO.getNome() == null) {
			throw new ClienteException("O nome do cliente não foi informado. ");
		}
		
		if(clienteDTO.getEmail() == null) {
			throw new ClienteException("O email do cliente não foi informado. ");
		}
		
		if(clienteDTO.getNumeroTelefone() == null) {
			throw new ClienteException("O número de telefone não existe ou não foi informado.");
		}
		
		// o id é cadastrado automaticamente
		cliente.setCpf(clienteDTO.getCpf());
		cliente.setNome(clienteDTO.getNome());
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());

		return cliente;
	}

	public String salvar(ClienteDTO clienteDTO) throws ClienteException {
		Cliente cliente = new Cliente();
		transformarDTOEmModel(cliente, clienteDTO);
		clienteRepository.save(cliente);

		return "O Cliente foi gerado com uma id " + cliente.getIdCliente();
	}

	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoBanco = new Cliente();
		ClienteDTO clienteDTO = new ClienteDTO();
		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();
			transformarModelEmDTO(clienteNoBanco, clienteDTO);
			return clienteDTO;
		}
		throw new ClienteException("Cliente com a id informada não encontrado");
	}

	public void deletar(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}

	public String atualizar(Integer idCliente, ClienteDTO clienteDTO) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteBanco = new Cliente();
		if (cliente.isPresent()) {
			clienteBanco = cliente.get();
			if (clienteDTO.getCpf() != null) {
				clienteBanco.setCpf(clienteDTO.getCpf());
			}

			if (clienteDTO.getNome() != null) {
				clienteBanco.setNome(clienteDTO.getNome());
			}

			if (clienteDTO.getEmail() != null) {
				clienteBanco.setEmail(clienteDTO.getEmail());
			}

			if (clienteDTO.getNumeroTelefone() != null) {
				clienteBanco.setNumeroTelefone(clienteDTO.getNumeroTelefone());
			}
			clienteRepository.save(clienteBanco);
			return "O cliente com a id " + clienteBanco.getIdCliente()+ " foi atualizado";
		}
		throw new ClienteException("O cliente não foi atualizado.");
	}
	
	public List<ClienteDTO> buscarTodos(){
		List<Cliente> listaClienteModel = clienteRepository.findAll();
		List<ClienteDTO> listaClienteDTO = new ArrayList<>();
		for(Cliente cliente : listaClienteModel) {
			ClienteDTO clienteDTO = new ClienteDTO();
			transformarModelEmDTO(cliente, clienteDTO);
			listaClienteDTO.add(clienteDTO);
		}
		return listaClienteDTO;
	}
	
	public void salvarListaCliente(List<ClienteDTO> listaClienteDTO) throws ClienteException {
		List<Cliente> listaCliente = new ArrayList<>();
		
		for(ClienteDTO clienteDTO : listaClienteDTO) {
			Cliente cliente = new Cliente();
			transformarDTOEmModel(cliente, clienteDTO);
			listaCliente.add(cliente);
		}
		clienteRepository.saveAll(listaCliente);
	}
}
