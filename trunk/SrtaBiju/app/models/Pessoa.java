package models;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name = "Pessoa")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa extends Model{
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
    
    @Id
    @Column(name = "usuario_id")
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

}
