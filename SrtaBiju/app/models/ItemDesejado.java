package models;

import java.util.Date;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="ItemDesejado")
public class ItemDesejado extends Model{

    
    
    @Required
    @MaxSize(20)
    public Integer quantidade;
    
    @Required
    @MaxSize(10)
    public float valorNaHoraPedido;
    
    
       
    @OneToOne
    public Pedido pedido;
    
    @ManyToOne
    public Produto produto;
    
   
    public ItemDesejado(Integer quantidade, float valor) {
        this.quantidade = quantidade;
        this.valorNaHoraPedido = valor;
    }

}