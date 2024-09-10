package pe.edu.vallegrande.sisventas.test;

import pe.edu.vallegrande.sisventas.db.AccesoDB;

import java.sql.Connection;

public class PruebaDB {
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexión ok.");
            cn.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
