package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.util.*;


import models.*;
public class Fornecedores extends Application{
	
/*    @Before
    static void checaCliente() {
        if(connected() == null) {
            flash.error("Por favor, realize o Login primeiro.");
            Application.index_cliente();
        }
    }*/

    public static void cadFornecedor() {
        render();
    }
    
    public static void index() {
        List<Fornecedor> fornecedores = Fornecedor.findAll();
        render(fornecedores);
    }
    
    public static void salvarCadastro(Fornecedor fornecedor, Endereco endereco){
    	
    	endereco.create();
    	fornecedor.endereco = endereco;
    	fornecedor.ativo = true;
    	
    	if(validation.hasErrors()) {
    	params.flash();
    	validation.keep();
    	cadFornecedor();
    	} 
    	
    	fornecedor.create();
    	cadFornecedor();
    	
    }
    
    public static void listaFornecedoresAdm(String search, Integer size, Integer page) {
        List<Fornecedor> fornecedores = null;
        page = page != null ? page : 1;

        if(search.trim().length() == 0) {
        	fornecedores = Fornecedor.find("byAtivo", true).fetch(page, size);

        	
        } else {
            search = search.toLowerCase();
         	fornecedores = Fornecedor.find("ativo = ? and lower(nome) like ?",true,  "%"+search+"%").fetch(page, size);
        }

        render(fornecedores, search, size, page);
    }
    
    public static void exclui(Long id){    	
    	Fornecedor fornecedor = Fornecedor.findById(id);
    	fornecedor.ativo = false;
    	fornecedor.save();

        flash.success("Fornecedor excluido!");
        Fornecedores.index();
    }
    public static void editFornecedor(Long id){  
    	Fornecedor fornecedor = Fornecedor.findById(id);
    	Endereco endereco = fornecedor.endereco;
    	
    	render(fornecedor, endereco);
    	
    }
    
    public static void edita(Fornecedor fornecedor, Endereco endereco){
    	
    	endereco.save();
    	fornecedor.save();
    	flash.success("Cadastro atualizado com sucesso!");
    	Fornecedores.index();
    	
        
    }
    
}