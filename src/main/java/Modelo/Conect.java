package Modelo;

import java.sql.*;

public class Conect {

    Connection con = null;
    private static String url = "jdbc:mysql://b9ukenypawjyakayyu3r-mysql.services.clever-cloud.com:3306/b9ukenypawjyakayyu3r";
    private static String user = "uxjqgjaen33op09b";
    private static String password="gX2pupB6Gb96kwt1e0ef";

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
