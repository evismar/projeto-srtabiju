package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;
import play.db.jpa.Blob;
import play.db.jpa.GenericModel.JPAQuery;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.management.Query;

import com.sun.org.apache.xpath.internal.operations.And;

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
    public static void listaProdutosAdm(String search, Integer size, Integer page) {
        List<Produto> produtos = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
        	produtos = Produto.find("byAtivo", true).fetch(page, size);
/*        	produtos = Produto.find("not ativo").fetch(page, size);*/
        	
        } else {
            search = search.toLowerCase();
            /*produtos = Produto.find("lower(nome) like ?1 OR lower(descricao) like ?2 where ativo like ?3", 
              "%"+search+"%", "%"+search+"%", true).fetch(page, size);*/
            /*produtos = Produto.find("lower(nome) like ?1 AND lower(descricao) like ?2" + "where ativo = 'true'", "%"+search+"%", "%"+search+"%").fetch(page, size);*/
            produtos = Produto.find("where ativo = true").fetch(page, size);
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
            produtos = Produto.find("lower(nome) like ?1 AND lower(descricao) like ?2", "%"+search+"%", "%"+search+"%").fetch(page, size);
        }
    	List valores = new ArrayList<>();
    	List contador = new ArrayList<>();
		Integer i = 0;
    	for(Produto produto : produtos ){

    		String valor = Float.toString(produto.valor);

    		valor = valor.replace(".", ",");
    		String[] split = valor.split(",");
    		String centavos = split[1];
    		if (centavos.length() < 2){
    			valor = valor + "0";
    		}
    		valores.add(valor);
    		contador.add(i);
    		i = i + 1; 
    		System.out.println(produtos.size());
    		System.out.println(valores.size());
    		System.out.println(contador.size());
    	    }
        render(produtos, valores, contador, search, size, page);
    }
    
    public static void listaProdutosCliente(){
        List<Produto> produtos = Produto.findAll();
        render(produtos);
    }
    
    public static void exclui(Long id){    	
    	Produto produto = Produto.findById(id);
    	produto.ativo = false;
    	produto.save();
    }

}
