package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.dto.ClienteDto;
import modelo.services.ClienteService;
import vista.VistaCreate;
import vista.VistaDelete;
import vista.VistaPrincipal;

public class ClienteControlador implements ActionListener{
	
	//Se instancian las todas las ventanas, los services y los dto.
	private VistaPrincipal vistaPrincipal;
	private VistaCreate vistaCreate;
	private VistaDelete vistaDelete;
	private ClienteService clienteService = new ClienteService();
	private ClienteDto clienteDto = new ClienteDto ();
	
	public ClienteControlador(VistaPrincipal vistaPrincipal, VistaCreate vistaCreate,VistaDelete vistaDelete) {

		this.vistaPrincipal = vistaPrincipal;
		this.vistaCreate = vistaCreate;
		this.vistaDelete = vistaDelete;
		//Añadimos los listeners a los botones.
		
		//Listeners Vista Principal.
		this.vistaPrincipal.btnCreate.addActionListener(this);
		this.vistaPrincipal.btnRead.addActionListener(this);
		this.vistaPrincipal.btnDelete.addActionListener(this);
		
		//Listeners Vista Create.
		this.vistaCreate.btnBack.addActionListener(this);
		this.vistaCreate.btnInsertar.addActionListener(this);
		
		//Listeners Vista Delete.
		this.vistaDelete.btnBack.addActionListener(this);
		this.vistaDelete.btnBorrar.addActionListener(this);
	}

	//Hacer visibles las vistas.
	public void mostrarVistaPrincipal() {
		vistaPrincipal.setVisible(true);
		vistaCreate.setVisible(false);
		vistaDelete.setVisible(false);
	}
	
	public void mostrarVistaCreate() {
		vistaPrincipal.setVisible(false);
		vistaCreate.setVisible(true);
		vistaDelete.setVisible(false);
	}

	public void mostrarVistaDelete() {
		vistaPrincipal.setVisible(false);
		vistaCreate.setVisible(false);
		vistaDelete.setVisible(true);
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
		
		if(e.getSource() == vistaPrincipal.btnDelete) {
			System.out.println("Delete pulsado.");
			mostrarVistaDelete();
		}
		
		//BOTON READ
		if(e.getSource() == vistaPrincipal.btnRead) {
			System.out.println("Read pulsado.");
		}
		
		//BOTON BACK
		if(e.getSource() == vistaCreate.btnBack || e.getSource() == vistaDelete.btnBack) {
			System.out.println("Back pulsado.");
			mostrarVistaPrincipal();
		}
		
		//BOTON INSERTAR
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
		
		//BOTON BORRAR
		if(e.getSource() == vistaDelete.btnBorrar) {
			System.out.println("Borrar pulsado.");
			clienteDto.setId(Integer.parseInt(vistaDelete.tfId.getText()));
			
			clienteService.validarDelete(clienteDto);
			
			borrarCamposTextoVistaDelete();
			
		}
		
	}
	
	public void borrarCamposTextoVistaCreate() {
		vistaCreate.tfNombre.setText("");
		vistaCreate.tfApellido.setText("");
		vistaCreate.tfDireccion.setText("");
		vistaCreate.tfDni.setText(null);
		vistaCreate.tfFecha.setText("");
	}
	
	public void borrarCamposTextoVistaDelete() {
		vistaDelete.tfId.setText(null);
	}
	
}
