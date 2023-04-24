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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaEstudiante extends JFrame {

	private JPanel contentPane;
	private JPanel panelEstudiantes;
	private static JComboBox<Materia> jcbMateria;
	private static JComboBox<Profesor> jcbProfesor;
	private List<EstudiantePanel> vm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEstudiante frame = new VentanaEstudiante();
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
	public VentanaEstudiante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(215, 215, 255));
		panel.setForeground(new Color(128, 128, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weightx = 1.0;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
//		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
//		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
//		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
//		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		jcbMateria = new JComboBox<Materia>();
		jcbMateria.setToolTipText("");
		GridBagConstraints gbc_jcbMateria = new GridBagConstraints();
		gbc_jcbMateria.weightx = 1.0;
		gbc_jcbMateria.insets = new Insets(0, 0, 5, 5);
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

		jcbProfesor = new JComboBox<Profesor>();
		GridBagConstraints gbc_jcbProfesor = new GridBagConstraints();
		gbc_jcbProfesor.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProfesor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProfesor.gridx = 1;
		gbc_jcbProfesor.gridy = 1;
		panel.add(jcbProfesor, gbc_jcbProfesor);

		JButton btnRefrescar = new JButton("Botón refrescar alumnado");
		btnRefrescar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarEstudiantes();
			}
		});
		GridBagConstraints gbc_btnRefrescar = new GridBagConstraints();
		gbc_btnRefrescar.anchor = GridBagConstraints.EAST;
		gbc_btnRefrescar.weightx = 1.0;
		gbc_btnRefrescar.gridx = 2;
		gbc_btnRefrescar.gridy = 2;
		panel.add(btnRefrescar, gbc_btnRefrescar);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.weighty = 1.0;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
//		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
//		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0};
//		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
//		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_2 = new JLabel("Listado estudiantes:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		panelEstudiantes = new JPanel();
		panelEstudiantes.setBackground(new Color(255, 255, 174));
		GridBagConstraints gbc_panelEstudiantes = new GridBagConstraints();
		gbc_panelEstudiantes.weighty = 1.0;
		gbc_panelEstudiantes.insets = new Insets(0, 0, 5, 5);
		gbc_panelEstudiantes.fill = GridBagConstraints.BOTH;
		gbc_panelEstudiantes.gridx = 1;
		gbc_panelEstudiantes.gridy = 1;
		panel_1.add(panelEstudiantes, gbc_panelEstudiantes);

		JButton btnGuardar = new JButton("Guardar las notas del alumnado");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				for (EstudiantePanel estudiantePanel : panelesEstudiantes) {
//					estudiantePanel.guardar();
//					System.out.println(estudiantePanel.toString());
//				}
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 2;
		panel_1.add(btnGuardar, gbc_btnGuardar);

		llenarJcbMateria();
		llenarJcbProfesor();
	}

	/**
	 * 
	 */
	private void llenarJcbMateria() {
		try {
			jcbMateria.removeAllItems();
		} catch (Exception e) {
		}
		for (Materia o : MateriaController.findAll()) {
			jcbMateria.addItem(o);
		}
	}

	/**
	 * 
	 */
	private void llenarJcbProfesor() {
		try {
			jcbProfesor.removeAllItems();
		} catch (Exception e) {
		}
		for (Profesor o : ProfesorController.findAll()) {
			jcbProfesor.addItem(o);
		}
	}

	/**
	 * 
	 */
	private void cargarEstudiantes() {

		this.panelEstudiantes.removeAll();
		vm = new ArrayList<EstudiantePanel>();
		
		List<Estudiante> l = EstudianteController.findAll();
		for (Estudiante estudiante : l) {
			EstudiantePanel nuevoPanel = new EstudiantePanel(estudiante, (Materia) jcbMateria.getSelectedItem(), (Profesor) jcbProfesor.getSelectedItem());
			panelEstudiantes.add(nuevoPanel);
			
			
			vm.add(nuevoPanel);
			System.out.println(vm.toString());
			
			
			this.repaint();
			this.revalidate();
		}
	}

	private void guardarNotas() {
//		for (EstudiantePanel estudiantePanel : panelesEstudiantes) {
////			estudiantePanel.guardar();
//			System.out.println(estudiantePanel.toString());
//		}
	}
}
