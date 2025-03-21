package Modelo;

import java.sql.*;

public class Conect {

    Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/dia_19";
    private static String user = "root";
    private static String password="";

    public static Connection getCon() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println( "connection successful");
        } catch (SQLException e) {
                System.out.println("Error al conectar la base de datos: "+e.getMessage());
        }

        return con;
    }

    public static void main(String[] args) {
        Connection con = getCon();
    }
}
