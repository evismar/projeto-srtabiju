package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;
public class Clientes extends Application{

    public static void cadCliente() {
        render();
    }


    public static void salvarCadastro(@Valid Cliente cliente, String confirmaSenha){
        validation.required(confirmaSenha);
        validation.equals(confirmaSenha, cliente.senha).message("Suas senhas não estão combinado");
        
/*        if(validation.hasErrors()) {
            render("@cadCliente", cliente, confirmaSenha);*/

    	Date data = new Date();
        /*endereco.create();*/       
        /*cliente.endereco = endereco;*/
        cliente.dataCadastro = data;
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
