package models;

import java.util.Date;
import java.util.List;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="Cliente")
public class Cliente extends Model{

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
    public String facebook;
    
    @Required
    public String dataNascimento ;
    
    @Required
    public Date dataCadastro;
    
    @Required
    public int qtdAcessos;
    
    @ManyToOne
    public Endereco endereco;
    
    @OneToOne
    public Login login;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    public List<Pedido> pedido;
   
    public Cliente(String nome, String email, String telefone1, String telefone2, 
    		String facebook, String dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.facebook = facebook;
        this.dataNascimento = dataNascimento;
    }

    

}

