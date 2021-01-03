package com.lucasmonteiro.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.lucasmonteiro.cursomc.domain.enums.EstadoDoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {
	
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataDeVencimento;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataDePagamento;
	
	public PagamentoComBoleto() {}
	
	public PagamentoComBoleto(Integer id, EstadoDoPagamento estado, Pedido pedido, Date dataDeVencimento, Date dataDePagamento) {
		super(id, estado, pedido);
		this.dataDeVencimento = dataDeVencimento;
		this.dataDePagamento = dataDePagamento;
	}

	public Date getDataDeVencimento() {
		return dataDeVencimento;
	}

	public void setDataDeVencimento(Date dataDeVencimento) {
		this.dataDeVencimento = dataDeVencimento;
	}

	public Date getDataDePagamento() {
		return dataDePagamento;
	}

	public void setDataDePagamento(Date dataDePagamento) {
		this.dataDePagamento = dataDePagamento;
	}

}
