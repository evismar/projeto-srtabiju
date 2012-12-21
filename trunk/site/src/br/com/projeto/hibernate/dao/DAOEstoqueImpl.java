package br.com.projeto.hibernate.dao;

import javax.persistence.EntityManager;

import br.com.projeto.hibernate.entidades.Estoque;

public class DAOEstoqueImpl extends DAOGenericoImpl<Estoque> implements DAOEstoque {

	public DAOEstoqueImpl(EntityManager em) {
		super(em, Estoque.class);
	}
}
