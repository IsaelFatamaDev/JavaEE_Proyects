package pe.edu.vallegrande.sisventas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AccesoDB {
    public AccesoDB() {

    }

    public static Connection getConnection() throws SQLException {
        Connection cn = null;
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String database = "VENTAS";
        /*
        String server = "db_Movil_Sur.mssql.somee.com\n";
        String user = "javi_SQLLogin_1";
        String password = "1juuuc7vuf";
         */
        String server = "localhost";
        String user = "sa";
        String password = "isaelfatama24";
        String url = "jdbc:sqlserver://" + server + ";databaseName=" + database + ";encrypt=true;trustServerCertificate=true;loginTimeout=30;";

        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
            cn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver de la base de datos.");
        } catch (Exception e) {
            throw new SQLException("No se puede establecer la conexion con la BD.");
        }
        return cn;
    }
}