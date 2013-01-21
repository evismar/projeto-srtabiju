package br.com.projeto.hibernate.dao;

import br.com.projeto.hibernate.entidades.Cliente;

public interface DAOCliente extends DAOGenerico<Cliente>{
	
	Cliente buscarClientePorLoginESenha(String login, String senha);
	
}
