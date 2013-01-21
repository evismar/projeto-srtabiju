package br.com.projeto.hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.projeto.hibernate.entidades.Cliente;

public class DAOClienteImpl extends DAOGenericoImpl<Cliente> implements
		DAOCliente {
	
	public DAOClienteImpl(EntityManager em){
		super(em, Cliente.class);
	}
	
	@Override
	public Cliente buscarClientePorLoginESenha(String login, String senha) {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(" FROM " + Cliente.class.getName() + " c "
				  + " WHERE c.login = :login"
				  + " AND c.senha = :senha");
		
		Query q = getManager().createQuery(sb.toString());
		
		q.setParameter("login", login);
		q.setParameter("senha", senha);
		
		return (Cliente) q.getSingleResult();
	}

}