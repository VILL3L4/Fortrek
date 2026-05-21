package com.leandro.villela.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.leandro.villela.entity.Cliente;
import com.leandro.villela.service.ClienteService;

@Controller
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/cliente/registrar")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/registrar";
    }

    @PostMapping("/cliente/salvar")
    public String salvarCliente(Cliente cliente, Model model) {
        try {
            clienteService.salvar(cliente);
            model.addAttribute("mensagem", "Cliente cadastrado com sucesso!");
            return "cliente/registrar";
        } catch (Exception e) {
            model.addAttribute("mensagemErro", "Erro ao salvar cliente: " + e.getMessage());
            return "cliente/registrar";
        }
    }
}