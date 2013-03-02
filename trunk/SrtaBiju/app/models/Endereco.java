package models;

import java.util.HashSet;
import java.util.List;

import play.db.jpa.*;
import play.data.validation.*;

import javax.persistence.*;

import org.h2.store.Data;

import java.util.Set;

@Entity
@Table(name="Endereco")
public class Endereco extends Model{
	

	

    @MaxSize(30)
	public String estado;
    

    @MaxSize(30)
	public String cidade;
    

    @MaxSize(30)
	public String bairro;
    

    @MaxSize(5)
	public String numero;
    

    @MaxSize(8)
    @MinSize(8)
	public String cep;
    

    @MaxSize(100)
	public String rua;
    

    @MaxSize(150)
	public String complemento;
	
    @ManyToMany(mappedBy="enderecos")
    private Set<Cliente> clientes = new HashSet<Cliente>();
}
