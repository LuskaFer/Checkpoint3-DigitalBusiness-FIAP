package org.Cp3_Toppo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class EntityManagerFacade {
	
	public static EntityManager getEntityManager() {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("Cp3_Toppo");
		EntityManager manager = factory.createEntityManager();
		return manager;
		
	}

}
