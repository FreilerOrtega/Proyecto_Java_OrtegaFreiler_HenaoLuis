package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CirugiasDAO {



    public static List<Cirugias> getSurgeriesListByPetID(int id_pet) throws SQLException {
        List<Cirugias> sugeriesList=new ArrayList<>();

        String sql="select * from Cirugias where pet_id=?";

        try(Connection con =Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,id_pet);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Cirugias sugeries= new Cirugias();
                sugeries.setId(rs.getInt(1));
                sugeries.setPetId(rs.getInt(2));
                sugeries.setSurgeryDate(rs.getString(3));
                sugeries.setRecoveryDays(rs.getInt(4));
                sugeries.setRecovery_status(rs.getString(5));
                sugeriesList.add(sugeries);
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busqueda de mascota por id "+e.getMessage());
        }

        return sugeriesList;
    }


    public static List<Cirugias> getsurgeriesByveterinarianId(int id) throws SQLException {
        List<Cirugias> surgeriesList =new ArrayList<>();

        String sql="select * from cirugias where veterinarian_id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Cirugias surgeries =new Cirugias();
                surgeries.setId(rs.getInt(1));
                surgeries.setPetId(rs.getInt(2));
                surgeries.setVeterinarianId(rs.getInt(3));
                surgeries.setSurgeryDate(rs.getString(4));
                surgeries.setRecoveryDays(rs.getInt(5));
                surgeries.setRecovery_status(rs.getString(6));
                surgeriesList.add(surgeries);
            }

        }catch (SQLException e){
            throw new SQLException(("Error en obtener las cirujias por id de veterinario ")+e.getMessage());
        }

        return surgeriesList;
    }

    public static void insertsurgeries(Cirugias cirugias) throws SQLException {

        String sql = "INSERT INTO Cirugias (surgery_date,surgery_date,recovery_days)\n \n" +
                "VALUES(?,?,?)";


        try (Connection con = Conect.getCon();
             PreparedStatement PS = con.prepareStatement(sql)) {
            PS.setString(1, cirugias.getSurgeryDate());
            PS.setString(2, cirugias.getSurgeryDate());
            PS.setString(3, cirugias.getRecovery_status());


            int agg = PS.executeUpdate();
            if (agg > 0) {
                JOptionPane.showMessageDialog(null, "cirugia  agregada con exito");

            }
            try {
                con.close();
            } catch (SQLException i) {
                System.out.println(i.getMessage());
            }
        } catch (SQLException e) {
            throw new SQLException("Error al agregar cirugia" + e.getMessage());
        }
    }
}
