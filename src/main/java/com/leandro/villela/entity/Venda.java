package com.leandro.villela.entity;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVenda;
	private Date dataVenda;
	private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;

	@OneToMany(mappedBy = "venda", cascade = CascadeType.ALL)
	private List<ItensVenda> itensVenda;

	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(Integer idVenda, Date dataVenda, Double valorTotal) {
		super();
		this.idVenda = idVenda;
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
	}

	@Override
	public String toString() {
		return "Venda [idVenda=" + idVenda + ", dataVenda=" + dataVenda + ", valorTotal=" + valorTotal + "]";
	}

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

}
