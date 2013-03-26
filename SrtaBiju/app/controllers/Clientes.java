package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


import models.*;
public class Clientes extends Application{
	
    public static void cadCliente() {
        render();
    }
	
/*    @Before
    static void checaCliente() {
        if(connected() == null) {
            flash.error("Por favor, realize o Login primeiro.");
            Application.index_cliente();
        }
    }*/


    public static void clienteLogado() {
    	Pessoa cliente = connected();
    	DateFormat dateFormat = new SimpleDateFormat("dd//MM/yyyy");
    	Date date = new Date();
    	String data = dateFormat.format(date);
    	Integer size = 6;
    	List<Produto> produtos = null;
    	List valores = new ArrayList<>();
    	List contador = new ArrayList<>();
    	produtos = Produto.find("order by id desc, id").fetch(size);
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
    	
    	List<Pedido> pedidos = Pedido.find("byCliente_id", cliente.id).fetch();
    	Integer numPedidos = pedidos.size();

        render(produtos, valores, contador, cliente, data, numPedidos);
    	
    }


    public static void salvarCadastro(@Valid Cliente cliente, String confirmaSenha){
    	
    	

    	//Verifica se as senhas estão combinado
        validation.required(cliente.senha);
        validation.required(confirmaSenha);
        validation.equals(cliente.senha, confirmaSenha).message("Suas senhas não estão combinando");   	
    	
        //Verifica Mínimo e Maximo de caracteres das senhas
        validation.minSize(cliente.senha, 4);
        validation.maxSize(cliente.senha, 12);
        
        //Verifica se o email é válido
        validation.email(cliente.email).message("Email inválido, por favor, verifique seu email!");
        
        
    	//Verifica se há Logins iguais
        
	    Pessoa pessoa = Pessoa.find("usuario", cliente.usuario).first();
	    if(pessoa != null) {
	    	
	        validation.addError("usuario", "Nome de usuário já cadastrado!"); 
	    }
	    
	    if(pessoa != null) {
	    	System.out.println(pessoa.email);
	    	
	        validation.addError("email", "Email já cadastrado!"); 
	    }
        
        //envia de volta ao formulario se houver erros..
    	if(validation.hasErrors()) {
    	params.flash();
    	validation.keep();
    	cadCliente();
    	}    	
    	
    	//Cadastra
    	
 	
    	Date dataCadastro = new Date();
        cliente.dataCadastro = dataCadastro;
        cliente.quantidadeDeAcessos = cliente.quantidadeDeAcessos + 1;
        cliente.create();
        
        flash.success("Bem vindo, " + cliente.usuario);
        Application.login(cliente.usuario, cliente.senha);


        
        
    }
    
    public static void editCliente(Long id){
    	
    	Cliente cliente = Cliente.findById(id);
    	render(cliente);
    	
        
    }
    
    public static void edita(Cliente cliente){
    	
    	cliente.save();
    	flash.success("Cadastro atualizado com sucesso!");
    	Clientes.clienteLogado();
    	
        
    }
    public static void listaClientes() {
        List<Cliente> clientes = Cliente.findAll();
        render(clientes);
  
	
    }

    public static void realizaPedido(Long idProduto, Long idCliente) {
    	Produto produto = Produto.findById(idProduto);
    	Cliente cliente = Cliente.findById(idCliente);
    	
    }
}