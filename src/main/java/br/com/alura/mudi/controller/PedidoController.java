package br.com.alura.mudi.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mudi.dto.NovoPedidoDto;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.User;
import br.com.alura.mudi.repository.PedidoRepository;
import br.com.alura.mudi.repository.UserRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository repository;
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("formulario")
	public String formulario(NovoPedidoDto novoPedido) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid NovoPedidoDto novoPedido, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Pedido pedido = novoPedido.toPedido();
		User user = userRepository.findByUsername(username);
		pedido.setUser(user);
		repository.save(pedido);
		
		return "redirect:/home";
	}
}