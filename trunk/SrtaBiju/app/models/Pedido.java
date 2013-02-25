package models;

import java.util.Date;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="Pedido")
public class Pedido extends Model{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public Integer id = 0;
    
    @Required
    @MaxSize(8)
    public Date data;
    
    @Required
    @MaxSize(8)
    public String hora;
    
    @Required
    @MaxSize(50)
    public String status;
    
    @Required
    @MaxSize(20)
    public Double valorTotal ;
    
       
    @OneToMany
    public Cliente cliente;
    
   
    public Pedido(Date data, String hora, String status, Double valorTotal) {
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.valorTotal = valorTotal;
    }

    

}