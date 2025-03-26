package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public static int logInConf(Login login) throws SQLException {
        String sql="Select person_id from login where username=? and passwordU=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql);)
        {
            ps.setString(1,login.getUsername());
            ps.setString(2,login.getPassword());

                ResultSet rs=ps.executeQuery();
            if (rs.next()){//si encuentra un login que cumplan con los datos se retorna el id de la persona que tenga ese login
                return rs.getInt(1);
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }

        } catch (SQLException e) {
            throw new SQLException("Error en la confirmacion de login"+e.getMessage());
        }
        return 0;// si no encuentra un login que cumpla con los datos se retorna 0 para darle manejo
    };

    public static void AddLogIn(Login login) throws SQLException {

        String sql="INSERT INTO login (username, passwordU, person_id) VALUES (?,?,?)";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,login.getUsername());
            ps.setString(2,login.getPassword());
            ps.setInt(3,login.getPersonId());
            int res=ps.executeUpdate();
            if (res>0){
                JOptionPane.showMessageDialog(null,"Login agregado con exito");
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al agregar login"+ e.getMessage());
        }
    };

    public static Login searchByPeopleID(int id) throws SQLException {
        Login log=new Login();
        String sql="Select * from login where person_id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql);)
        {
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){//si encuentra un login que cumplan con los datos se retorna el id de la persona que tenga ese login
                log.setId(rs.getInt(1));
                log.setUsername(rs.getString(2));
                log.setPassword(rs.getString(3));
                log.setPersonId(rs.getInt(4));
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }

        } catch (SQLException e) {
            throw new SQLException("Error en la busqueda de login por id de usuario "+e.getMessage());
        }
        return log;
    }

    public static void ModifyLogin(Login login) throws SQLException {

        String sql="UPDATE login SET username=?,passwordU=? where person_id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,login.getUsername());
            ps.setString(2,login.getPassword());
            ps.setInt(3,login.getPersonId());
            int res=ps.executeUpdate();
            if (res>0){
                JOptionPane.showMessageDialog(null,"Login Modificado con exito");
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al agregar login"+ e.getMessage());
        }
    };

}
