package com.leandro.villela.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.villela.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    // Método para buscar cliente por email e senha
    Cliente findByEmailAndSenha(String email, String senha);
    
    // Opcional: buscar apenas por email
    Cliente findByEmail(String email);
}