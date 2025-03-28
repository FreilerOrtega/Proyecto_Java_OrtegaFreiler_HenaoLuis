package Modelo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    public static Mascota getPetDates( int id) throws SQLException {
        Mascota pet = new Mascota();

        String sql="select * from Mascota where id=?";

        try(Connection con =Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                pet.setId(rs.getInt(1));
                pet.setNameP(rs.getString(2));
                pet.setSpecies(rs.getString(3));
                pet.setBreed(rs.getString(4));
                pet.setAge(rs.getInt(5));
                pet.setBirth_date(rs.getString(6));
                pet.setGender(rs.getString(7));
                pet.setWeight(rs.getDouble(8));
                pet.setPhoto(rs.getString(9));
                pet.setOwner_id(rs.getInt(10));
                pet.setMicroChip(rs.getString(11));
                pet.setTatto(rs.getString(12));
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busqueda de mascota por id "+e.getMessage());
        }

        return pet;

    }

    public static List<Mascota> viewPetsByOwner(int id) throws SQLException {
        List<Mascota> petsList=new ArrayList<>();

        String sql="select * from Mascota where owner_id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Mascota pet=new Mascota();
                pet.setId(rs.getInt(1));
                pet.setNameP(rs.getString(2));
                pet.setSpecies(rs.getString(3));
                pet.setBreed(rs.getString(4));
                pet.setAge(rs.getInt(5));
                pet.setBirth_date(rs.getString(6));
                pet.setGender(rs.getString(7));
                pet.setWeight(rs.getDouble(8));
                pet.setPhoto(rs.getString(9));
                pet.setOwner_id(rs.getInt(10));
                pet.setMicroChip(rs.getString(11));
                pet.setTatto(rs.getString(12));
                petsList.add(pet);
            }

            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }

        } catch (Exception e) {
            throw new SQLException("Error en la busqueda de mascotas por id"+e.getMessage());
        }
        return petsList;
    }

    public static List<Mascota> viewPetsList() throws SQLException {
        List<Mascota> petsList=new ArrayList<>();

        String sql="select * from Mascota";

        try(Connection con=Conect.getCon();
            PreparedStatement ps = con.prepareStatement(sql);) {
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Mascota pet=new Mascota();
                pet.setId(rs.getInt(1));
                pet.setNameP(rs.getString(2));
                pet.setSpecies(rs.getString(3));
                pet.setBreed(rs.getString(4));
                pet.setAge(rs.getInt(5));
                pet.setBirth_date(rs.getString(6));
                pet.setGender(rs.getString(7));
                pet.setWeight(rs.getDouble(8));
                pet.setPhoto(rs.getString(9));
                pet.setOwner_id(rs.getInt(10));
                pet.setMicroChip(rs.getString(11));
                pet.setTatto(rs.getString(12));
                petsList.add(pet);
            }

            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }

        } catch (Exception e) {
            throw new SQLException("Error en la busqueda de mascotas por id"+e.getMessage());
        }
        return petsList;
    }

    public static void InsertPets(Mascota pet) throws SQLException {
        String sql="INSERT INTO Mascota (nameP, species, breed, age, birth_date, gender, weight, photo, owner_id, microChip, tatto)\n \n" +
                "VALUES (?,?,?,?,?,?,?,?,?,?,?);";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setString(1,pet.getNameP());
            ps.setString(2,pet.getSpecies());
            ps.setString(3,pet.getBreed());
            ps.setInt(4,pet.getAge());
            ps.setString(5,pet.getBirth_date());
            ps.setString(6,pet.getGender());
            ps.setDouble(7,pet.getWeight());
            ps.setString(8,pet.getPhoto());
            int idOwner=pet.getOwner_id();
            if (idOwner==0) {
                ps.setNull(9, Types.INTEGER);
            }
            ps.setString(10,pet.getMicroChip());
            ps.setString(11,pet.getTatto());
            int res=ps.executeUpdate();
            if (res>0){
                JOptionPane.showMessageDialog(null,"Mascota agregada con exito");
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al agregar mascota"+ e.getMessage());
        }
    }

    public static void ModifyPet(Mascota pet) throws SQLException {
        String sql="UPDATE Mascota SET age=?,weight=?,microChip=? WHERE id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,pet.getAge());
            ps.setDouble(2,pet.getWeight());
            ps.setString(3,pet.getMicroChip());
            ps.setInt(4,pet.getId());
            int rs=ps.executeUpdate();
            if (rs>0){
                JOptionPane.showMessageDialog(null,"Mascota actualizada con exito");
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al modificar mascota "+ e.getMessage());
        }
    }

    public static void ModifyOwnerOfPet(int NewIdOWner, int petID) throws SQLException {
        String sql="UPDATE Mascota SET owner_id=? WHERE id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,NewIdOWner);
            ps.setInt(2,petID);
            int rs=ps.executeUpdate();
            if (rs>0){
                JOptionPane.showMessageDialog(null,"Contrato exitoso");
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al modificar mascota "+ e.getMessage());
        }
    }

}
