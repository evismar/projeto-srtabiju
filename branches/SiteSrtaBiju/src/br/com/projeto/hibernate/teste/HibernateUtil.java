package br.com.projeto.hibernate.teste;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author Paulo Luan
 *
 *         http://javafxbr.com/blog
 *
 *         Esta classe cria o Objeto que se responsabiliza pela quest�o de
 *         sess�es e configura��es do hibernate � partir do arquivo de
 *         configura��es XML (hibernate.cfg.xml).
 */
@SuppressWarnings("deprecation")
public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		sessionFactory = new AnnotationConfiguration().configure()
				.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/*
	 * m�todo que cria as tabelas no Banco de dados a partir das anota��es
	 * feitas na classe Pessoa, ele consegue encontrar a classe que cont�m as
	 * anota��es para a cria��o das tabelas a partir do arquivo
	 * "hibernate.cfg.xml" que cont�m as configura��es indicando as
	 */
	public void criaTabelaNoBD() {
		try {
			AnnotationConfiguration cfg = new AnnotationConfiguration();
			cfg.configure();
			SchemaExport schema = new SchemaExport(cfg);
			schema.create(true, true);
			getSessionFactory().openSession().beginTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}