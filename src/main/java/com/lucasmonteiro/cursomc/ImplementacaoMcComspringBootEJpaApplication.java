package com.lucasmonteiro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucasmonteiro.cursomc.domain.Categoria;
import com.lucasmonteiro.cursomc.repositories.CategoriaRepository;

@SpringBootApplication
public class ImplementacaoMcComspringBootEJpaApplication implements CommandLineRunner { // CommandLineRunner permite implementar um método auxiliar para executar alguma ação quando a aplicação iniciar

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ImplementacaoMcComspringBootEJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Informática"); // O id é null pois o banco de dados vai informar o id automaticamente
		Categoria categoria2 = new Categoria(null, "Games");
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		
	}

}
