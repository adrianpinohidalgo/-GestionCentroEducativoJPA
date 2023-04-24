package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Estudiante;

public class EstudianteController {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("GestionCentroEducativoJPA");

	/** 
	 * 
	 */
	public static List<Estudiante> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM estudiante;", Estudiante.class);
		List<Estudiante> l = (List<Estudiante>) q.getResultList();

		em.close();

		return l;
	}
}
