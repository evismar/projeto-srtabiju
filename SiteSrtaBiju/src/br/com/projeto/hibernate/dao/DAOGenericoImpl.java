package br.com.projeto.hibernate.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class DAOGenericoImpl<T> implements DAOGenerico<T> {

	private EntityManager manager = null;
	private Class<T> type = null;
	
	
	public DAOGenericoImpl(EntityManager em, Class<T> tipo){
		manager = em;
		type = tipo;
	}
	
	public EntityManager getManager() {
		return manager;
	}

	public Class<T> getType() {
		return type;
	}

	@Override
	public void salvar(T entidade) {
		manager.getTransaction().begin();
		manager.persist(entidade);
		manager.getTransaction().commit();		
	}

	@Override
	public void alterar(T entidade) {
		manager.getTransaction().begin();
		manager.merge(entidade);
		manager.getTransaction().commit();		
		
	}

	@Override
	public void remover(T entidade) {
		manager.getTransaction().begin();
		manager.remove(entidade);
		manager.getTransaction().commit();		
		
	}

	@Override
	public T buscar(Serializable id) {
		try{
			manager.getTransaction().commit();
			return (T)manager.find(type, id);
			
		}finally{
			manager.getTransaction().commit();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listarTodos() {

		StringBuilder sb = new StringBuilder();
		
		sb.append(" FROM " + type.getName());
		
		Query q = manager.createQuery(sb.toString());
		
		return q.getResultList();
	}

}