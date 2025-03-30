package Modelo;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class    CitaDAO {


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

    public static void InsertAppointments(Cita appointment) throws SQLException {
        String sql="INSERT INTO cita (pet_id, owner_id, dates, veterinarian_id, attendance, status, hours)\n \n" +
                "VALUES (?,?,?,?,?,?,?);";

        try(Connection con= Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)){
            ps.setInt(1,appointment.getPet_id());
            ps.setInt(2,appointment.getOwner_id());
            ps.setString(3,appointment.getDates());
            ps.setInt(4,appointment.getVeterinarian_id());
            ps.setBoolean(5,appointment.isAttendance());
            ps.setString(6,appointment.getStatus());
            ps.setString(7,appointment.getHours());
            int res=ps.executeUpdate();
            if (res>0){
                JOptionPane.showMessageDialog(null,"Cita agregada con exito");
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al agregar cita "+ e.getMessage());
        }
    }

    public static List<Cita> getAllAppointments() throws SQLException {

        List<Cita> appointmentsList=new ArrayList<>();

        String sql="SELECT * FROM cita ORDER BY id DESC";
        try(Connection con=Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
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
                appointment.setHours(rs.getString(10));
                appointmentsList.add(appointment);
            }

        } catch (SQLException e) {
            throw new SQLException("Error al obtener citas "+e.getMessage());
        }
        return appointmentsList;
    }

    public static void changeStatus(String newStatus,int appointmentID) throws SQLException {
        String sql="UPDATE cita set status=? where id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setString(1,newStatus);
            ps.setInt(2,appointmentID);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"Estado de cita actualizado con exito");
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar estado de una cita");
        }
    }
}
