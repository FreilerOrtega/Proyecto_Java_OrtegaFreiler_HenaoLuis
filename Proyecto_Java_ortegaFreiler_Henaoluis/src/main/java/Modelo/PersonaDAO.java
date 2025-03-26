package Modelo;
import Modelo.Persona;

import javax.swing.*;
import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaDAO {

    public static Persona SearchPeopleById(int id) throws SQLException {
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

    public static List<Persona> getPeopleList() throws SQLException {
        List<Persona> peopleList = new ArrayList<>();
        String sql="Select * from Persona";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Persona persona=new Persona();
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
                peopleList.add(persona);
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busqueda de persona por id"+ e.getMessage());
        }
        return peopleList;
    };

    public static int AddPeople(Persona people) throws SQLException {
        String sql="INSERT INTO Persona (first_name, second_name, last_name1, last_name2, id_number, address, phone, email, emergency_contact, person_type) \n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?);";
        int idGenerate=0;

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,people.getFirst_name());
            ps.setString(2,people.getSecond_name());
            ps.setString(3,people.getLast_name1());
            ps.setString(4,people.getLast_name2());
            ps.setLong(5,people.getId_number());
            ps.setString(6,people.getAddress());
            ps.setLong(7,people.getPhone());
            ps.setString(8,people.getEmail());
            ps.setLong(9,people.getEmergency_contact());
            ps.setString(10,people.getPerson_type());
            int res=ps.executeUpdate();
            if (res>0){
                ResultSet rs=ps.getGeneratedKeys();
                if (rs.next()){
                    idGenerate=rs.getInt(1);
                }
                JOptionPane.showMessageDialog(null,"Persona agregada con exito");
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al agregar persona"+ e.getMessage());
        }
        return idGenerate;
    };

    public static int ModifyPeople(Persona people) throws SQLException {
        String sql="UPDATE Persona SET address=?,phone=?,email=?,emergency_contact=? WHERE id=?";
        int idGenerate=0;

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1,people.getAddress());
            ps.setLong(2,people.getPhone());
            ps.setString(3,people.getEmail());
            ps.setLong(4,people.getEmergency_contact());
            ps.setInt(5,people.getId());
            int res=ps.executeUpdate();

            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al agregar persona"+ e.getMessage());
        }
        return idGenerate;
    };
}


