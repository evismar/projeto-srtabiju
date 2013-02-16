package models;

import java.io.File;
import java.util.Date;

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
    public File imagem;
    
    @Required
    public Date dataCadastro;
    
    @Required
    public int quantidadeEmEstoque;
    
    @Required
    public float valor;
    
    @Required
    public int numVisualizacoes;
    
    @ManyToOne
    public Categoria categoria;
    
    
    
    
   
//    public Produto(String nome, String descricao, File foto) {
//        this.nome = nome;
//        this.descricao = descricao;
//        this.foto = foto;
//    }


}
