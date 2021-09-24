package br.com.alura.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataEntrega; 
	private String urlPedido;
	private String urlImagem;
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
	private List<Oferta> ofertas;
	
	public List<Oferta> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public BigDecimal getValorNegociado() {
		return valorNegociado;
	}
	public void setValorNegociado(BigDecimal valorNegociado) {
		this.valorNegociado = valorNegociado;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getUrlPedido() {
		return urlPedido;
	}
	public Long getId() {
		return id;
	}
	public void setUrlPedido(String urlPedido) {
		this.urlPedido = urlPedido;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public StatusPedido getStatus() {
		return status;
	}
	public void setStatus(StatusPedido status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	

}
