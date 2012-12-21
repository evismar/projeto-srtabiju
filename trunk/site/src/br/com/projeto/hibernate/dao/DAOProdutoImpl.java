package br.com.projeto.hibernate.dao;

import javax.persistence.EntityManager;


import br.com.projeto.hibernate.entidades.Produto;

public class DAOProdutoImpl extends DAOGenericoImpl<Produto> implements DAOProduto {

	public DAOProdutoImpl(EntityManager em) {
		super(em, Produto.class);
	}
	

	
	
}
