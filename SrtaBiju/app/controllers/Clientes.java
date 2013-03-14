package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;


import models.*;
public class Clientes extends Application{
	
/*    @Before
    static void checaCliente() {
        if(connected() == null) {
            flash.error("Por favor, realize o Login primeiro.");
            Application.index_cliente();
        }
    }*/

    public static void cadCliente() {
        render();
    }
    public static void clienteLogado() {
        render();
    }


    public static void salvarCadastro(@Valid Cliente cliente, String confirmaSenha){

    	//Verifica se as senhas estão combinado
        validation.required(cliente.senha);
        validation.required(confirmaSenha);
        validation.equals(cliente.senha, confirmaSenha).message("Suas senhas não estão combinando");   	
    	
        //Verifica Mínimo e Maximo de caracteres das senhas
        validation.minSize(cliente.senha, 4);
        validation.maxSize(cliente.senha, 12);
        
        //Verifica se o email é válido
        validation.email(cliente.email);
        
        
    	//Verifica se há Logins iguais
	    Pessoa pessoa = Pessoa.find("usuario", cliente.usuario).first();
	    if(pessoa != null) {
	    	
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
    	
 	
    	Date dataCadastro = new Date();
        cliente.dataCadastro = dataCadastro;
        cliente.quantidadeDeAcessos = cliente.quantidadeDeAcessos + 1;
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
