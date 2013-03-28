package models;

import java.util.Date;
import java.util.List;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

import org.h2.store.Data;

@Entity
@Table(name="PESSOA")
@DiscriminatorValue("A")
public class Administrador extends Pessoa{


	  

    public String cpf;
    

    public String tipo;
    
    public boolean ativo;

    
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    public List<Pedido> pedido;
   
/*    public void Cliente(String nome, String email, String telefone1, String telefone2, String dataNascimento,String usuario,String senha) {
        this.nome = nome;
        this.email = email;
        this.telefone1 = telefone1;
        this.telefone2 = telefone2;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        this.senha = senha;
    }*/

    

}


