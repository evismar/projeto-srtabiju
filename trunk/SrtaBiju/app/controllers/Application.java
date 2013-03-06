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
	    
		public static void login(String usuario, String senha){
			
			     Pessoa pessoa = Pessoa.find("byUsuarioAndSenha", usuario, senha).first();
			    if(pessoa != null) {
			        session.put("CLiente", pessoa.usuario);
			        flash.success("Bem-vindo, " + pessoa.usuario);
			         Application.index_cliente();         
			    }
	        // Oops
		      flash.put("username", usuario);
		      flash.error("Ops...Login inválido.");
		      index_cliente();
	    }
		
		

	}