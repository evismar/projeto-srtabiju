package br.com.projeto.hibernate.teste;




import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
import br.com.projeto.hibernate.dao.*;
import br.com.projeto.hibernate.teste.*;
import br.com.projeto.hibernate.entidades.*;
 

public class Teste {
	
	//private static final Logger logger = LoggerFactory.getLogger(Teste.class);
	
 
    public static void main(String[] args) {
    	//logger.info("iniciar Teste");
    	//System.out.println("Olá mundo");
    	//logger.info("finalizar Teste");
    	//EntityManagerFactory factory = Persistence.createEntityManagerFactory("ProjetoCurso");
    	//factory.close();
    	
    	DAOCliente dao = (DAOCliente) DAOFactory.getInstancia().getDAOClientes();
		
		Cliente c = new Cliente("Zé", "03333317493", "86796294","teomar", "085471", "teomar.melo@gmail.com");
		
		try { 
			dao.salvar(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 
}
 
