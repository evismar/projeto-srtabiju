package br.com.projeto.hibernate.dao;


import java.io.Serializable;
import java.util.List;

public interface DAOGenerico<T> {

	void salvar(T entidade);
	void alterar(T entidade);
	void remover(T entidade);
	T buscar(Serializable id);
	List<T> listarTodos();
}
