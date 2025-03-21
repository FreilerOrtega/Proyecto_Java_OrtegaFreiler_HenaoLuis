package Modelo;

import java.sql.*;

public class Conect {

    Connection con = null;
    private static String url = "jdbc:mysql://localhost:3306/trabajo";
    private static String user = "root";
    private static String password="campus2023";

    public static Connection getCon() {
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println( "connection successful");
        } catch (SQLException e) {
                System.out.println(e);
        }

        return con;
    }

    public static void main(String[] args) {
        Connection con = getCon();
    }
}
