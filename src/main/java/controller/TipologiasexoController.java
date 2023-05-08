package controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Materia;
import model.Tipologiasexo;
import model.Valoracionmateria;

public class TipologiasexoController {
	private static EntityManagerFactory entityManagerFactory = Persistence
			.createEntityManagerFactory("GestionCentroEducativoJPA");

	/** 
	 * 
	 */
	public static List<Tipologiasexo> findAll() {
		EntityManager em = entityManagerFactory.createEntityManager();

		Query q = em.createNativeQuery("SELECT * FROM estudiante;", Tipologiasexo.class);
		List<Tipologiasexo> l = (List<Tipologiasexo>) q.getResultList();

		em.close();

		return l;
	}
	
	/** 
	 * 
	 */
	public static Tipologiasexo findById(int id) {
		EntityManager em = entityManagerFactory.createEntityManager();
		Tipologiasexo o = null;

		try {
			Query q = em.createNativeQuery(
					"select * from tipologiaSexo where id = ?;",
					Valoracionmateria.class);
			q.setParameter(1, id);

			o = (Tipologiasexo) q.getSingleResult();
		} catch (Exception e) {
		}

		em.close();

		return o;
	}

	/**
	 * 
	 * @return
	 */
//	public static Sexo findById(int id) {
//		Sexo o = null;
//
//		try {
//			Connection conn = ConnectionManager.getConexion();
//			Statement st = conn.createStatement();
//			ResultSet rs = st.executeQuery("select * from tipologiaSexo where id =" + id);
//
//			if (rs.next()) {
//				o = new Sexo();
//				o.setId(rs.getInt("id"));
//				o.setDescripcion(rs.getString("descripcion"));
//			}
//			rs.close();
//			st.close();
//			conn.close();
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
//
//		return o;
//	}
}
