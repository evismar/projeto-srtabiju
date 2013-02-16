package models;

import java.util.List;

import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="Endereco")
public class Endereco extends Model{
	

	
    @Required
    @MaxSize(30)
	public String estado;
    
    @Required
    @MaxSize(30)
	public String cidade;
    
    @Required
    @MaxSize(30)
	public String bairro;
    
    @Required
    @MaxSize(5)
	public String numero;
    
    @Required
    @MaxSize(8)
    @MinSize(8)
	public String cep;
    
    @Required
    @MaxSize(100)
	public String rua;
    
    @Required
    @MaxSize(150)
	public String complemento;
	
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "endereco")
    public List<Cliente> cliente;

}
