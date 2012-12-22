package br.com.projeto.hibernate.dao;

import javax.persistence.EntityManager;

import br.com.projeto.hibernate.entidades.ItemDePedido;

public class DAOItemDePedidoImpl extends DAOGenericoImpl<ItemDePedido> implements DAOItemDePedido {
	
	public DAOItemDePedidoImpl(EntityManager em){
		super(em, ItemDePedido.class);

}
}
