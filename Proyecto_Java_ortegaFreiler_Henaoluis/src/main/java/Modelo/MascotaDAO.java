package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO {

    public Mascota getPetDates( int id) throws SQLException {
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
                pet.setOwner_id(rs.getInt(10));;
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

}
