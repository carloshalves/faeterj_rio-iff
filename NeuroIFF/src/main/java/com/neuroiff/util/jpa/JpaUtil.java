package com.neuroiff.util.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	private static EntityManagerFactory factory;

	static { factory = Persistence.createEntityManagerFactory( "NeuroIFF_PU");
	
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
