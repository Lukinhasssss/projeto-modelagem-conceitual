// Camada de serviço --> É responsável por oferecer operações e consultas para os controladores REST, ou seja, para os recursos (resources). Vai utilizar a camada de acesso a dados para realizar regras de negócio.
package com.lucasmonteiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucasmonteiro.cursomc.domain.Categoria;
import com.lucasmonteiro.cursomc.repositories.CategoriaRepository;
import com.lucasmonteiro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
	
	// Criando operação para buscar Categoria por código
	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = repository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
