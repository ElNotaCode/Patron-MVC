package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import modelo.dto.ClienteDto;
import modelo.services.ClienteService;
import vista.VistaCreate;
import vista.VistaPrincipal;

public class ClienteControlador implements ActionListener{
	
	//Se instancian las todas las ventanas, los services y los dto.
	private VistaPrincipal vistaPrincipal;
	private VistaCreate vistaCreate;
	private ClienteService clienteService;
	private ClienteDto clienteDto;
	
	public ClienteControlador(VistaPrincipal vistaPrincipal, VistaCreate vistaCreate) {
		super();
		this.vistaPrincipal = vistaPrincipal;
		this.vistaCreate = vistaCreate;
		//Añadimos los listeners a los botones.
		//Listeners Vista Principal.
		this.vistaPrincipal.btnCreate.addActionListener(this);
		this.vistaPrincipal.btnRead.addActionListener(this);
		//Listeners Vista Create.
		this.vistaCreate.btnBack.addActionListener(this);
		this.vistaCreate.btnInsertar.addActionListener(this);
		
	}

	//Hacer visibles las vistas.
	public void mostrarVistaCreate() {
		vistaCreate.setVisible(true);
		vistaPrincipal.setVisible(false);
	}
	
	public void mostrarVistaPrincipal() {
		vistaPrincipal.setVisible(true);
		vistaCreate.setVisible(false);
	}

	//Llamada a los metodos CRUD de la capa service para validar los datos de las vistas.
	//Pasamos por parametro el DTO.
	public void createCliente(ClienteDto clienteDto) {
		clienteService.validarCreate(clienteDto);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Implementar todos los botones.
		// BOTON CREATE
		if(e.getSource() == vistaPrincipal.btnCreate) {
			System.out.println("Create pulsado.");
			mostrarVistaCreate();
		}
		
		//BOTON READ
		if(e.getSource() == vistaPrincipal.btnRead) {
			System.out.println("Read pulsado.");
		}
		
		if(e.getSource() == vistaCreate.btnBack) {
			System.out.println("Back pulsado.");
			mostrarVistaPrincipal();
		}
		
		if(e.getSource() == vistaCreate.btnInsertar) {
			//Seteamos en el DTO los datos de los campos.
			clienteDto.setNombre(vistaCreate.tfNombre.getText());
			clienteDto.setApellido(vistaCreate.tfApellido.getText());
			clienteDto.setDireccion(vistaCreate.tfDireccion.getText());
			clienteDto.setDni(Integer.parseInt(vistaCreate.tfDni.getText()));
			clienteDto.setFecha(vistaCreate.tfFecha.getText());
			//Enviamos a Service.
			clienteService.validarCreate(clienteDto);
			//Borramos los campos.
			borrarCamposTextoVistaCreate();
		}
		
	}
	
	public void borrarCamposTextoVistaCreate() {
		vistaCreate.tfNombre.setText("");
		vistaCreate.tfApellido.setText("");
		vistaCreate.tfDireccion.setText("");
		vistaCreate.tfDni.setText("");
		vistaCreate.tfFecha.setText("");
	}
	
}
