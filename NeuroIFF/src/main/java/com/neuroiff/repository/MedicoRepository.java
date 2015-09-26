package com.neuroiff.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.neuroiff.model.Medico;

public class MedicoRepository implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager manager;

	public MedicoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public List<Medico> todos() {
		TypedQuery<Medico> query = manager.createQuery("from Medico", Medico.class);
		return query.getResultList();
	}
	
	public Medico porId(Long id) {
		return manager.find(Medico.class, id);
		}
	
	public void adicionar(Medico medico) {
		this.manager.persist(medico);
		}
	
	
	

}
