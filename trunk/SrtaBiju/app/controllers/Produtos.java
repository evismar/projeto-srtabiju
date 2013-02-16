package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Produtos extends CRUD{
	

    public static void cadProduto() {
        render();
    }

    public static void salvarCadastro(Produto produto){
        
        produto.create();
        flash.success("Produto cadastrado!");
        Application.index();
    }

}
