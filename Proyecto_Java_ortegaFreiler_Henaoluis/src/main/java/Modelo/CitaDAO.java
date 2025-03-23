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
                appointment.setId_mascota(rs.getInt(2));
                appointment.setId_veterinaro(rs.getInt(3));
                appointment.setFecha(rs.getString(4));
                appointment.setMotivo_consulta(rs.getString(5));
                appointment.setId_veterinaro(rs.getInt(6));
                appointment.setDiagnostico(rs.getString(7));
                appointment.setAsistencia(rs.getBoolean(8));
                appointment.setEstado(rs.getString(9));
                appointmentsList.add(appointment);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return appointmentsList;
    }
}
