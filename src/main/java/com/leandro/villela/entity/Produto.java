package com.leandro.villela.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProduto;
	private String nomeProduto;
	private String categoria;
	private Double preco;
	private Integer estoque;

	@OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ItensVenda> itensVenda;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer idProduto, String nomeProduto, String categoria, Double preco, Integer estoque) {
		super();
		this.idProduto = idProduto;
		this.nomeProduto = nomeProduto;
		this.categoria = categoria;
		this.preco = preco;
		this.estoque = estoque;
	}

	@Override
	public String toString() {
		return "Produto [idProduto=" + idProduto + ", nomeProduto=" + nomeProduto + ", categoria=" + categoria
				+ ", preco=" + preco + ", estoque=" + estoque + "]";
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

}
