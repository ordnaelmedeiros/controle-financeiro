package com.medeiros.ordnael.core;

import javax.persistence.EntityManager;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.medeiros.ordnael.core.dao.EntityManagerUtil;

@ApplicationPath("/rest")
public class App extends Application {
	
	private static Integer teste = 0;
	
	public App() {
		
		try {
			
			//String path= System.getProperty("user.dir");
			
			//System.out.println("path: " + path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		teste ++;
		if (teste==1) {
			try  {
				EntityManager entityManager = EntityManagerUtil.getEntityManager();
				entityManager.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
}