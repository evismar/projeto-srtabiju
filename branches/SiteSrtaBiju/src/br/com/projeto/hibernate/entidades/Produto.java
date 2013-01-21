package br.com.projeto.hibernate.entidades;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Produto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8274175170464719387L;




	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_Produto")
	private Integer id = 0;
	
	@Column(name = "descricao")
	private String descricao = "";
	
	@Column(name = "nome")
	private String nome = "";
	
	
	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao
				+ ", categoria=" + categoria + ", estoque=" + estoque
				+ ", itensDePedido=" + itensDePedido + ", preco=" + preco + "]";
	}
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_categoria", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Categoria categoria;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_estoque", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	@Cascade(CascadeType.SAVE_UPDATE)
	private Estoque estoque;
	
	@OneToMany(mappedBy="pedido", fetch = FetchType.LAZY)
	@Cascade(CascadeType.ALL)
	private Collection<ItemDePedido> itensDePedido;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public Estoque getEstoque() {
		return estoque;
	}
	public void setEstoque(Estoque estoque) {
		this.estoque = estoque;
	}
	public Collection<ItemDePedido> getItensDePedido() {
		return itensDePedido;
	}
	public void setItensDePedido(Collection<ItemDePedido> itensDePedido) {
		this.itensDePedido = itensDePedido;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "preco")
	private String preco = "";	
	

}
