package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;
public class ContCliente extends Application{

    public static void cadCliente() {
        render();
    }

    public static void salvarCadastro(@Valid Cliente cliente,Endereco endereco, Login login, String confirmaSenha){
        validation.required(confirmaSenha);
        validation.equals(confirmaSenha, login.senha).message("Suas senhas não estão combinado");
        
        if(validation.hasErrors()) {
            render("@cadCliente", cliente, confirmaSenha);
        }
        
        endereco.create();
        login.create();        
        cliente.endereco = endereco;
        cliente.login = login;
        cliente.create();

        session.put("cliente", login.login);
        flash.success("Bem vindo, " + cliente.nome);
        Application.index();
    }
}
