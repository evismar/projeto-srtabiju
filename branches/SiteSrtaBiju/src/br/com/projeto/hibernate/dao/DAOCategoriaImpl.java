package br.com.projeto.hibernate.dao;

import javax.persistence.EntityManager;

import br.com.projeto.hibernate.entidades.Categoria;

public class DAOCategoriaImpl extends DAOGenericoImpl<Categoria> implements DAOCategoria {

	public DAOCategoriaImpl(EntityManager em){
		super(em, Categoria.class);
	}
}
