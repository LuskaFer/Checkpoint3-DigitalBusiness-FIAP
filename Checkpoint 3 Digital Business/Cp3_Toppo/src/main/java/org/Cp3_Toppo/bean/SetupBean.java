package org.Cp3_Toppo.bean;
import org.Cp3_Toppo.dao.SetupDAO;
import org.Cp3_Toppo.model.Setup;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class SetupBean {
	
	private Setup setup = new Setup();
	
	public void save() {
		new SetupDAO().create(this.setup);
		System.out.println(this.setup);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Setup finalizado com sucesso!"));
	}
	
	public List<Setup> getSetups(){
		return new SetupDAO().getAll();
	}




	public void setSetup(Setup setup) {
		this.setup = setup;
	}


	public Setup getSetup() {
		return setup;
	}

}


