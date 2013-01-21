package br.com.projeto.hibernate.dao;

import javax.persistence.EntityManager;


import br.com.projeto.hibernate.entidades.Pedido;

public class DAOPedidoImpl extends DAOGenericoImpl<Pedido> implements DAOPedido {
	
	public DAOPedidoImpl(EntityManager em){
		super(em, Pedido.class);
	}

}
