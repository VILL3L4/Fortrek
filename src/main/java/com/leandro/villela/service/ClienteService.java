package com.leandro.villela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leandro.villela.entity.Cliente;
import com.leandro.villela.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    public void salvar(Cliente cliente) {
        clienteRepository.save(cliente);
    }
    
    // Método para buscar cliente por email e senha
    public Cliente buscarPorEmailESenha(String email, String senha) {
        return clienteRepository.findByEmailAndSenha(email, senha);
    }
}