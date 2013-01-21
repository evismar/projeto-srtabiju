package br.com.projeto.hibernate.dao;

import javax.persistence.EntityManager;


import br.com.projeto.hibernate.entidades.FormaDePagamento;

public class DAOFormaDePagamentoImpl extends DAOGenericoImpl<FormaDePagamento> implements DAOFormaDePagamento{

	public DAOFormaDePagamentoImpl(EntityManager em){
		super(em, FormaDePagamento.class);
	}
}
