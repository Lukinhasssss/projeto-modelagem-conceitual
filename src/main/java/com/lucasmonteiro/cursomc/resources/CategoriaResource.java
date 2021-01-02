package com.lucasmonteiro.cursomc.resources; // resources --> É onde são gravadas as classes que são: controladores REST

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lucasmonteiro.cursomc.domain.Categoria;
import com.lucasmonteiro.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias") // No value é colocado o nome do endpoint REST
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria categoria = service.buscar(id);
		
		return ResponseEntity.ok().body(categoria);
	}

}
