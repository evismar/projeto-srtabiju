package models;

import java.util.Date;
import java.util.List;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="Administrador")
public class Administrador extends Model{

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
    
    @MaxSize(10)
    @MinSize(10)
    public String telefone2;
    
    
    @Required
    public String dataNascimento ;
    
    @Required
    public String cpf;
    
    @Required
    public String tipo;
    
    @Required
    @MaxSize(15)
    @MinSize(4)
    @Match(value="^\\w*$", message="Nome de usuário inválido!")
    public String usuario;
    
    @Required
    @MaxSize(15)
    @MinSize(5)
    @Match(value="^\\w*$", message="Senha Inválida!")
    public String senha;
    
    @OneToOne
    public Login login;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    public List<Pedido> pedido;
   
    public Cliente(String nome, String email, String telefone1, String telefone2, 
    		String facebook, String dataNascimento,String usuario,String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.facebook = facebook;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        this.senha = senha;
    }

    

}


