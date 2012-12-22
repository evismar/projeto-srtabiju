package br.com.projeto.hibernate.dao;
import javax.persistence.EntityManager;

import br.com.projeto.hibernate.entidades.Endereco;

public class DAOEnderecoImpl extends DAOGenericoImpl<Endereco> implements DAOEndereco{
	
	public DAOEnderecoImpl(EntityManager em){
		super(em, Endereco.class);
	}

}
