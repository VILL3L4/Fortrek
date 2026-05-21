package com.leandro.villela.persistence;

import com.leandro.villela.entity.Cliente;
import com.leandro.villela.entity.Endereco;

public class GravasDados {

	public static void main(String[] args) {

		Cliente cliente = new Cliente();
		cliente.setNome("LEANDRO VILLELA");
		cliente.setEmail("GOVILLELA@GMAIL.COM");
		

		Endereco endereco = new Endereco();
		endereco.setLogradouro("AVENIDA PASTOR MARTIN LUTHER KINK JUNIOR");
		endereco.setBairro("PAVUNA");
		endereco.setCidade("RIO DE JANEIRO");
		endereco.setUf("RJ");

		endereco.setCliente(cliente);

		System.out.println("Cliente salvo com sucesso! ID: " + cliente.getIdCliente());

	}

}
