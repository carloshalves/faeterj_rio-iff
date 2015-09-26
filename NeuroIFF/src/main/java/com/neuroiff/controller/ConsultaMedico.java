package com.neuroiff.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.neuroiff.model.Medico;
import com.neuroiff.repository.MedicoRepository;
import com.neuroiff.util.jpa.JpaUtil;



@ManagedBean
@ViewScoped
public class ConsultaMedico implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Medico> medicos;

	public void consultar() {

		EntityManager manager = JpaUtil.getEntityManager();

		MedicoRepository medicoRepository = new MedicoRepository(manager);
		this.medicos = medicoRepository.todos();
		
		manager.close();
	}

	public List<Medico> getMedicos() {
		return medicos;
	}
	
	
	

}
