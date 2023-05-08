package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import model.Estudiante;
import model.Valoracionmateria;

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
	
	/**
	 * 
	 * @param o
	 */
	public static void update(Estudiante o) {
		EntityManager em = entityManagerFactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(o);
		JOptionPane.showMessageDialog(null, "Cambios realizados");
		em.getTransaction().commit();
		em.close();
	}
}
