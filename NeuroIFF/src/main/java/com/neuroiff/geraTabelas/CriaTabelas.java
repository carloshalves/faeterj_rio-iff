package com.neuroiff.geraTabelas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.neuroiff.model.Medico;
import com.neuroiff.util.jpa.EntityManagerProducer;

public class CriaTabelas {

	public static void main(String[] args) {

		// Persistence.createEntityManagerFactory("NeuroIFF_PU");

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("NeuroIFF_PU");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Medico medico = new Medico();
		medico.setCrm(52345L);
		medico.setEspecialidade("Neurologia");
		medico.setNome("Paulo da Silva");

		manager.persist(medico);
		trx.commit();
		manager.close();

	}

}
