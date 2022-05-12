package modelo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.connection.ConnectionDB;
import modelo.dto.ClienteDto;

//Autor: Eloi Martorell

public class ClienteDao {
	
	//CREATE
	//createCliente, le pasamos por parametro un objeto ClienteDto.
	public void createCliente(ClienteDto cliente) {
		
		//Accedemos a la base de datos.
		ConnectionDB conexion = new ConnectionDB();
		
			try {
				
				//Vamos a dejar preparada la consulta.
				String sql = "INSERT INTO cliente(nombre,apellido,direccion,dni,fecha) VALUES"
						+ " (?,?,?,?,?);";
				//Vamos a usar el preparedStatement. Esto nos da pequeña ventaja en la seguridad.
				//Entre otras cosas, nos cubre de una inyeccion SQL.
				PreparedStatement consulta = conexion.crearConexion().prepareStatement(sql);
				
				consulta.setString(1, cliente.getNombre()); //El numero hace referencia al primer interrogante.
				consulta.setString(2, cliente.getApellido());
				consulta.setString(3, cliente.getDireccion());
				consulta.setInt(4, cliente.getDni()); //Con setInt metemos el dni, que es entero.
				consulta.setString(5, cliente.getFecha()); //TODO: Mirar porque falla fecha.
				
				consulta.executeUpdate();
				
				//Cerramos la consulta.
				consulta.close();
				//Cerramos conexion.
				conexion.closeConnection();
				
				//Informamos de que se ha insertado correctamente.
				JOptionPane.showMessageDialog(null, "Se ha creado al cliente.");
				
			} catch (SQLException e) {
				//Pasamos el error por consola.
				System.out.println(e.getMessage());
				// TODO: Informamos de que NO se ha insertado correctamente.
				JOptionPane.showMessageDialog(null, "ERROR! No se ha creado al cliente.");
			}
		
	}
	
	//READ
	
	//UPDATE
	
	//DELETE
	public void deleteCliente(ClienteDto cliente) {
		
		ConnectionDB conexion = new ConnectionDB();
		
		try {
			
			String sql = "DELETE FROM cliente WHERE id = ? ;";
			PreparedStatement consulta = conexion.crearConexion().prepareStatement(sql);
			consulta.setInt(1, cliente.getId());
			consulta.executeUpdate();
			
			consulta.close();
			conexion.closeConnection();
			
			JOptionPane.showMessageDialog(null, "Se ha borrado al cliente.");
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "ERROR! No se ha borrado al cliente.");
		}
		
	}

}
