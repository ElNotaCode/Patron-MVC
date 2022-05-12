package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VistaPrincipal extends JFrame {

	private JPanel contentPane;
	public JButton btnRead = new JButton("Buscar Cliente");
	public JButton btnCreate = new JButton("Crear Cliente");
	public JButton btnDelete = new JButton("Delete Cliente");
	/**
	 * Create the frame.
	 */
	public VistaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Patrón MVC");
		lblTitulo.setBounds(10, 11, 90, 14);
		contentPane.add(lblTitulo);
		
		btnRead.setBounds(254, 75, 115, 23);
		contentPane.add(btnRead);
		
		btnCreate.setBounds(79, 75, 115, 23);
		contentPane.add(btnCreate);
		
		btnDelete.setBounds(79, 138, 115, 23);
		contentPane.add(btnDelete);
	}
}
