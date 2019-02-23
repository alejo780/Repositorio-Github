package controlador;
import java.sql.*;

public class Conexion {
    //conexion Local
    public static Connection conectar() {
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/hospital", "root", "");
            return cn;
        } catch (SQLException e) {
            System.out.println("Error en conexion local " + e);
        }
        return (null);
    }
}
