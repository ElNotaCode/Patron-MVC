package controlador;

import modelo.dto.ClienteDto;
import modelo.services.ClienteService;
import vista.VistaCreate;
import vista.VistaPrincipal;

public class ClienteControlador {
	
	//Se instancian las todas las ventanas y los services.
	private VistaPrincipal vistaPrincipal;
	private VistaCreate vistaCreate;
	private ClienteService clienteService;
	
	public VistaPrincipal getVistaPrincipal() {
		return vistaPrincipal;
	}
	
	public void setVistaPrincipal(VistaPrincipal vistaPrincipal) {
		this.vistaPrincipal = vistaPrincipal;
	}
	
	public VistaCreate getVisteCreate() {
		return vistaCreate;
	}
	
	public void setVisteCreate(VistaCreate visteCreate) {
		this.vistaCreate = visteCreate;
	}
	
	public ClienteService getClienteService() {
		return clienteService;
	}
	
	public void setClienteService(ClienteService clienteService) {
		this.clienteService = clienteService;
	}
	
	//Hacer visibles las vistas.
	public void mostrarVistaCreate() {
		vistaCreate.setVisible(true);
	}

	//Llamada a los metodos CRUD de la capa service para validar los datos de las vistas.
	//Pasamos por parametro el DTO.
	public void createCliente(ClienteDto clienteDto) {
		clienteService.validarCreate(clienteDto);
	}
	
}
