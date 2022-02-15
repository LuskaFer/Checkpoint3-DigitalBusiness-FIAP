package org.Cp3_Toppo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.Cp3_Toppo.model.User;
import org.Cp3_Toppo.util.EntityManagerFacade;

public class UserDAO {
	
	EntityManager manager = EntityManagerFacade.getEntityManager();
	
	
	public void create(User user) {
		
		
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		
		manager.close();
		
		
	}

	public List<User> getAll() {
		String jpql = "SELECT s FROM User s";
		TypedQuery<User> query = manager.createQuery(jpql, User.class);
		return query.getResultList();
		}
	
	public User findById(Long id) {
		return manager.find(User.class, id);
	}
	
	public void update (User user) {
		
		manager.getTransaction().begin();
		manager.merge(user);
		manager.flush();
		manager.getTransaction().commit();
	}
public void destroy (User user) {
		
	manager.getTransaction().begin();
	manager.persist(user);
	manager.getTransaction().commit();
	
	manager.close();
	}
	
}


