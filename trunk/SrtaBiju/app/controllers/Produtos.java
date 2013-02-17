package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import play.db.jpa.GenericModel.JPAQuery;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import models.*;

public class Produtos extends Application{
	

    public static void cadProduto() {
        List<Categoria> categorias = Categoria.findAll();
        render(categorias);
    }


    public static void salvarCadastro(Produto produto, Categoria categoria, File imagem){
    		
    	produto.imagem = imagem;
    	Date data = new Date();
    	produto.dataCadastro = data;
    	produto.categoria = categoria;
    	
    	System.out.println(imagem);
    	System.out.println(produto.imagem);
    	System.out.println(imagem.getName());
    	System.out.println(produto.imagem.getName());
    	
      //  produto.create();
        flash.success("Produto cadastrado!");
        Application.index();
    }

}
