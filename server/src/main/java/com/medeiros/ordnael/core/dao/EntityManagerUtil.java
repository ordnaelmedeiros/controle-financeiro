package com.medeiros.ordnael.core.dao;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.medeiros.ordnael.controlefinanceiro.model.Gasto;
import com.medeiros.ordnael.controlefinanceiro.model.GastoGrupo;
import com.medeiros.ordnael.controlefinanceiro.model.GastoSubGrupo;
import com.medeiros.ordnael.controlefinanceiro.model.Usuario;

public class EntityManagerUtil {

	private static SessionFactory sessions = null;
	
	static {
		
		Configuration cfg = new Configuration()
			    .addAnnotatedClass(Usuario.class)
			    .addAnnotatedClass(Gasto.class)
			    .addAnnotatedClass(GastoGrupo.class)
			    .addAnnotatedClass(GastoSubGrupo.class)
			    
			    .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
			    
			    .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
			    .setProperty("hibernate.connection.username", "postgres")
			    .setProperty("hibernate.connection.password", "ids0207")
			    .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/controlefinanceiro3")
			    
			    .setProperty("hibernate.c3p0.min_size", "5")
			    .setProperty("hibernate.c3p0.max_size", "20")
			    .setProperty("hibernate.c3p0.timeout", "1800")
			    .setProperty("hibernate.c3p0.max_statements", "50")
			    
			    .setProperty("hibernate.hbm2ddl.auto", "update")
			    .setProperty("hibernate.format_sql", "true")
				.setProperty("hibernate.show_sql", "true");
		
		sessions = cfg.buildSessionFactory();
		
	}

	public static EntityManager getEntityManager() {
		return sessions.createEntityManager();
	}
	
}
