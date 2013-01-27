package models;

import java.io.File;

import play.db.jpa.*;
import play.data.validation.*;
import javax.persistence.*;

@Entity
@Table(name="Produto")
public class Produto extends Model{
    

    
    @Required
    @MaxSize(100)
    public String nome;
    
    @Required
    @MaxSize(200)
    public String descricao;
    
    @Required
    public File foto;
    
   
    public Produto(String nome, String descricao, File foto) {
        this.nome = nome;
        this.descricao = descricao;
        this.foto = foto;
    }


}
