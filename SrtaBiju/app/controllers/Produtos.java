package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import play.db.jpa.Blob;
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
    public static void mostraProdutos() {   
    	
        List<Produto> produtos = Produto.findAll();
        render(produtos);


    }
    
    public static void imagemProduto(Long id) {       

        final Produto produto = Produto.findById(id);
    	renderBinary(produto.imagem.get());
        notFoundIfNull(produto);
        response.setContentTypeIfNotSet(produto.imagem.type());
        renderBinary(produto.imagem.get());

    }
    
    


    public static void salvarCadastro(Produto produto, String valor, Categoria categoria, Blob uploadFile){
    	
    	valor = valor.replaceAll(",", ".");
    	float valorFloat = Float.parseFloat(valor);
    	produto.valor = valorFloat;
    	produto.imagem = uploadFile;
    	Date data = new Date();
    	produto.dataCadastro = data;
    	produto.categoria = categoria;
   	
        produto.create();
        flash.success("Produto cadastrado!");
        Produtos.cadProduto();
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
    
    public static void listaProdutosClienteLoop(String search,Integer size, Integer page) {


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
    
    public static void listaProdutosCliente(){
        List<Produto> produtos = Produto.findAll();
        render(produtos);
    }

}
