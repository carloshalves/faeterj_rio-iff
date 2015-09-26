package com.neuroiff.BEAN;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.neuroiff.model.Medico;
import com.neuroiff.repository.Medicos;
import com.neuroiff.util.jpa.EntityManagerProducer;

@ManagedBean
@ViewScoped
public class MedicoBean implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	private List<Medico> medicos;

	public void consultar() {		
		Medicos medicos = new Medicos(manager);
		this.medicos = medicos.todos();
		manager.close();
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

}
