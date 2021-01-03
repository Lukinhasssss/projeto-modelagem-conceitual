// Camada de serviço --> É responsável por oferecer operações e consultas para os controladores REST, ou seja, para os recursos (resources). Vai utilizar a camada de acesso a dados para realizar regras de negócio.
package com.lucasmonteiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmonteiro.cursomc.domain.Cliente;
import com.lucasmonteiro.cursomc.repositories.ClienteRepository;
import com.lucasmonteiro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	// Criando operação para buscar Categoria por código
	public Cliente buscar(Integer id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}
