package com.Patron_MVC.plantillaMVC.main;

import java.awt.EventQueue;

import vista.VistaPrincipal;

/**
 * Hello world!
 *
 */
public class App 
{

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPrincipal frame = new VistaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
