package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import models.*;
public class Pedidos extends Application{



    public static void index() {
    	List<Pedido> pedidos = Pedido.find("byStatus", "fechado").fetch();
        render(pedidos);
    }
    
    public static void visualizaPedido(Long id) {
    	System.out.println(id);
    	Pedido pedido = Pedido.findById(id);
    	pedido.status = "visto";
    	pedido.save();
    	index();
    }
    


    
    public static void listaPedidosAdm(String search, Integer size, Integer page) {
        List<Pedido> pedidos = null;
		List nomesClientes = new ArrayList<>();
		List datas = new ArrayList<>();
		List horas = new ArrayList<>();
		List contador = new ArrayList<>();
		List status = new ArrayList<>();
		Integer i = 0;
        page = page != null ? page : 1;
        if(search.trim().length() == 0) {
/*        	pedidos = Pedido.find("order by data desc").fetch(page, size);*/
        	pedidos = Pedido.find("order by data desc, data").fetch(page, size);
        	

        	
        } else {
            search = search.toLowerCase();
            pedidos = Produto.find("lower(id) like ?1 OR lower(id) like ?2", "%"+search+"%", "%"+search+"%").fetch(page, size);
        }
        
        for (Pedido pedido : pedidos ){
        	contador.add(i);
        	Cliente cliente = Cliente.findById(pedido.cliente.id);
        	nomesClientes.add(cliente.nome);
        	status.add(pedido.status);
        	
    		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    		Date date = pedido.data;
    		String data = dateFormat.format(date);
    		datas.add(data);
    		
    		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
    		Date time = pedido.data;
    		String hour = timeFormat.format(time);
    		horas.add(hour);
        	
        	
        	i = i + 1;
        }
       
        render(pedidos, contador, datas, horas, status, nomesClientes, search, size, page);
    }

 
}
