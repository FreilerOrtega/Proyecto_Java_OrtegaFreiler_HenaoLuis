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
        String sql="Select * from Persona where id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if (rs.next()){
                persona.setNombre1(rs.getString(2));
                persona.setNombre2(rs.getString(3));
                persona.setApellido1(rs.getString(4));
                persona.setApellido2(rs.getString(5));
                persona.setNum_identificacion(rs.getLong(6));
                persona.setDireccion(rs.getString(7));
                persona.setTelefono(rs.getLong(8));
                persona.setCorreo(rs.getString(9));
                persona.setContacto_emergencia(rs.getLong(10));
                persona.setTipo(rs.getString(11));
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


