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
    public static void produtos() {
        render();
    }


    public static void salvarCadastro(Produto produto, Categoria categoria, File imagem){
    		
    	produto.imagem = imagem;
    	Date data = new Date();
    	produto.dataCadastro = data;
    	produto.categoria = categoria;
   	
        produto.create();
        flash.success("Produto cadastrado!");
        Application.index_adm();
    }

    public static void index() {
        List<Produto> produtos = Produto.findAll();
        render(produtos);
    }
    public static void pesquisa(String search, Integer size, Integer page) {
        List<Produto> produtos = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
        	produtos = Produto.all().fetch(page, size);
        } else {
            search = search.toLowerCase();
            produtos = Produto.find("lower(nome) like ?1 OR lower(descricao) like ?2", "%"+search+"%", "%"+search+"%").fetch(page, size);
        }
        render(produtos, search, size, page);
    }

}
