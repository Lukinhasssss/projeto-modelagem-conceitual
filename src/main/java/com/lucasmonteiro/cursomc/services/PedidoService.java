// Camada de serviço --> É responsável por oferecer operações e consultas para os controladores REST, ou seja, para os recursos (resources). Vai utilizar a camada de acesso a dados para realizar regras de negócio.
package com.lucasmonteiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmonteiro.cursomc.domain.Pedido;
import com.lucasmonteiro.cursomc.repositories.PedidoRepository;
import com.lucasmonteiro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repository;
	
	// Criando operação para buscar Categoria por código
	public Pedido buscar(Integer id) {
		Optional<Pedido> pedido = repository.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}
