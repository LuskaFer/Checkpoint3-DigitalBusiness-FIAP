package org.Cp3_Toppo.bean;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.Cp3_Toppo.dao.UserDAO;
import org.Cp3_Toppo.model.User;

@Named
@RequestScoped
public class UserBean {

	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void save() {
		new UserDAO().create(this.user);
		System.out.println(this.user);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Cadastro realizado!"));
		}
	
	public List<User> getUsers(){
		return new UserDAO().getAll();
	}
}


