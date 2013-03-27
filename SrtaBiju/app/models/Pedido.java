package models;

import java.util.Date;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="Pedido")
public class Pedido extends Model{

    
    @Required
    public Date data;
      
    @Required
    @MaxSize(50)
    public String status;
    
    @Required
    public float valorTotal ;
    
       
    @ManyToOne
    public Cliente cliente;
    
    @ManyToOne
    public Administrador administrador;
    
    @OneToOne
    public Endereco endereco;
    
    
   
    public Pedido(Date data, String status, float valorTotal) {
        this.data = data;
        this.status = status;
        this.valorTotal = valorTotal;
    }



}