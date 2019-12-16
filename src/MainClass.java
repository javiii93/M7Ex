import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class MainClass extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Alumno> arrAlumno = new ArrayList<>();
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private DefaultListModel<Alumno> modeloA;
	private JList<Alumno> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainClass frame = new MainClass();
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
	public MainClass() {
		generarAlumnos();
		ArrayList<String> cursos = buscarCursos();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 677, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 125, 160, 193);
		contentPane.add(panel);
		panel.setLayout(null);
		modeloA = new DefaultListModel<>();
		list = new JList<>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// list.setBounds(12, 13, 136, 167);
		list.setModel(modeloA);
		// panel.add(list);
		list.setBackground(Color.BLUE);
		list.setForeground(Color.YELLOW);
		JScrollPane scrollPane = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12, 13, 136, 167);
		panel.add(scrollPane);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(184, 13, 447, 237);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(0, 28, 165, 24);
		panel_1.add(lblNewLabel);

		JLabel lblPrimerApellido = new JLabel("Primer apellido:");
		lblPrimerApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrimerApellido.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		lblPrimerApellido.setBounds(0, 66, 165, 24);
		panel_1.add(lblPrimerApellido);

		JLabel lblSegundoApellido = new JLabel("Segundo apellido:");
		lblSegundoApellido.setHorizontalAlignment(SwingConstants.LEFT);
		lblSegundoApellido.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		lblSegundoApellido.setBounds(0, 103, 165, 24);
		panel_1.add(lblSegundoApellido);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setFont(new Font("Segoe UI Emoji", Font.BOLD, 13));
		lblTelefono.setBounds(0, 139, 165, 24);
		panel_1.add(lblTelefono);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		textField.setBounds(177, 29, 258, 24);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(177, 66, 258, 24);
		panel_1.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		textField_2.setColumns(10);
		textField_2.setBounds(177, 103, 258, 24);
		panel_1.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.LEFT);
		textField_3.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 13));
		textField_3.setColumns(10);
		textField_3.setBounds(177, 140, 258, 24);
		panel_1.add(textField_3);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 13, 160, 115);
		// Sin tiempo para poder cambiar el layout del panel_2 para visualizar los
		// botones bien

		// JScrollPane scrollPane2 = new JScrollPane(panel_2);
		// scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// scrollPane2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		// scrollPane2.setBounds(12, 13, 160, 115);
		// contentPane.add(scrollPane2);
		contentPane.add(panel_2);
		panel_2.setBackground(Color.BLUE);
		panel.setBackground(Color.BLUE);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		for (int i = 0; i < cursos.size(); i++) {
			JButton b1 = new JButton(cursos.get(i));
			panel_2.add(b1);
			b1.addActionListener(this);
			// System.out.println(cursos.get(i));
		}
		list.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				JList<Alumno> a = (JList<Alumno>) e.getSource();
				Alumno a2 = a.getSelectedValue();
				textField.setText(a2.getNombre());
				textField_1.setText(a2.getApellido1());
				textField_2.setText(a2.getApellido2());
				textField_3.setText(a2.getTelefono());
			}
		});

		/*
		 * JScrollPane scrollPane = new JScrollPane(); scrollPane.setViewportView(list);
		 */

	}

	public ArrayList<String> buscarCursos() {
		ArrayList<String> cursos = new ArrayList<>();
		for (int i = 0; i < arrAlumno.size(); i++) {
			if (cursos.isEmpty()) {
				cursos.add(arrAlumno.get(i).getCurso());
			} else {
				if (!cursos.contains(arrAlumno.get(i).getCurso())) {
					cursos.add(arrAlumno.get(i).getCurso());
				}
			}
		}

		return cursos;
	}

	public void generarAlumnos() {
		Alumno alu3 = new Alumno("ap1_1", "ap2_1", "Nombre1", "456325234", "ASIX");
		Alumno alu4 = new Alumno("ap1_2", "ap2_2", "Nombre2", "356746534", "ASIX");
		Alumno alu1 = new Alumno("ap1_3", "ap2_3", "Nombre3", "789653342", "ASIX");
		Alumno alu2 = new Alumno("ap1_4", "ap2_4", "Nombre4", "337638377", "ASIX");
		arrAlumno.add(alu3);
		arrAlumno.add(alu4);
		arrAlumno.add(alu1);
		arrAlumno.add(alu2);
		Alumno alu2a = new Alumno("ap1_4a", "ap2_4a", "Nombre4a", "337638377a", "ASIX");
		Alumno alu2b = new Alumno("ap1_4b", "ap2_4b", "Nombre4b", "337638377b", "ASIX");
		Alumno alu2c = new Alumno("ap1_4c", "ap2_4c", "Nombre4c", "337638377c", "ASIX");
		Alumno alu2d = new Alumno("ap1_4d", "ap2_4d", "Nombre4d", "337638377d", "ASIX");
		arrAlumno.add(alu2a);
		arrAlumno.add(alu2b);
		arrAlumno.add(alu2c);
		arrAlumno.add(alu2d);

		Alumno alu5 = new Alumno("ap1_5", "ap2_5", "Nombre5", "345627277", "DAM");
		Alumno alu6 = new Alumno("ap1_6", "ap2_6", "Nombre6", "245723672", "DAM");
		Alumno alu7 = new Alumno("ap1_7", "ap2_7", "Nombre7", "845632235", "DAM");
		Alumno alu8 = new Alumno("ap1_8", "ap2_8", "Nombre8", "345648335", "DAM");
		arrAlumno.add(alu5);
		arrAlumno.add(alu6);
		arrAlumno.add(alu7);
		arrAlumno.add(alu8);
		Alumno alu9 = new Alumno("ap1_9", "ap2_9", "Nombre9", "345277376", "DAW");
		Alumno alu10 = new Alumno("ap1_10", "ap2_10", "Nombre10", "2452626226", "DAW");
		Alumno alu11 = new Alumno("ap1_11", "ap2_11", "Nombre11", "262623446", "DAW");
		Alumno alu12 = new Alumno("ap1_12", "ap2_12", "Nombre12", "456346346", "DAW");
		arrAlumno.add(alu9);
		arrAlumno.add(alu10);
		arrAlumno.add(alu11);
		arrAlumno.add(alu12);
		/*
		 * Alumno alu1d2 = new Alumno("ap1_12", "ap2_12", "Nombre12", "456346346",
		 * "DAWds"); arrAlumno.add(alu1d2);
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		System.out.println(b.getText());
		modeloA.clear();
		for (int i = 0; i < arrAlumno.size(); i++) {
			if (b.getText().equalsIgnoreCase(arrAlumno.get(i).getCurso())) {
				modeloA.addElement(arrAlumno.get(i));
			}
		}
		list.setModel(modeloA);
	}
}
