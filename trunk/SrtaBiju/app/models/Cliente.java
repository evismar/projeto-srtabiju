package models;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

@Entity
@Table(name="Cliente")
public class Cliente extends Model{

    
    @Required
    @MaxSize(15)
    @MinSize(4)
    @Match(value="^\\w*$", message="Nome de usuário inválido!")
    public String login;
    
    @Required
    @MaxSize(15)
    @MinSize(5)
    public String senha;
    
    @Required
    @MaxSize(100)
    public String nome;
   
    public Cliente(String nome, String senha, String login) {
        this.nome = nome;
        this.senha = senha;
        this.login = login;
    }

    public String toString()  {
        return "Cliente(" + login + ")";
    }
}
