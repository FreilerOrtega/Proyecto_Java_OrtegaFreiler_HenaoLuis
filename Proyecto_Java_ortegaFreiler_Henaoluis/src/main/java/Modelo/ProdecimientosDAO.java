package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdecimientosDAO {

    public static List<Procedimientos> getProceduresByPetId(int id) throws SQLException {
        List<Procedimientos> proceduresList=new ArrayList<>();

        String sql="select * from Procedimiento where pet_id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Procedimientos procedure=new Procedimientos();
                procedure.setId(rs.getInt(1));
                procedure.setPet_id(rs.getInt(2));
                procedure.setProcedurer(rs.getString(3));
                procedure.setDates(rs.getString(4));
                procedure.setVeterinarian_id(rs.getInt(5));
                procedure.setAppointment_id(rs.getInt(6));
                proceduresList.add(procedure);
            }

        }catch (SQLException e){
            throw new SQLException(("Error en la obtencion de procedimientos por id de mascota")+e.getMessage());
        }

        return proceduresList;
    }

    public static List<Procedimientos> getProceduresByveterinarianId(int id) throws SQLException {
        List<Procedimientos> proceduresList=new ArrayList<>();

        String sql="select * from Procedimiento where veterinarian_id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Procedimientos procedure=new Procedimientos();
                procedure.setId(rs.getInt(1));
                procedure.setPet_id(rs.getInt(2));
                procedure.setProcedurer(rs.getString(3));
                procedure.setDates(rs.getString(4));
                procedure.setVeterinarian_id(rs.getInt(5));
                procedure.setAppointment_id(rs.getInt(6));
                proceduresList.add(procedure);
            }

        }catch (SQLException e){
            throw new SQLException(("Error en la obtencion de procedimientos por id de veterinario ")+e.getMessage());
        }

        return proceduresList;
    }

    public static void insertProcedure(Procedimientos procedimientos) throws SQLException {

        String sql = "INSERT INTO Procedimiento (pet_id, procedurer, dates, veterinarian_id, appointment_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = Conect.getCon();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, procedimientos.getPet_id());
            ps.setString(2, procedimientos.getProcedurer());
            ps.setString(3, procedimientos.getDates());
            ps.setInt(4, procedimientos.getVeterinarian_id());
            ps.setInt(5, procedimientos.getAppointment_id());

            int agg = ps.executeUpdate();
            if (agg > 0) {
                JOptionPane.showMessageDialog(null, "Procedimiento agregado con éxito");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al agregar procedimiento: " + e.getMessage());
        }
    }





}



