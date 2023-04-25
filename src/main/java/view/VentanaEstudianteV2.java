package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EstudianteController;
import controller.MateriaController;
import controller.ProfesorController;
import controller.ValoracionController;
import model.Estudiante;
import model.Materia;
import model.Profesor;
import model.Valoracionmateria;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class VentanaEstudianteV2 extends JFrame {

	private JPanel contentPane;
	private static JComboBox jcbMateria;
	private static JComboBox jcbProfesor;
	private static JComboBox jcbNota;

	private JList jlistEstudiantesIzq;
	private JList jlistEstudiantesDer;
	private DefaultListModel<Estudiante> listModelEstudiantesIzq = null;
	private DefaultListModel<Estudiante> listModelEstudiantesDer = null;
	private List<Estudiante> estudiantes = EstudianteController.findAll();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEstudianteV2 frame = new VentanaEstudianteV2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaEstudianteV2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(208, 208, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.weightx = 1.0;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
//		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0};
//		gbl_panel.columnWeights = new double[]{1.0, 0.0};
//		gbl_panel.columnWeights = new double[]{0.0, 1.0};
		// gbl_panel.columnWidths = new int[]{0, 0};
		// gbl_panel.rowHeights = new int[]{0, 0, 0};
		// gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		// gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox();
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.weightx = 1.0;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 0);
		gbc_jcbMateria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbMateria.gridx = 1;
		gbc_jcbMateria.gridy = 0;
		panel.add(jcbMateria, gbc_jcbMateria);

		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbProfesor = new JComboBox();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);

		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbNota = new JComboBox();
		GridBagConstraints gbc_jcbNota = new GridBagConstraints();
		gbc_jcbNota.insets = new Insets(0, 0, 5, 0);
		gbc_jcbNota.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbNota.gridx = 1;
		gbc_jcbNota.gridy = 2;
		panel.add(jcbNota, gbc_jcbNota);

		JButton btnCargar = new JButton("Botón actualizar alumnado");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todoIzq();
			}
		});
		GridBagConstraints gbc_btnCargar = new GridBagConstraints();
		gbc_btnCargar.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargar.anchor = GridBagConstraints.EAST;
		gbc_btnCargar.gridx = 1;
		gbc_btnCargar.gridy = 3;
		panel.add(btnCargar, gbc_btnCargar);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.weighty = 1.0;
		gbc_panel_3.gridwidth = 2;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 4;
		panel.add(panel_3, gbc_panel_3);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 150.0;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
//		gbl_panel_1.rowWeights = new double[]{1.0, 0.0};
//		gbl_panel_1.columnWeights = new double[]{1.0};
//		gbl_panel_1.columnWidths = new int[]{0};
//		gbl_panel_1.rowHeights = new int[]{0};
//		gbl_panel_1.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 187));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.weighty = 1.0;
		gbc_panel_2.weightx = 1.0;
		gbc_panel_2.insets = new Insets(0, 0, 5, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, 0.0, 1.0 };
//		gbl_panel_2.rowWeights = new double[]{0.0, 1.0};
//		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0};
//		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//		gbl_panel_2.rowHeights = new int[]{0, 0, 0};
//		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
//		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel_3 = new JLabel("Alumno no seleccionado");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.weightx = 1.0;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Alumno seleccionado");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.weightx = 1.0;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_2.add(lblNewLabel_4, gbc_lblNewLabel_4);

		jlistEstudiantesIzq = new JList(this.getDefaultListModelIzq());
		this.jlistEstudiantesIzq.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPane = new JScrollPane(jlistEstudiantesIzq);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_2.add(scrollPane, gbc_scrollPane);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 192, 162));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.weightx = 1.0;
		gbc_panel_4.weighty = 1.0;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
//		gbl_panel_4.columnWidths = new int[]{0, 0, 0};
//		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0};
//		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
//		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);

		JButton btnTodosIzq = new JButton("<<");
		btnTodosIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todoIzq();
			}
		});
		GridBagConstraints gbc_btnTodosIzq = new GridBagConstraints();
		gbc_btnTodosIzq.insets = new Insets(0, 0, 5, 0);
		gbc_btnTodosIzq.gridx = 0;
		gbc_btnTodosIzq.gridy = 0;
		panel_4.add(btnTodosIzq, gbc_btnTodosIzq);

		JButton btnIzq = new JButton("<");
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unoIzquierda();
			}
		});
		GridBagConstraints gbc_btnIzq = new GridBagConstraints();
		gbc_btnIzq.insets = new Insets(0, 0, 5, 0);
		gbc_btnIzq.gridx = 0;
		gbc_btnIzq.gridy = 1;
		panel_4.add(btnIzq, gbc_btnIzq);

		JButton btnDer = new JButton(">");
		btnDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unoDerecha();
			}
		});
		GridBagConstraints gbc_btnDer = new GridBagConstraints();
		gbc_btnDer.insets = new Insets(0, 0, 5, 0);
		gbc_btnDer.gridx = 0;
		gbc_btnDer.gridy = 2;
		panel_4.add(btnDer, gbc_btnDer);

		JButton btnTodosDer = new JButton(">>");
		btnTodosDer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				todoDerecha();
			}
		});
		GridBagConstraints gbc_btnTodosDer = new GridBagConstraints();
		gbc_btnTodosDer.gridx = 0;
		gbc_btnTodosDer.gridy = 3;
		panel_4.add(btnTodosDer, gbc_btnTodosDer);

		jlistEstudiantesDer = new JList(this.getDefaultListModelDer());
		this.jlistEstudiantesDer.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		JScrollPane scrollPane_1 = new JScrollPane(jlistEstudiantesDer);
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 2;
		gbc_scrollPane_1.gridy = 1;
		panel_2.add(scrollPane_1, gbc_scrollPane_1);

		JButton btnGuardar = new JButton("Guardar las notas de todos los alumnos seleccionados");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 1;
		panel_1.add(btnGuardar, gbc_btnGuardar);

		cargarJcb();
	}

	private static void cargarJcb() {
		try {
			jcbMateria.removeAllItems();
			jcbProfesor.removeAllItems();
			jcbNota.removeAllItems();
		} catch (Exception e) {
		}
		for (Materia o : MateriaController.findAll()) {
			jcbMateria.addItem(o);
		}

		for (Profesor o : ProfesorController.findAll()) {
			jcbProfesor.addItem(o);
		}

		for (int i = 0; i <= 10; i++) {
			jcbNota.addItem(i);
		}
	}

	/**
	 * M�todo que construye el modelo de JList, a utilizar para agregar y eliminar
	 * provincias
	 */
	private DefaultListModel getDefaultListModelIzq() {
		this.listModelEstudiantesIzq = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantesIzq;
	}

	private DefaultListModel getDefaultListModelDer() {
		this.listModelEstudiantesDer = new DefaultListModel<Estudiante>();
		return this.listModelEstudiantesDer;
	}

	private void llenarListaIzq() {
		listModelEstudiantesIzq.removeAllElements();
		listModelEstudiantesIzq.addAll(estudiantes);
	}

	private void todoDerecha() {
		listModelEstudiantesIzq.removeAllElements();
		listModelEstudiantesDer.removeAllElements();
		listModelEstudiantesDer.addAll(estudiantes);
	}

	private void todoIzq() {
		listModelEstudiantesDer.removeAllElements();
		listModelEstudiantesIzq.removeAllElements();
		listModelEstudiantesIzq.addAll(estudiantes);
	}

	private void unoDerecha() {
		listModelEstudiantesDer.addAll(jlistEstudiantesIzq.getSelectedValuesList());

		for (int i = jlistEstudiantesIzq.getSelectedIndices().length - 1; i >= 0; i--) {
			listModelEstudiantesIzq.removeElementAt(jlistEstudiantesIzq.getSelectedIndices()[i]);
		}

	}

	private void unoIzquierda() {
		listModelEstudiantesIzq.addAll(jlistEstudiantesDer.getSelectedValuesList());

		for (int i = jlistEstudiantesDer.getSelectedIndices().length - 1; i >= 0; i--) {
			listModelEstudiantesDer.removeElementAt(jlistEstudiantesDer.getSelectedIndices()[i]);
		}

	}

	private void guardar() {
		List<Estudiante> l = new ArrayList<Estudiante>();
		for (int i = 0; i < listModelEstudiantesDer.size(); i++) {
			l.add(listModelEstudiantesDer.getElementAt(i));
		}

		int nota = (int) jcbNota.getSelectedItem();
		System.out.println(nota);
		Materia o = (Materia) jcbMateria.getSelectedItem();
		Profesor o1 = (Profesor) jcbProfesor.getSelectedItem();

		for (Estudiante estudiante : l) {
			Valoracionmateria v = ValoracionController.findBySomeId(o.getId(), o1.getId(), estudiante.getId());
			
			if (v != null) {
//				System.out.println("UPDATE");
				v.setValoracion(nota);
				ValoracionController.update(v);
			} else {
//				System.out.println("INSERT");
				v = new Valoracionmateria();
				v.setProfesor(o1);
				v.setMateria(o);
				v.setEstudiante(estudiante);
				v.setValoracion(nota);
				ValoracionController.insert(v);
			}
		}
	}

}
