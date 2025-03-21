package Modelo;
import Modelo.Persona;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class personaDAO {

    public Persona SearchPeopleById(int id) throws SQLException {
        Persona persona=new Persona();
        String sql="Select * from persona where id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                persona.setNombre1(rs.getString(1));
                persona.setNombre2(rs.getString(2));
                persona.setApellido1(rs.getString(3));
                persona.setApellido2(rs.getString(4));
                persona.setNum_identificacion(rs.getInt(5));
                persona.setDireccion(rs.getString(6));
                persona.setTelefono(rs.getInt(7));
                persona.setCorreo(rs.getString(8));
                persona.setContacto_emergencia(rs.getInt(9));
                persona.setTipo(rs.getString(10));
            }
            else {
                JOptionPane.showMessageDialog(null,"Persona no encontrada");
            }

        }catch (SQLException e){
            throw new SQLException("Error en la busqueda de persona por id"+ e.getMessage());
        }
        return persona;
    };
}


