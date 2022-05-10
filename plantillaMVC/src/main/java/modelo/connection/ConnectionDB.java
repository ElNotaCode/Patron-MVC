package modelo.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//@author Eloi Martorell

public class ConnectionDB {

		private static String ip = "192.168.1.140";
		private static String user = "remote";
		private static String password = "Reus_2022";
		private static Connection conexion = null;
		
		//crear conexion
		public Connection crearConexion() {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexion = DriverManager.getConnection("jdbc:mysql://" + ip + ":3306?useTimezone=true&serverTimezone=UTC", user, password);
				System.out.println("Conexion establecida.");
				return conexion;
			} catch (SQLException |ClassNotFoundException e) {
				System.out.println("No se ha podido conectar.");
				System.out.println(e);
				return null;
			}
			
		}

		//cerrar conexion
		public void closeConnection() {
			try {
				conexion.close();
				System.out.println("Conexión cerrada.");
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Error al cerrar la conexión.");
			}
		}
}
