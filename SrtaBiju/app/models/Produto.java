package models;

import java.io.File;
import java.util.Date;
import java.util.List;

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
    public Blob imagem;
    
    @Required
    public Date dataCadastro;
    
    @Required
    public int quantidadeEmEstoque;
    
    @Required
    public float valor;
    
    @Required
    public int numVisualizacoes;
    
    public Boolean ativo;
    
    @ManyToOne
    public Categoria categoria;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    public List<Produto> produto;
    
    
    
    
   
    public Produto(String nome, String descricao, Blob imagem, float valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.valor = valor;
    }


}
