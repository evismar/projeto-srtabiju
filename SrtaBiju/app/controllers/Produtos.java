package controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.management.Query;

import models.Categoria;
import models.ItemDesejado;
import models.Pessoa;
import models.Produto;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import play.db.jpa.Blob;
import play.db.jpa.JPA;

public class Produtos extends Application{
	

    public static void cadProduto() {
        List<Categoria> categorias = Categoria.findAll();
        render(categorias);
    }
    public static void mostraProdutos() {   
    	
        List<Produto> produtos = Produto.findAll();
        render(produtos);


    }
    
    public static void teste(String consulta, String categoria, String ordem) {   
    	
    	System.out.println(consulta + categoria + ordem);


    }
    
	public static String floatToString(float valorFloat) {
		String valor = Float.toString(valorFloat);

		valor = valor.replace(".", ",");
		String[] split = valor.split(",");
		String centavos = split[1];
		if (centavos.length() < 2) {
			valor = valor + "0";
		}

		if (centavos.length() > 2) {
			valor = split[0] + "," + centavos.substring(0, 2);
		}
		return valor;
	}
    
	public static void relatorioProdutos(String[] args) {
			List codigos = new ArrayList<>();
			List nomes = new ArrayList<>();
			List valores = new ArrayList<>();
			List categorias = new ArrayList<>();
			List datas = new ArrayList<>();
			List quantPedidos = new ArrayList<>();
			List visualizacoes = new ArrayList<>();
			List contador = new ArrayList<>();
		    javax.persistence.Query query = JPA.em().createQuery("select produto.id from Produto produto where produto.ativo = 1");
		    List produtos = query.getResultList();
		    
			for (int i = 0; i < produtos.size(); i++) {
				Produto produto = Produto.findById(produtos.get(i));
				codigos.add(produto.id);
				nomes.add(produto.nome);
				valores.add(floatToString(produto.valor));
				Categoria categoria = Categoria.findById(produto.categoria.id);
				categorias.add(categoria.nome);
	    		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    		Date date = produto.dataCadastro;
	    		String data = dateFormat.format(date);
	    		datas.add(data);
	    		visualizacoes.add(produto.numVisualizacoes);    		
	    		List item =  ItemDesejado.find("select sum(i.quantidade) from ItemDesejado i where i.produto = ?", produto).fetch();	    		
	    		quantPedidos.add(item.get(0));
	    		contador.add(i);

			}

		    	render(codigos, nomes, valores, categorias, datas, quantPedidos, visualizacoes, contador);

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
    	produto.ativo = true;
   	
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

        	
        } else {
            search = search.toLowerCase();
         	produtos = Produto.find("ativo = ? and lower(nome) like ?",true,  "%"+search+"%").fetch(page, size);
        }
       
        render(produtos, search, size, page);
    }
    
    public static void listaProdutosClienteLoop(String search,Integer size, Integer page, Integer selecionado) {

        List<Categoria> categorias = Categoria.findAll();

        List<Produto> produtos = null;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
        	produtos = Produto.find("byAtivo", true).fetch(page, size);
        } else {
            search = search.toLowerCase();
            produtos = Produto.find("ativo = ? and lower(nome) like ?",true,  "%"+search+"%").fetch(page, size);
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
    	    }
        render(selecionado, categorias, produtos, valores, contador, search, size, page);
    }
    
    public static void listaProdutosCliente(){

        List<Produto> produtos = Produto.findAll();
        render(produtos);
    }
    

    
    public static void exclui(Long id){    	
    	Produto produto = Produto.findById(id);
    	produto.ativo = false;
    	produto.save();

        flash.success("Produto excluido!");
        Produtos.index();
    }
    public static void editProduto(Long id){  
    	List<Categoria> categorias = Categoria.findAll();
    	Produto produto = Produto.findById(id);
    	
		String valor = Float.toString(produto.valor);

		valor = valor.replace(".", ",");
		String[] split = valor.split(",");
		String centavos = split[1];
		if (centavos.length() < 2){
			valor = valor + "0";
		}
    	render(produto, valor, categorias, id);
    	
    }
    
    public static void edita(Produto produto, String valor, Categoria categoria, Blob uploadFile, String descricao){
    	
    	valor = valor.replaceAll(",", ".");
    	float valorFloat = Float.parseFloat(valor);
    	produto.valor = valorFloat;
    	produto.categoria = categoria;
    	produto.ativo = true;
    	
    	if(uploadFile != null){
        	produto.imagem = uploadFile;   		
    	}
    	
    	if(produto.descricao == null){
        	produto.descricao = descricao;   		
    	}
   	
        produto.save();
        flash.success("Produto editado!");
        


        Produtos.index();
    	
    }

}
