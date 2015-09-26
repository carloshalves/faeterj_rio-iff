package com.neuroiff.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.neuroiff.model.Medico;
import com.neuroiff.util.jsf.FacesUtil;

@ManagedBean(name ="cadastroMedicoBean")
@ViewScoped
public class MedicoBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("NeuroIFF_PU");
	EntityManager manager = factory.createEntityManager();

	
	private Medico medico;
	
	public MedicoBean(){
		limpar();
	}
	
	private void limpar() {
		medico = new Medico();		
	}
	
	public void guardar(Medico medico) {
		this.manager.merge(medico);	
	}
	
	public void salvar() {
		guardar(this.medico);		
		FacesUtil.addInfoMessage("Medico salvo com sucesso!");
		limpar();
	}
	
	
	
	
	
	
	
	
	
	
}
