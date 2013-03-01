package models;

import java.util.Date;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="ItemDesejado")
public class ItemDesejado extends Model{
/*
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public Integer id = 0;
    
    
    @Required
    @MaxSize(20)
    public Integer quantidade;
    
    @Required
    @MaxSize(10)
    public Double valorNaHoraPedido;
    
    
       
    @OneToOne
    public Pedido pedido;
    
    @ManyToOne
    public Produto produto;
    
   
    public ItemDesejado(Integer quantidade, Double valorNaHoraPedido) {
        this.quantidade = quantidade;
        this.valorNaHoraPedido = valorNaHoraPedido;
    }

    
*/
}