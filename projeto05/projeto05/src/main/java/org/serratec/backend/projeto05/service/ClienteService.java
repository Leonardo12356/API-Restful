package org.serratec.backend.projeto05.service;

import java.util.List;
import java.util.Optional;

import org.serratec.backend.projeto05.DTO.ClienteDTO;
import org.serratec.backend.projeto05.exception.ClienteException;
import org.serratec.backend.projeto05.model.Cliente;
import org.serratec.backend.projeto05.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public void salvar(ClienteDTO clienteDTO) {
		// clienteDTO possui os dados
		Cliente cliente = new Cliente();

		Cliente clienteSalvar = transformarClienteDTOEmClienteModel(clienteDTO, cliente);

		clienteRepository.save(clienteSalvar);
	}

	public Cliente transformarClienteDTOEmClienteModel(ClienteDTO clienteDTO, Cliente cliente) {

		// não setamos o id pois o mesmo é automatico na classe
//		clienteDTO.setIdCliente(cliente.getId());

		cliente.setCpf(clienteDTO.getCpf().replace(".", "").replace("-", ""));
		cliente.setEmail(clienteDTO.getEmail());
		cliente.setNome(clienteDTO.getNome());
		cliente.setNumeroTelefone(clienteDTO.getNumeroTelefone());
		cliente.setDataNascimento(clienteDTO.getDataNascimento());

		return cliente;
	}

	public ClienteDTO transformarClienteModelEmClienteDTO(ClienteDTO clienteDTO, Cliente cliente) {
		clienteDTO.setIdCliente(cliente.getId());
		clienteDTO.setCpf(cliente.getCpf());
		clienteDTO.setEmail(cliente.getEmail());
		clienteDTO.setNome(cliente.getNome());
		clienteDTO.setNumeroTelefone(cliente.getNumeroTelefone());
		clienteDTO.setDataNascimento(cliente.getDataNascimento());

		return clienteDTO;

	}

	public ClienteDTO buscarPorId(Integer idCliente) throws ClienteException {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);

		// cliente vazio
		Cliente clienteNoBanco = new Cliente();
		// clienteDTO vazio
		ClienteDTO clienteDTO = new ClienteDTO();
		if (cliente.isPresent()) {
			// cliente vazio recebe cliente do banco
			clienteNoBanco = cliente.get();
			clienteDTO = transformarClienteModelEmClienteDTO(clienteDTO, clienteNoBanco);
			
			return clienteDTO;
		}
		throw new ClienteException("Cliente não encontrado"); 
	}

	public void atualizar(Integer idCliente, ClienteDTO clienteDTO) {
		Optional<Cliente> cliente = clienteRepository.findById(idCliente);
		Cliente clienteNoBanco = new Cliente();

		if (cliente.isPresent()) {
			clienteNoBanco = cliente.get();
			if (clienteDTO.getCpf() != null) {
				clienteNoBanco.setCpf(clienteDTO.getCpf());
			}
			if (clienteDTO.getDataNascimento() != null) {
				clienteNoBanco.setDataNascimento(clienteDTO.getDataNascimento());
			}
			if (clienteDTO.getEmail() != null) {
				clienteNoBanco.setEmail(clienteDTO.getEmail());
			}
			if (clienteDTO.getNome() != null) {
				clienteNoBanco.setNome(clienteDTO.getNome());
			}

			if (clienteDTO.getNumeroTelefone() != null) {
				clienteNoBanco.setNumeroTelefone(clienteDTO.getNumeroTelefone());
			}
			clienteRepository.save(clienteNoBanco);
		}
		
	}

	public void delete(Integer idCliente) {
		clienteRepository.deleteById(idCliente);
	}

	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}

	public void salvarTodos(List<Cliente> listaCliente) {
		clienteRepository.saveAll(listaCliente);
	}
}
