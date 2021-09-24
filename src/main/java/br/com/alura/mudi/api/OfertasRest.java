package br.com.alura.mudi.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mudi.dto.RequsicaoNovaOferta;
import br.com.alura.mudi.model.Oferta;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {
	
	@Autowired
	private PedidoRepository repository; 
	
	@PostMapping
	public Oferta criaOferta(@RequestBody RequsicaoNovaOferta requisicao) {
		
		Optional<Pedido> pedidoBuscado = repository.findById(requisicao.getPedidoId()); 
		
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get(); 
		
		Oferta nova = requisicao.toOferta();
		nova.setPedido(pedido);
		pedido.getOfertas().add(nova); 
		repository.save(pedido); 
		
		return nova; 
	}
}
