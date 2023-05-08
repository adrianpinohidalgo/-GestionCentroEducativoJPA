package view;

import java.util.List;

import controller.EstudianteController;
import model.Estudiante;

public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Nombre", "1º apellido", "2º apellido", "DNI", "Dirección", "Email", "Teléfono"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		List<Estudiante> l = EstudianteController.findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[l.size()][8];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < l.size(); i++) {
			Estudiante o = l.get(i);
			datos[i][0] = o.getId();
			datos[i][1] = o.getNombre();
			datos[i][2] = o.getApellido1();
			datos[i][3] = o.getApellido2();
			datos[i][4] = o.getDni();
			datos[i][5] = o.getDireccion();
			datos[i][6] = o.getEmail();
			datos[i][7] = o.getTelefono();
		}
		
		return datos;
	}
	
	
}
