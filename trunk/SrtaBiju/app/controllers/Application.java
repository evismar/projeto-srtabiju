package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import java.util.*;

import models.*;

public class Application extends Controller {

	    public static void index_cliente() {
	        render();
	    }
	    
	    public static void index_adm() {
	        render();
	    }
	    public static void contato() {
	        render();
	    }
	    public static void empresa() {
	        render();
	    }
	    
		public static void login(String usuario, String senha){
			
			Administrador adm = Administrador.find("byUsuarioAndSenha", usuario, senha).first();
			if(adm != null) {
				session.put("Administrado", adm.usuario);
			    flash.success("Bem-vindo, " + adm.usuario);
		        Application.index_adm();
			}
			else{
				Cliente pessoa = Cliente.find("byUsuarioAndSenha", usuario, senha).first();
				if(pessoa != null) {
				    	
					session.put("CLiente", pessoa.usuario);
				    flash.success("Bem-vindo, " + pessoa.usuario);
			        Application.index_cliente();         
				    }
		        // Oops
				else{
					validation.addError("login", "Usuário ou senha inválidos.");
			        	params.flash();
			        	validation.keep();
			        	index_cliente();
				}
		           }
				
		}
		

	}