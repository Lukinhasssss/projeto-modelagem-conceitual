package com.lucasmonteiro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucasmonteiro.cursomc.domain.Categoria;
import com.lucasmonteiro.cursomc.domain.Produto;
import com.lucasmonteiro.cursomc.repositories.CategoriaRepository;
import com.lucasmonteiro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class ImplementacaoMcComspringBootEJpaApplication implements CommandLineRunner { // CommandLineRunner permite implementar um método auxiliar para executar alguma ação quando a aplicação iniciar

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ImplementacaoMcComspringBootEJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria categoria1 = new Categoria(null, "Informática"); // O id é null pois o banco de dados vai informar o id automaticamente
		Categoria categoria2 = new Categoria(null, "Games");
		
		Produto produto1 = new Produto(null, "PC Gamer", 7200.00);
		Produto produto2 = new Produto(null, "Xbox Series X", 4599.00);
		Produto produto3 = new Produto(null, "PlayStation 5", 4999.00);
		
		categoria1.getProdutos().addAll(Arrays.asList(produto1));
		categoria2.getProdutos().addAll(Arrays.asList(produto1, produto2, produto3));
		
		produto1.getCategorias().addAll(Arrays.asList(categoria1, categoria2));
		produto2.getCategorias().addAll(Arrays.asList(categoria2));
		produto3.getCategorias().addAll(Arrays.asList(categoria2));
		
		categoriaRepository.saveAll(Arrays.asList(categoria1, categoria2));
		produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3));
		
	}

}
