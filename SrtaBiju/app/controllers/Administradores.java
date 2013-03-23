package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import models.*;
public class Administradores extends Application{

    public static void cadAdministrador() {
        render();
    }
    public static void minhaConta() {
        render();
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
    	administrador.create();

        session.put("administrador", administrador.nome);
        flash.success("Bem vindo, " + administrador.nome);
        Application.index_adm();
        
        
    }
    
    public static void listaAdministradores() {
        List<Administrador> administradores = Administrador.findAll();
        render(administradores);
  
	
}
}
