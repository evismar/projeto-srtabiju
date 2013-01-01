package br.com.projeto.hibernate.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import br.com.projeto.hibernate.entidades.*;

public class DAOFactory {

	private static DAOFactory instancia = new DAOFactory();
	
	private EntityManager em = null;
	
	private Map<Class<?>, DAOGenerico<?>> mapa = null;
	
	private DAOFactory(){
		super();
		em = Persistence.createEntityManagerFactory("ProjetoCurso").createEntityManager();
		mapa = new HashMap<Class<?>, DAOGenerico<?>>();
	}
	
	public static DAOFactory getInstancia(){
		return instancia;
	}
	
	public DAOGenerico<?> getDAOClientes(){
		Class<?> chave = Cliente.class;
		if (!mapa.containsKey(chave)){
			mapa.put(chave, new DAOClienteImpl(em));
		}
		return mapa.get(chave);
	}
	
	public DAOGenerico<?> getDAOEnderecos(){
		Class<?> chave = Endereco.class;
		if (!mapa.containsKey(chave)){
			mapa.put(chave, new DAOEnderecoImpl(em));
		}
		return mapa.get(chave);
	}
	
	public DAOGenerico<?> getDAOFormasDePagamentos(){
		Class<?> chave = FormaDePagamento.class;
		if (!mapa.containsKey(chave)){
			mapa.put(chave, new DAOFormaDePagamentoImpl(em));
		}
		return mapa.get(chave);
	}
	
	public DAOGenerico<?> getDAOCategorias(){
		Class<?> chave = Categoria.class;
		if (!mapa.containsKey(chave)){
			mapa.put(chave, new DAOCategoriaImpl(em));
		}
		return mapa.get(chave);
	}
	public DAOGenerico<?> getDAOEstoques(){
		Class<?> chave = Estoque.class;
		if (!mapa.containsKey(chave)){
			mapa.put(chave, new DAOEstoqueImpl(em));
		}
		return mapa.get(chave);
	}
	public DAOGenerico<?> getDAOProdutos(){
		Class<?> chave = Produto.class;
		if (!mapa.containsKey(chave)){
			mapa.put(chave, new DAOProdutoImpl(em));
		}
		return mapa.get(chave);
	}
}
