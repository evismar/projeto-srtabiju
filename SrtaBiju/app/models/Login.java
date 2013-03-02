package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
@Table(name="Login")
public class Login extends Model{
	

	
    @Required
    @MaxSize(15)
    @MinSize(4)
    @Match(value="^\\w*$", message="Nome de usuário inválido!")
    public String login;
    
    @Required
    @MaxSize(15)
    @MinSize(5)
    @Match(value="^\\w*$", message="Senha Inválida!")
    public String senha;
    

    
    

}
