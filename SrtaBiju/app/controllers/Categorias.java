package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;

import models.*;

public class Categorias extends Application{
	
    public static void index() {
    	List<Categoria> categorias = Categoria.findAll();    	
        render(categorias);
    }
    public static void listaCategoriasAdm(String search, Integer size, Integer page) {
        List<Categoria> categorias = null;
        page = page != null ? page : 1;

        	categorias = Categoria.find("byAtivo", true).fetch(page, size);

       
        render(categorias, search, size, page);
    }
    
    public static void cadCategoria() {
        render();
    }
    public static void editCategoria(Long id) {
    	Categoria categoria = Categoria.findById(id);
        render(categoria);
    }
    public static void edita(Categoria categoria, String descricao) {
    	if (categoria.descricao.isEmpty()){
    		categoria.descricao = descricao;
    	}
        flash.success("Categoria editada!");
    	categoria.save();
    	index();
    }
    public static void exclui(Long id) {
    	Categoria categoria = Categoria.findById(id);
    	categoria.ativo = false;
    	categoria.save();
    	
    	List<Produto> produtos = Produto.find("byCategoria_id", categoria.id).fetch();
    	
    	for (Produto produto : produtos){
    		produto.ativo = false;
    		produto.save();
    		
    	}
    	
    	index();
    }

    public static void salvarCadastro(Categoria categoria){
        
        categoria.create();
        flash.success("Categoria cadastrada!");
        Application.index_adm();
    }

}
