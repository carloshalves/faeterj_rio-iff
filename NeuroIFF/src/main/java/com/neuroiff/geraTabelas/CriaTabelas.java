package com.neuroiff.geraTabelas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.neuroiff.model.Medico;
import com.neuroiff.util.jpa.EntityManagerProducer;
import com.neuroiff.util.jpa.JpaUtil;

public class CriaTabelas {

	public static void main(String[] args) {

		// Persistence.createEntityManagerFactory("NeuroIFF_PU");

		//EntityManagerFactory factory = Persistence.createEntityManagerFactory("NeuroIFF_PU");
		//EntityManager manager = factory.createEntityManager();
		
		
		EntityManager manager = JpaUtil.getEntityManager();

		EntityTransaction trx = manager.getTransaction();
		trx.begin();

		Medico medico = new Medico();
		medico.setCrm(523489L);
		medico.setEspecialidade("Psiquiatria");
		medico.setNome("Aline Fraga");

		manager.persist(medico);
		trx.commit();
		manager.close();

	}

}
