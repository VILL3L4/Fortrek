package com.leandro.villela.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.leandro.villela.entity.Cliente;
import com.leandro.villela.service.ClienteService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final ClienteService clienteService;

    public LoginController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/cliente/login";
    }

    @GetMapping("/cliente/login")
    public String mostrarLogin(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/login";
    }

    @PostMapping("/cliente/login") 
    public String fazerLogin(@RequestParam("email") String email,
                             @RequestParam("senha") String senha,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteService.buscarPorEmailESenha(email, senha);

        if (cliente != null) {
            session.setAttribute("clienteLogado", cliente);
            return "redirect:/cliente/home"; 
        } else {
            redirectAttributes.addFlashAttribute("mensagemErro", "Email ou senha inválidos!");
            return "redirect:/cliente/login"; 
        }
    }

    @GetMapping("/cliente/home") 
    public String home(HttpSession session, Model model) {
        Cliente clienteLogado = (Cliente) session.getAttribute("clienteLogado");
        if (clienteLogado == null) {
            return "redirect:/cliente/login"; 
        }
        model.addAttribute("cliente", clienteLogado);
        return "cliente/home";
    }

    @GetMapping("/cliente/logout") // corrigido com barra inicial
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/cliente/login"; // corrigido
    }
}