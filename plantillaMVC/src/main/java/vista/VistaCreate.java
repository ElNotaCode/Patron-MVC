package vista;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

//Vital poner el implements ActionListener y darle a implementar metodos si vemos que peta.
public class VistaCreate extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JTextField tfNombre = new JTextField();
	public JTextField tfApellido = new JTextField();
	public JTextField tfDireccion = new JTextField();
	public JTextField tfDni = new JTextField();
	public JTextField tfFecha = new JTextField();
	public JButton btnBack = new JButton("Back");
	public JButton btnInsertar = new JButton("Insertar");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCreate frame = new VistaCreate();
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
	public VistaCreate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 11, 46, 14);
		contentPane.add(lblNombre);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido");
		lblNewLabel_1.setBounds(10, 36, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Dirección");
		lblNewLabel_2.setBounds(10, 61, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("DNI");
		lblNewLabel_3.setBounds(10, 86, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha");
		lblNewLabel_4.setBounds(10, 111, 46, 14);
		contentPane.add(lblNewLabel_4);
		
		tfNombre.setBounds(66, 8, 86, 20);
		contentPane.add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellido.setColumns(10);
		tfApellido.setBounds(66, 33, 86, 20);
		contentPane.add(tfApellido);
		
		tfDireccion.setColumns(10);
		tfDireccion.setBounds(66, 58, 86, 20);
		contentPane.add(tfDireccion);
		
		tfDni.setColumns(10);
		tfDni.setBounds(66, 83, 86, 20);
		contentPane.add(tfDni);
		
		tfFecha.setColumns(10);
		tfFecha.setBounds(66, 108, 86, 20);
		contentPane.add(tfFecha);
		
		
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		
		btnInsertar.setBounds(10, 136, 89, 23);
		contentPane.add(btnInsertar);
		
		limpiar();
		
		//Añadimos los listener a los botones. El this hace referencia al listener implementado en la clase.
		btnBack.addActionListener(this);
		btnInsertar.addActionListener(this);
		
	}
	
	//Metodo limpiar. Se ejecutará al cargar la página.
	private void limpiar() {
		tfNombre.setText("");
		tfApellido.setText("");
		tfDireccion.setText("");
		tfDni.setText("");
		tfFecha.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		//Con el e.getSource() podemos compararlo con el nombre de la variable.
		System.out.println(e.getSource());
		if(e.getSource() == btnInsertar) {
			System.out.println("el e.getSource() es lo mismo que la variable.");
		}
		
	}
	
	

}
