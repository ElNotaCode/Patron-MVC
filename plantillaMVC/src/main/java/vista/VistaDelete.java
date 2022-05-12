package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class VistaDelete extends JFrame {

	private JPanel contentPane;
	public JTextField tfId;
	public JButton btnBorrar = new JButton("Borrar");
	public JButton btnBack = new JButton("Back");
	
	/**
	 * Create the frame.
	 */
	public VistaDelete() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("Id de el cliente a borrar:");
		lbl1.setBounds(46, 44, 125, 14);
		contentPane.add(lbl1);

		btnBorrar.setBounds(46, 99, 89, 23);
		contentPane.add(btnBorrar);

		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		tfId = new JTextField();
		tfId.setBounds(49, 68, 86, 20);
		contentPane.add(tfId);
		tfId.setColumns(10);
	}
}
