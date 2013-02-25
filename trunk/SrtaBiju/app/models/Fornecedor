package models;

import java.util.Date;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="Fornecedor")
public class Fornecedor extends Model{

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	public Integer id = 0;
    
    @Required
    @MaxSize(50)
    public String email;
    
    @Required
    @MaxSize(100)
    public String nome;
    
    @Required
    @MaxSize(10)
    @MinSize(10)
    public String telefone1;
    
    @Required
    @MaxSize(10)
    @MinSize(10)
    public String telefone2;
    
    
    @MaxSize(50)
    public String site;
    
//Evismar nao sei como colocar de (0,1) para (1,1)    
    @ManyToOne
    public Endereco endereco;
    
   
    public Fornecedor(String nome, String email, String telefone1, String telefone2, 
    		String Site) {
        this.nome = nome;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.Site = Site;
    }

    

}

