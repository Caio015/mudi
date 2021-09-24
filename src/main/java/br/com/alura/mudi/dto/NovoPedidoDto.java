package br.com.alura.mudi.dto;

import javax.validation.constraints.NotBlank;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;

public class NovoPedidoDto {

	@NotBlank(message = "O campo Nome do Produto é obrigatorio.")
	private String nomeProduto;
	@NotBlank(message = "O campo URL do Produto é obrigatorio.")
	private String urlProduto;
	@NotBlank(message = "O campo URL da Imagem é obrigatorio.")
	private String urlImagem;
	@NotBlank
	private String descricao; 
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlPedido(urlProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setDescricao(descricao);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido; 
	}
	
}
