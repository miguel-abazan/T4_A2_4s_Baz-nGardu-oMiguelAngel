package vista;

import java.awt.*;
import java.awt.event.*;

import java.beans.PropertyVetoException;

import javax.swing.*;

import controlador.AlumnoDAO;
import modelo.Alumno;



public class VI extends JFrame{

	JMenuBar menuBar;
	JMenu menuInicio;
	JMenuItem menuAltas, menuBajas, menuCambios, menuConsultas;
	JInternalFrame IF_Altas, IF_Bajas, IF_Consultas,IF_Cambios;
	
	public VI() {
		
			getContentPane().setLayout(new BorderLayout());
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("Numeros Pseudoaleatorios");
			
			setSize(700, 600);
			setLocationRelativeTo(null);
			setVisible(true);
			getContentPane().setBackground(Color.WHITE);	
		
			menuBar = new JMenuBar();
			menuInicio = new JMenu("ALUMNOS");
			menuAltas = new JMenuItem("ALTAS");
			
			
			menuAltas.setMnemonic(KeyEvent.VK_A);
			menuAltas.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
				menuAltas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Altas.setVisible(true);
					}
				});
			menuInicio.add(menuAltas);	
			
			
			
			menuBajas = new JMenuItem("BAJAS"); 
			menuBajas.setMnemonic(KeyEvent.VK_B);
			menuBajas.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
			menuBajas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Bajas.setVisible(true);
					}
				});
			menuInicio.add(menuBajas);
			
			menuCambios = new JMenuItem("CAMBIOS");
			menuCambios.setMnemonic(KeyEvent.VK_C);
			menuCambios.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
			menuCambios.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						IF_Cambios.setVisible(true);
					}
				});
			
			menuInicio.add(menuCambios);
			
			
			
			menuConsultas = new JMenuItem("CONSULTAS");
			menuConsultas.setMnemonic(KeyEvent.VK_S);
			menuConsultas.setAccelerator(
			KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			menuConsultas.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						menuConsultas.setVisible(true);
					}
				});
			menuInicio.add(menuConsultas);
			
			
			menuBar.add(menuInicio);
			setJMenuBar(menuBar);
			
			JDesktopPane desktopPane = new JDesktopPane();
			
			IF_Altas = new JInternalFrame();
				IF_Altas.getContentPane().setLayout(null);
				IF_Altas.setDefaultCloseOperation(HIDE_ON_CLOSE);
				IF_Altas.setTitle("Altas");
				IF_Altas.setSize(690, 550);
				IF_Altas.setMaximizable(true);
				IF_Altas.setIconifiable(true);
				IF_Altas.setClosable(true);
				IF_Altas.setResizable(true);
				IF_Altas.setLayout(null);
				
				JLabel label_fondo, label_txt, label_numCntrl, label_nombres, label_apPaterno, label_apMaterno, label_semestre, label_carrera; 
				JTextField caja_numCntrl, caja_nombres, caja_apPaterno, caja_apMaterno;
				JComboBox<String> combo_semestre, combo_carrera;
				JButton btn_agregar, btn_borrar,btn_cancelar;
				
				label_txt = new JLabel("ALTAS ALUMNOS");
				label_txt.setFont(new Font("Helvetica", Font.PLAIN, 30));
				label_txt.setForeground(Color.white);
				label_txt.setBounds(60, 0, 684, 60);
				IF_Altas.add(label_txt);
				label_fondo = new JLabel(); 
				label_fondo.setBounds(0, 0, 684, 60); 
				label_fondo.setBackground(Color.green);
				label_fondo.setOpaque(true);
				IF_Altas.add(label_fondo);
				
				label_numCntrl = new JLabel("NUMERO DE CONTROL:");
				label_numCntrl.setBounds(100, 95, 150, 10);
				IF_Altas.add(label_numCntrl);
				caja_numCntrl = new JTextField();
				caja_numCntrl.setBounds(250, 90, 170, 20);
				IF_Altas.add(caja_numCntrl);
				
				label_nombres = new JLabel("NOMBRES:");
				label_nombres.setBounds(100, 120, 150, 10);
				IF_Altas.add(label_nombres);
				caja_nombres = new JTextField();
				caja_nombres.setBounds(170, 115, 250, 20);
				IF_Altas.add(caja_nombres);
				
				label_apPaterno = new JLabel("APELLIDO PATERNO:");
				label_apPaterno.setBounds(100, 155, 150, 10);
				IF_Altas.add(label_apPaterno);
				caja_apPaterno = new JTextField();
				caja_apPaterno.setBounds(250, 150, 170, 20);
				IF_Altas.add(caja_apPaterno);
				
				label_apMaterno = new JLabel("APELLIDO MATERNO:");
				label_apMaterno.setBounds(100, 195, 150, 10);
				IF_Altas.add(label_apMaterno);
				caja_apMaterno = new JTextField();
				caja_apMaterno.setBounds(250, 190, 170, 20);
				IF_Altas.add(caja_apMaterno);
					
				label_semestre = new JLabel("SEMESTRE:");
				label_semestre.setBounds(100, 250, 150, 10);
				IF_Altas.add(label_semestre);
				String [] items = {"Elige Semestre...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
				combo_semestre = new JComboBox<>(items);
				combo_semestre.setBounds(250, 245, 170, 20);
				IF_Altas.add(combo_semestre);
				
				label_carrera = new JLabel("CARRERA:");
				label_carrera.setBounds(100, 280, 150, 10);
				IF_Altas.add(label_carrera);
				String [] items2 = {"Elige Carrera:", "I.S.C", "I.M", "I.I.A", "L.A", "C.P"};
				combo_carrera = new JComboBox<>(items2);
				combo_carrera.setBounds(250, 275, 170, 20);
				IF_Altas.add(combo_carrera);
				
				btn_agregar = new JButton("AGREGAR");
				btn_agregar.setBounds(460, 100, 100, 20);
				IF_Altas.add(btn_agregar);
				btn_agregar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(caja_apMaterno.getText().equals("") || caja_apPaterno.getText().equals("") || caja_nombres.getText().equals("") || caja_numCntrl.getText().equals("") || combo_carrera.getSelectedIndex()==0 || combo_semestre.getSelectedIndex()==0){
							JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);
						}else {
							try {
								boolean resultado = new AlumnoDAO().agregarAlumno(new Alumno(caja_numCntrl.getText(), 
								caja_nombres.getText(), caja_apPaterno.getText(), caja_apMaterno.getText(), 
								Byte.parseByte("20"), combo_semestre.getSelectedIndex(), String.valueOf(combo_carrera.getSelectedIndex())));
								JOptionPane.showMessageDialog(getParent(), "SE REGISTRO CORRECTAMENTE");
							} catch (Exception e) {
							JOptionPane.showMessageDialog(getParent(), "LLENE LOS DATOS", "AVISO", JOptionPane.ERROR_MESSAGE);
							}
						}
					}
				}); //ACTION LISTENER AGREGAR
				btn_borrar = new JButton("BORRAR");
				btn_borrar.setBounds(460, 170, 100, 20);
				IF_Altas.add(btn_borrar);
				btn_borrar.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						caja_numCntrl.setText("");
						caja_nombres.setText("");
						caja_apPaterno.setText("");
						caja_apMaterno.setText("");
						combo_carrera.setSelectedIndex(0);
						combo_semestre.setSelectedIndex(0);
					}
				});//ACTION LISTENER BORRAR
				btn_cancelar = new JButton("CANCELAR");
				btn_cancelar.setBounds(460, 240, 100, 20);
				IF_Altas.add(btn_cancelar);
			desktopPane.add(IF_Altas); // agregar InternalFrame al DesktopPane
			add(desktopPane, BorderLayout.CENTER); //agreagr desktopPane al JFrame principal
			
// fin Altas
			
			IF_Bajas = new JInternalFrame();
			IF_Bajas.getContentPane().setLayout(null);
			IF_Bajas.setDefaultCloseOperation(HIDE_ON_CLOSE);
			IF_Bajas.setTitle("Altas");
			IF_Bajas.setSize(690, 550);
			IF_Bajas.setMaximizable(true);
			IF_Bajas.setIconifiable(true);
			IF_Bajas.setClosable(true);
			IF_Bajas.setResizable(true);
			IF_Bajas.setLayout(null);
			
			JLabel lblF, lbltxtF,lblnumCrl, lbl_nom, lblpAp, lblApMaterno, lblSemestre, lblCarrera;
			JTextField cajanumCntrl, cajanombre, cajaapPaterno, cajaapMaterno;
			JComboBox<String> combosemestre, combocarrera;
			//JButton btnAgregar, btnBorrar,btnCancelar;
			
			lbltxtF = new JLabel("ALTAS ALUMNOS");
			lbltxtF.setFont(new Font("Helvetica", Font.PLAIN, 30));
			lbltxtF.setForeground(Color.WHITE);
			lbltxtF.setBounds(60, 0, 684, 60);
			IF_Bajas.add(lbltxtF);
			lblF = new JLabel(); 
			lblF.setBounds(0, 0, 684, 60); 
			lblF.setBackground(Color.RED);
			lblF.setOpaque(true);
			IF_Bajas.add(lblF);
			
			lblnumCrl = new JLabel("NUMERO DE CONTROL:");
			lblnumCrl.setBounds(100, 95, 150, 10);
			IF_Bajas.add(lblnumCrl);
			cajanumCntrl = new JTextField();
			cajanumCntrl.setBounds(250, 90, 170, 20);
			IF_Bajas.add(cajanumCntrl);
			
			lbl_nom = new JLabel("NOMBRES:");
			lbl_nom.setBounds(100, 120, 150, 10);
			IF_Bajas.add(lbl_nom);
			cajanombre = new JTextField();
			cajanombre.setBounds(170, 115, 250, 20);
			IF_Bajas.add(cajanombre);
			
			lblpAp = new JLabel("APELLIDO PATERNO:");
			lblpAp.setBounds(100, 155, 150, 10);
			IF_Bajas.add(lblpAp);
			cajaapPaterno = new JTextField();
			cajaapPaterno.setBounds(250, 150, 170, 20);
			IF_Bajas.add(cajaapPaterno);
			
			lblApMaterno = new JLabel("APELLIDO MATERNO:");
			lblApMaterno.setBounds(100, 195, 150, 10);
			IF_Bajas.add(lblApMaterno);
			cajaapMaterno = new JTextField();
			cajaapMaterno.setBounds(250, 190, 170, 20);
			IF_Bajas.add(cajaapMaterno);
				
			lblSemestre = new JLabel("SEMESTRE:");
			lblSemestre.setBounds(100, 250, 150, 10);
			IF_Bajas.add(lblSemestre);
			String [] items1 = {"0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
			combosemestre = new JComboBox<>(items1);
			combosemestre.setBounds(250, 245, 170, 20);
			IF_Bajas.add(combosemestre);
			
			lblCarrera = new JLabel("CARRERA:");
			lblCarrera.setBounds(100, 280, 150, 10);
			IF_Bajas.add(lblCarrera);
			String [] items11 = {"Elige Carrera:", "I.S.C", "I.M", "I.I.A", "L.A", "C.P"};
			combocarrera = new JComboBox<>(items11);
			combocarrera.setBounds(250, 275, 170, 20);
			IF_Bajas.add(combocarrera);
			
			
			
			
			
			
			desktopPane.add(IF_Bajas); // agregar InternalFrame al DesktopPane
			add(desktopPane, BorderLayout.CENTER); //agreagr desktopPane al JFrame principal
			
		/*public void actualizarTablas(JTable table) {
			try {
				String CONTROLADOR_JDBC = "com.mysql.cj.jdbc.Driver";
				String URL_BASEDEDATOS= "jdbc:mysql://localhost:3306/BD_Escuela?useTimezone=true&serverTimezone=UTC";
				String CONSULTA_PREDETERMINADA= "SELECT * FROM Alumno ORDER BY Num_Conmtrol";
				
				ResultSetTableModel modeloTabla= null;
				try {
					modeloTabla = new ResultSetTableModel(CONTROLADOR_JDBC, URL_BASEDEDATOS, CONSULTA_PREDETERMINADA);
				
				} catch (ClassNotFoundException ex) {
					JOptionPane.showMessageDialog(getContentPane(), ex);
				}
				
			tabla.setModel(modeloTabla)
			
			} catch (Exception e) {
				// TODO: handle exception
			}
		}*/
			
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new VI();

			}
		});
		
		
	}

}

