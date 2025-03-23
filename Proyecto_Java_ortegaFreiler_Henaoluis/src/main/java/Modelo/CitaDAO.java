package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {


    public int viewOwnerAppointments(Persona persona) throws SQLException {
        int countAppointments=0;

        String sql="select count(*) from cita where owner_id=?;";
        try(Connection con = Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,persona.getId());
            ResultSet rs= ps.executeQuery();
            if (rs.next()){
                countAppointments= rs.getInt(1);
            }else throw new SQLException("No se encontro citas con ese id de persona");

        } catch (Exception e) {
            throw new SQLException("Error en la busqueda de cantidad de citas por persona"+e.getMessage());
        }
        return countAppointments;
    }
    public List<Cita> viewPetsAppointments(int id){
        List<Cita> appointmentsList=new ArrayList<>();


        String sql="select * from cita where pet_id=?;";
        try(Connection con = Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Cita appointment=new Cita();
                appointment.setId(rs.getInt(1));
                appointment.setPet_id(rs.getInt(2));
                appointment.setOwner_id(rs.getInt(3));
                appointment.setDates(rs.getString(4));
                appointment.setConsultation_reason(rs.getString(5));
                appointment.setVeterinarian_id(rs.getInt(6));
                appointment.setDiagnosis(rs.getString(7));
                appointment.setAttendance(rs.getBoolean(8));
                appointment.setStatus(rs.getString(9));
                appointmentsList.add(appointment);
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return appointmentsList;
    }
}
