// Camada de acesso a dados (Repository) --> A responsabilidade dela é conversar com o banco de dados. Ela que teráoperações de salvar alterar, excluir, consultar os dados, consultas sql...
package com.lucasmonteiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lucasmonteiro.cursomc.domain.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
