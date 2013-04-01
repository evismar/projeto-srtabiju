package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import models.*;
public class Administradores extends Application{
	
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

    public static void cadAdministrador() {
    	checaAdm();
        render();
    }
    public static void minhaConta() {
        render();
    }
    public static void pedidos() {
    	checaAdm();
    	List<Pedido> pedidos = Pedido.find("byStatus", "fechado").fetch();
        render(pedidos);
    }
    public static void index() {
    	checaAdm();
        List<Administrador> administradores = Administrador.findAll();
        render(administradores);

    }
    
    public static void editAdministrador(Long id){  
    	checaAdm();
    	Administrador administrador = Administrador.findById(id);
    	render(administrador, id);
    	
    }
    
	public static void edita(Administrador administrador) {

		administrador.save();
		flash.success("Cadastro atualizado com sucesso!");
		Administradores.index();

	}
	
    public static void exclui(Long id){    	
    	Administrador administrador = Administrador.findById(id);
    	administrador.ativo = false;
    	administrador.save();

        flash.success("Administrador excluido!");
        Administradores.index();
    }
    
    public static void listaAdministradoresAdm(String search, Integer size, Integer page) {
        List<Administrador> administradores = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
        	administradores = Administrador.find("byAtivo", true).fetch(page, size);

        	
        } else {
            search = search.toLowerCase();
            administradores = Produto.find("ativo = ? and lower(nome) like ?",true,  "%"+search+"%").fetch(page, size);
        }
       
        render(administradores, search, size, page);
    }

    public static void salvarCadastro(@Valid Administrador administrador, String confirmaSenha){

    	//Verifica se as senhas estão combinado
        validation.required(administrador.senha);
        validation.required(confirmaSenha);
        validation.equals(administrador.senha, confirmaSenha).message("Suas senhas não estão combinando");   	
    	
        //Verifica Mínimo e Maximo de caracteres das senhas
        validation.minSize(administrador.senha, 4);
        validation.maxSize(administrador.senha, 12);
        
        //Verifica se o email é válido
        validation.email(administrador.email);
        
        
    	//Verifica se há Logins iguais
	    Pessoa pessoa = Pessoa.find("usuario", administrador.usuario).first();
	    if(pessoa != null) {
	    	System.out.println(pessoa.nome);
	    	
	        validation.addError("usuario", "Nome de usuário já cadastrado!"); 
	    }
	    
	    if(pessoa != null) {
	    	System.out.println(pessoa.email);
	    	
	        validation.addError("email", "Email já cadastrado!"); 
	    }
        
        //envia de volta ao formulario se houver erros..
    	if(validation.hasErrors()) {
    	params.flash();
    	validation.keep();
    	cadAdministrador();
    	}    	
    	
    	//Cadastra
    	
 	
    	Date dataCadastro = new Date();
    	administrador.dataCadastro = dataCadastro;
    	administrador.ativo = true;
    	administrador.create();

        session.put("administrador", administrador.nome);
        flash.success("Bem vindo, " + administrador.nome);
        Application.index_adm();
        
        
    }
    
    public static void listaAdministradores() {
    	checaAdm();
        List<Administrador> administradores = Administrador.findAll();
        render(administradores);
  
	
}
}
