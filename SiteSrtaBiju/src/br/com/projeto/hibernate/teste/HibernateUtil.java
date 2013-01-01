package br.com.projeto.hibernate.teste;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

/**
 * @author Paulo Luan
 *
 *         http://javafxbr.com/blog
 *
 *         Esta classe cria o Objeto que se responsabiliza pela questão de
 *         sessões e configurações do hibernate à partir do arquivo de
 *         configurações XML (hibernate.cfg.xml).
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
	 * método que cria as tabelas no Banco de dados a partir das anotações
	 * feitas na classe Pessoa, ele consegue encontrar a classe que contém as
	 * anotações para a criação das tabelas a partir do arquivo
	 * "hibernate.cfg.xml" que contém as configurações indicando as
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