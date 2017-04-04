package com.medeiros.ordnael.core.dao;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.medeiros.ordnael.casa.entity.Acesso;
import com.medeiros.ordnael.casa.entity.Sessao;
import com.medeiros.ordnael.casa.entity.Usuario;

public class EntityManagerUtil {

	private static SessionFactory sessions = null;
	
	static {
		
		Configuration cfg = new Configuration()
			    
			.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
			
			.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
			.setProperty("hibernate.connection.username", "postgres")
			.setProperty("hibernate.connection.password", "ids0207")
			.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/casa")
			
			.setProperty("hibernate.c3p0.min_size", "5")
			.setProperty("hibernate.c3p0.max_size", "20")
			.setProperty("hibernate.c3p0.timeout", "1800")
			.setProperty("hibernate.c3p0.max_statements", "50")
			
			.setProperty("hibernate.hbm2ddl.auto", "update")
			.setProperty("hibernate.format_sql", "false")
			.setProperty("hibernate.show_sql", "false");
		
		cfg.addAnnotatedClass(Usuario.class);
		cfg.addAnnotatedClass(Acesso.class);
		cfg.addAnnotatedClass(Sessao.class);
		
		/*
		try {
			List<Class<?>> classes = new ListaDeClasses("com.medeiros.ordnael.casa.model").getClasses();
			System.out.println("Inicio Classes");
			for (Class<?> classe : classes) {
				if (classe.isAnnotationPresent(Table.class)) {
					cfg.addAnnotatedClass(classe);
					System.out.println("--> " + classe.getSimpleName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		sessions = cfg.buildSessionFactory();
		
	}

	public static EntityManager getEntityManager() {
		return sessions.createEntityManager();
	}
	
}
