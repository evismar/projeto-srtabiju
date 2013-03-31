package controllers;

import play.*;
import play.libs.Mail;
import play.mvc.*;
import play.data.validation.*;
import java.util.*;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.SimpleEmail;

import models.*;

public class Application extends Controller {
	
	static void checaAdm() {
		if (connected() == null) {
			flash.error("Por favor, realize o Login primeiro.");
			Application.index_cliente();
		}
		Pessoa pessoa = connected();
		Administrador adm = Administrador.find("byUsuarioAndSenha", pessoa.usuario, pessoa.senha).first();
		if(adm == null) {
			flash.error("Por favor, realize o Login de Administrador.");
			Application.index_cliente();
		}
	}
	
    
    public static void relatorios() {
    	checaAdm();
        render();
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
    	Pessoa pessoa = connected();
    	if (pessoa != null){
    		Clientes.clienteLogado();
    	}
    	
    	else{
    	Integer size = 6;
    	List<Produto> produtos = null;
    	List valores = new ArrayList<>();
    	List contador = new ArrayList<>();
    	produtos = Produto.find("order by id desc, id").fetch(size);
		Integer i = 0;
    	for(Produto produto : produtos ){

    		String valor = Float.toString(produto.valor);

    		valor = valor.replace(".", ",");
    		String[] split = valor.split(",");
    		String centavos = split[1];
    		if (centavos.length() < 2){
    			valor = valor + "0";
    		}
    		valores.add(valor);
    		contador.add(i);
    		i = i + 1;   			    		
    	    }

        render(produtos, valores, contador);
    }
    }
	    
	    public static void index_adm() {
	    	checaAdm();
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
		        Application.index_adm();
			}
			else{
				Cliente pessoa = Cliente.find("byUsuarioAndSenha", usuario, senha).first();
				if(pessoa != null) {
				    	
			        pessoa.quantidadeDeAcessos = pessoa.quantidadeDeAcessos + 1;
			        pessoa.save();
					session.put("usuario", pessoa.usuario);

				    
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
	    
	    public static void enviaEmail(String nome, String emailRemetente, String telefone, String descricao ) {
	    	

	    	
	    	SimpleEmail email = new SimpleEmail();
	    	try {
				email.setFrom(emailRemetente);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	try {
				email.addTo("evismar.almeida@gmail.com");
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	email.setSubject(nome);
	    	try {
				email.setMsg(descricao);
			} catch (EmailException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	    	Mail.send(email);
		    flash.success("Email enviado com sucesso!");
		    Clientes.clienteLogado();
	    	
	    	
	    }	


	}