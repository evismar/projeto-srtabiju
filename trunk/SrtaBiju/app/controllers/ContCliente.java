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

    public static void salvarCadastro(@Valid Cliente cliente, String confirmaSenha){
        validation.required(confirmaSenha);
        validation.equals(confirmaSenha, cliente.senha).message("Suas senhas não estão combinado");
        if(validation.hasErrors()) {
            render("@cadCliente", cliente, confirmaSenha);
        }
        cliente.create();
        session.put("cliente", cliente.login);
        flash.success("Bem vindo, " + cliente.nome);
        Application.index();
    }
}
