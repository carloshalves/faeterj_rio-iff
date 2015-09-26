package com.neuroiff.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.neuroiff.model.Medico;


public class Medicos implements Serializable {

	private static final long serialVersionUID = 1L;

	//@Inject
	private EntityManager manager;

	public Medicos(EntityManager manager) {
		this.manager = manager;
	}

	public List<Medico> todos() {
		TypedQuery<Medico> query = manager.createQuery("from Medico", Medico.class);
		return query.getResultList();
	}

	public void guardar(Medico medico) {
		this.manager.merge(medico);	
	}
	
	
	public Medico porId(Long id) {
		return this.manager.find(Medico.class, id);
	}
	
	public List<Medico> porNome(String nome) {
		return this.manager.createQuery("from Medico " +
				"where upper(nome) like :nome", Medico.class)
				.setParameter("nome", nome.toUpperCase() + "%")
				.getResultList();
	}
	
	/*
	public Medico salvar(Medico medico) {
		Medico medicoExistente = Medicos.porId(medico.getId());		
		
		if (medicoExistente != null && !medicoExistente.equals(medico)) {
			throw new NegocioException("Já existe um Medico com o nome informado.");
		}	
		return Medicos.guardar(medico);
		
	}
	
	*/
	
	

}
