package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EstudianteController;
import model.Estudiante;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JSplitPane;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

public class Split extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private static PanelDatosPersonales datosPersonales = new PanelDatosPersonales();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Split frame = new Split();
					frame.setMinimumSize(new Dimension(600, 500));
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
	public Split() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.columnWidths = new int[]{0, 0};
//		gbl_contentPane.rowHeights = new int[]{0, 0};
//		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		GridBagConstraints gbc_splitPane = new GridBagConstraints();
		gbc_splitPane.weighty = 1.0;
		gbc_splitPane.weightx = 1.0;
		gbc_splitPane.fill = GridBagConstraints.BOTH;
		gbc_splitPane.gridx = 0;
		gbc_splitPane.gridy = 0;
		contentPane.add(splitPane, gbc_splitPane);

		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		splitPane.setRightComponent(datosPersonales);
		scrollPane.setMinimumSize(new Dimension(500, 100));

		table = new JTable(DatosDeTabla.getDatosDeTabla(), DatosDeTabla.getTitulosColumnas());
		scrollPane.setViewportView(table);
		
		

		// Accedo a los clics realizados sobre la tabla
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				List<Estudiante> l = EstudianteController.findAll();
				int i = 0;
				for (Estudiante estudiante : l) {
					if (i == table.getSelectedRow()) {
						construirPanel(estudiante);
					}
					i++;
				}
			}
		});
	}

	public static void construirPanel(Estudiante o) {
		datosPersonales.setId(o.getId());
		datosPersonales.setNombre(o.getNombre());
		datosPersonales.setApellido1(o.getApellido1());
		datosPersonales.setApellido2(o.getApellido2());
		datosPersonales.setDni(o.getDni());
		datosPersonales.setDireccion(o.getDireccion());
		datosPersonales.setEmail(o.getEmail());
		datosPersonales.setTelefono(o.getTelefono());
		datosPersonales.setColor(o.getColorPreferido());
	}

}
