package com.Patron_MVC.plantillaMVC.main;

import controlador.ClienteControlador;
import vista.VistaCreate;
import vista.VistaDelete;
import vista.VistaPrincipal;

/**
 * Hello world!
 *
 */
public class App 
{

	public static void main(String[] args) {

		VistaPrincipal vistaPrincipal = new VistaPrincipal();
		VistaCreate vistaCreate = new VistaCreate();
		VistaDelete vistaDelete = new VistaDelete();
		
		ClienteControlador controlador = new ClienteControlador(vistaPrincipal,vistaCreate,vistaDelete);
		controlador.mostrarVistaPrincipal();
	}
	
}
