package modelo.services;

import modelo.dao.ClienteDao;
import modelo.dto.ClienteDto;

public class ClienteService {

	//Aquí va la comprobación.
	//El service es el intermediario entre base de datos, controlador y el modelo.
	
	//Metodo que valida los datos del Create antes de pasarselos al DAO, pasamos
	//por parametro el DTO.
	public void validarCreate(ClienteDto clienteDto) {
		
		//Instanciamos el DAO.
		ClienteDao clienteDao;
		
		//Aquí podríamos poner una condición.
		
		//? ClienteDao clienteDao = new ClienteDao();
		clienteDao = new ClienteDao();
		//Creamos al cliente.
		clienteDao.createCliente(clienteDto);
		
	}
	
	public void validarDelete(ClienteDto clienteDto) {
		
		ClienteDao clienteDao;
		
		clienteDao = new ClienteDao();
		clienteDao.deleteCliente(clienteDto);
		
	}
	
}
