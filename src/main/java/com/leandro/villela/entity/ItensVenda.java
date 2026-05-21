package com.leandro.villela.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "itens_venda")
public class ItensVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idItensVenda;
	private Integer quantidade;
	private Double preco_unitario;

	@ManyToOne
	@JoinColumn(name = "id_venda")
	private Venda venda;

	@ManyToOne
	@JoinColumn(name = "id_produto")
	private Produto produto;

	public ItensVenda() {
		// TODO Auto-generated constructor stub
	}

	public ItensVenda(Integer idItensVenda, Integer quantidade, Double preco_unitario) {
		super();
		this.idItensVenda = idItensVenda;
		this.quantidade = quantidade;
		this.preco_unitario = preco_unitario;
	}

	@Override
	public String toString() {
		return "ItensVenda [idItensVenda=" + idItensVenda + ", quantidade=" + quantidade + ", preco_unitario="
				+ preco_unitario + "]";
	}

	public Integer getIdItensVenda() {
		return idItensVenda;
	}

	public void setIdItensVenda(Integer idItensVenda) {
		this.idItensVenda = idItensVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco_unitario() {
		return preco_unitario;
	}

	public void setPreco_unitario(Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

}
