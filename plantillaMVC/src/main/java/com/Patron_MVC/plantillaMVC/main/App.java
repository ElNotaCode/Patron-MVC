package com.Patron_MVC.plantillaMVC.main;

import controlador.ClienteControlador;
import vista.VistaCreate;
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
		
		ClienteControlador controlador = new ClienteControlador(vistaPrincipal,vistaCreate);
		controlador.mostrarVistaPrincipal();
	}
	
}
