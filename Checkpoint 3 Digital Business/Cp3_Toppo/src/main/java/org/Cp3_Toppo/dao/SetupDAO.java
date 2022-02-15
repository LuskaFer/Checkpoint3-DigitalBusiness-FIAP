package org.Cp3_Toppo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.Cp3_Toppo.model.Setup;
import org.Cp3_Toppo.util.EntityManagerFacade;

public class SetupDAO {
	
	EntityManager manager = EntityManagerFacade.getEntityManager();
	
	
	public void create(Setup setup) {
		
		
		manager.getTransaction().begin();
		manager.persist(setup);
		manager.getTransaction().commit();
		
		manager.close();
		
		
	}

	public List<Setup> getAll() {
		String jpql = "SELECT s FROM Setup s";
		TypedQuery<Setup> query = manager.createQuery(jpql, Setup.class);
		return query.getResultList();
		}
	
	public Setup findById(Long id) {
		return manager.find(Setup.class, id);
	}
	
	public void update (Setup setup) {
		
		manager.getTransaction().begin();
		manager.merge(setup);
		manager.flush();
		manager.getTransaction().commit();
	}
}
