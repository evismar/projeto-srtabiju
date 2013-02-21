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


    public static void salvarCadastro(@Valid Cliente cliente,Endereco endereco, Login login, String confirmaSenha){
        validation.required(confirmaSenha);
        validation.equals(confirmaSenha, login.senha).message("Suas senhas não estão combinado");
        
/*        if(validation.hasErrors()) {
            render("@cadCliente", cliente, login, confirmaSenha);
        }*/
    	Date data = new Date();
        endereco.create();
        login.create();        
        cliente.endereco = endereco;
        cliente.login = login;
        cliente.dataCadastro = data;
        cliente.create();

        session.put("cliente", login.login);
        flash.success("Bem vindo, " + cliente.nome);
        Application.index();
        
        
    }
    
    
    public static void listaClientes() {
        List<Cliente> clientes = Cliente.findAll();
        render(clientes);
    }
}
