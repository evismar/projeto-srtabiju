package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import models.*;
public class Clientes extends Application{

    public static void cadCliente() {
        render();
    }


    public static void salvarCadastro(@Valid String nome, String data, String telefone1, String telefone2,
    		String email, String facebook, String usuario, String senha, String confirmaSenha){

    	//Verifica se as senhas estão combinado
        validation.required(senha);
        validation.required(confirmaSenha);
        validation.equals(confirmaSenha, senha).message("Suas senhas não estão combinando");   	
    	
        //Verifica Mínimo e Maximo de caracteres das senhas
        validation.minSize(senha, 4);
        validation.maxSize(senha, 12);
        
        //Verifica se o email é válido
        validation.email(email);
        
        
    	//Verifica se há Logins iguais
	    Pessoa pessoa = Pessoa.find("usuario", usuario).first();
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
    	cadCliente();
    	}    	
    	
    	//Cadastra
    	
    	Cliente cliente = new Cliente(nome, data, telefone1, telefone2, email, facebook, usuario, senha);    	
    	Date dataCadastro = new Date();
        cliente.dataCadastro = dataCadastro;
        cliente.create();

        session.put("cliente", cliente.nome);
        flash.success("Bem vindo, " + cliente.nome);
        Application.index_cliente();
        
        
    }
    
    public static void listaClientes() {
        List<Cliente> clientes = Cliente.findAll();
        render(clientes);
  
	
}
}
