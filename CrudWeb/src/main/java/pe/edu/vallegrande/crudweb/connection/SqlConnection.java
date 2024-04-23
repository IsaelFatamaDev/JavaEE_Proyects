package pe.edu.vallegrande.crudweb.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection {
	public static void main(String[] args) {
		String url = "jdbc:sqlserver://localhost:1433;database=CRUD;" +
				   "user=SA;password=SQL#1234;" +
				   "encrypt=true;" +
				   "trustServerCertificate=true;" +
				   "loginTimeout=30;";


		try (Connection connection = DriverManager.getConnection(url)) {
			System.out.println("Conexion Exitosa");
		} catch (SQLException e) {
			System.out.println("Error al conectar: " + e.getMessage());
		}

	}
}
