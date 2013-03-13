package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import java.util.*;

import models.*;

public class Application extends Controller {
	
    @Before
    static void addUsuario() {
        Pessoa usuario = connected();
        if(usuario != null) {
            renderArgs.put("usuario", usuario);
            System.out.println("Usuario não nulo 1 " + usuario.nome);
        }
    }
    
    static Pessoa connected() {
        if(renderArgs.get("usuario") != null) {
            return renderArgs.get("usuario", Pessoa.class);
        }
        String username = session.get("usuario");
        if(username != null) {
            return Pessoa.find("byUsuario", username).first();
        } 
        return null;
    }

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
				session.put("usuario", adm.usuario);
			    flash.success("Bem-vindo, " + adm.usuario);
		        Application.index_adm();
			}
			else{
				Cliente pessoa = Cliente.find("byUsuarioAndSenha", usuario, senha).first();
				if(pessoa != null) {
				    	
			        pessoa.quantidadeDeAcessos = pessoa.quantidadeDeAcessos + 1;
			        pessoa.save();
					session.put("usuario", pessoa.usuario);
				    flash.success("Bem-vindo, " + pessoa.usuario);
			        Clientes.clienteLogado();         
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
		
	    public static void logout() {
	        session.clear();
	        index_cliente();
	    }

	}