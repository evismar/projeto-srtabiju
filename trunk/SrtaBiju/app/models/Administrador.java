package models;

import java.util.Date;
import java.util.List;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="Administrador")
@AttributeOverrides({
   @AttributeOverride(name="dataNascimento", column=@Column(name="dataNascimento")),
   @AttributeOverride(name="email", column=@Column(name="email")),
   @AttributeOverride(name="nome", column=@Column(name="nome")),
   @AttributeOverride(name="senha", column=@Column(name="senha")),
   @AttributeOverride(name="telefone1", column=@Column(name="telefone1")),
   @AttributeOverride(name="telefone2", column=@Column(name="telefone2")),
   @AttributeOverride(name="usuario", column=@Column(name="usuario")),
   
})
public class Administrador extends Pessoa{


	  
    @Required
    public String cpf;
    
    @Required
    public String tipo;
    
    
/*    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    public List<Pedido> pedido;*/
   
/*    public Cliente(String nome, String email, String telefone1, String telefone2, 
    		String facebook, String dataNascimento,String usuario,String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.facebook = facebook;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        this.senha = senha;
    }*/

    

}


