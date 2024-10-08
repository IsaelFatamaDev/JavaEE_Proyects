package edu.pe.vallegrande.carrito.prueba;

import edu.pe.vallegrande.carrito.db.AccesoDB;

import java.sql.SQLException;

public class TestConnection {
    public static void main(String[] args) throws SQLException {
        try {
            AccesoDB.getConnection();
            System.out.println("Conexión exitosa");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
