package Modelo;
import Modelo.Persona;

import javax.swing.*;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {

    public Persona SearchPeopleById(int id) throws SQLException {
        Persona persona=new Persona();
        String sql="Select * from Persona where id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                persona.setId(rs.getInt(1));
                persona.setFirst_name(rs.getString(2));
                persona.setSecond_name(rs.getString(3));
                persona.setLast_name1(rs.getString(4));
                persona.setLast_name2(rs.getString(5));
                persona.setId_number(rs.getLong(6));
                persona.setAddress(rs.getString(7));
                persona.setPhone(rs.getLong(8));
                persona.setEmail(rs.getString(9));
                persona.setEmergency_contact(rs.getLong(10));
                persona.setPerson_type(rs.getString(11));
            }
            else {
                JOptionPane.showMessageDialog(null,"Persona no encontrada");
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busqueda de persona por id"+ e.getMessage());
        }
        return persona;
    };
}


