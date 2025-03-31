package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesparacitacionesDAO {

    // Obtener todas las desparacitaciones para una mascota (pet_id)
    public List<Desparacitaciones> getDewormingsByPetId(int id) throws SQLException {
        List<Desparacitaciones> dewormingList = new ArrayList<>();

        String sql = "SELECT * FROM Desparacitaciones WHERE pet_id = ?";

        try (Connection con = Conect.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Desparacitaciones deworming = new Desparacitaciones();
                deworming.setId(rs.getInt(1));
                deworming.setType(rs.getString(2));
                deworming.setApplicationDate(rs.getString(3));
                deworming.setNextApplication(rs.getString(4));
                deworming.setMedicine_id(rs.getInt(5));
                deworming.setPetId(rs.getInt(6));
                deworming.setVeterinarianId(rs.getInt(7));
                dewormingList.add(deworming);
            }
        } catch (SQLException e) {
            throw new SQLException("Error al obtener las desparacitaciones para la mascota con id " + id, e);
        }

        return dewormingList;
    }


    public static void insertDeworning(Desparacitaciones desparacitaciones) throws SQLException {
        String sql = "INSERT INTO Desparacitaciones (medicine_id, next_deworming_date, pet_id, veterinarian_id,application_date,typeD) VALUES (?, ?, ?, ?,?,?)";

        try (Connection con = Conect.getCon(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, desparacitaciones.getMedicine_id());
            ps.setString(2, desparacitaciones.getNextApplication());
            ps.setInt(3, desparacitaciones.getPetId());
            ps.setInt(4, desparacitaciones.getVeterinarianId());
            ps.setString(5,desparacitaciones.getApplicationDate());
            ps.setString(6, desparacitaciones.getType());


            int agg = ps.executeUpdate();
            if (agg > 0) {
                JOptionPane.showMessageDialog(null, "Desparacitación agregada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al agregar desparacitación.");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al agregar desparacitación: " + e.getMessage(), e);
        }
    }
}
