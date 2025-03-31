package Modelo;

import vista.AddVaccination;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Historial_vacunasDAO {

    public List<Historial_vacuna> getVaccineHistoryByPet_id(int id) throws SQLException {
        List<Historial_vacuna> listHV=new ArrayList<>();

        String sql="select * from Historial_vacunas where pet_id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();

            while (rs.next()){
                Historial_vacuna HV=new Historial_vacuna();
                HV.setId(rs.getInt(1));
                HV.setPetId(rs.getInt(2));
                HV.setVaccineId(rs.getInt(3));
                HV.setApplicationDate(rs.getString(4));
                HV.setNextDose(rs.getString(5));
                listHV.add(HV);
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busquedad de vacunas por mascota");
        };


        return listHV;
    }
    public static void insertvaccination(Historial_vacuna historialVacuna) throws SQLException {

        String sql = "INSERT INTO Historial_vacunas (vaccine_id,next_dose_date,pet_id,application_date)\n \n" +
                "VALUES(?,?,?,?)";


        try (Connection con = Conect.getCon();
             PreparedStatement PS = con.prepareStatement(sql)) {
            PS.setInt(1,historialVacuna.getVaccineId());
            PS.setString(2,historialVacuna.getNextDose());
            PS.setInt(3,historialVacuna.getPetId());
            PS.setString(4,historialVacuna.getApplicationDate());


            int agg = PS.executeUpdate();
            if (agg > 0) {
                JOptionPane.showMessageDialog(null, "vacunacion   agregada con exito");

            }
            try {
                con.close();
            } catch (SQLException i) {
                System.out.println(i.getMessage());
            }
        } catch (SQLException e) {
            throw new SQLException("Error al agregar vacunacion" + e.getMessage());
        }

    }



}
