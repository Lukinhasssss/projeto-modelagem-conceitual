package com.lucasmonteiro.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucasmonteiro.cursomc.domain.Categoria;
import com.lucasmonteiro.cursomc.domain.Cidade;
import com.lucasmonteiro.cursomc.domain.Cliente;
import com.lucasmonteiro.cursomc.domain.Endereco;
import com.lucasmonteiro.cursomc.domain.Estado;
import com.lucasmonteiro.cursomc.domain.Produto;
import com.lucasmonteiro.cursomc.domain.enums.TipoCliente;
import com.lucasmonteiro.cursomc.repositories.CategoriaRepository;
import com.lucasmonteiro.cursomc.repositories.CidadeRepository;
import com.lucasmonteiro.cursomc.repositories.ClienteRepository;
import com.lucasmonteiro.cursomc.repositories.EnderecoRepository;
import com.lucasmonteiro.cursomc.repositories.EstadoRepository;
import com.lucasmonteiro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class ImplementacaoMcComspringBootEJpaApplication implements CommandLineRunner { // CommandLineRunner permite implementar um método auxiliar para executar alguma ação quando a aplicação iniciar

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
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

		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Ibirité", estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo", estado2);
		Cidade cidade3 = new Cidade(null, "São Bernardo do Campo", estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2, cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1, estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1, cidade2, cidade3));
		
		Cliente cliente1 = new Cliente(null, "Eren Yeager", "eren@mikasa.com", "45295100324", TipoCliente.PESSOAFISICA);
		
		cliente1.getTelefones().addAll(Arrays.asList("40028922", "36969636"));
		
		Endereco endereco1 = new Endereco(null, "Avenida Mauro Nunes Moreira", "222", "Casa 1", "Santa Maria", "32400000", cliente1, cidade1);
		Endereco endereco2 = new Endereco(null, "Rua Porto Feliz", "71", "Casa", "Jardim Das Oliveiras", "09847305", cliente1, cidade3);
		
		cliente1.getEnderecos().addAll(Arrays.asList(endereco1, endereco2));
		
		clienteRepository.saveAll(Arrays.asList(cliente1));
		enderecoRepository.saveAll(Arrays.asList(endereco1, endereco2));
		
	}

}
