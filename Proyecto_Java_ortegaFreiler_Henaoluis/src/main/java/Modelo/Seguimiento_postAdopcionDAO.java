package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Seguimiento_postAdopcionDAO {

    public static void insertContract(Seguimiento_PostAdopcion sp) throws SQLException {
        String sql="INSERT INTO seguimiento_post_adopcion VALUES (?,?,?,?)";
        try(Connection con=Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,sp.getAppointment_number());
            ps.setInt(2,sp.getContractId());
            ps.setString(3,sp.getDetails());
            ps.setString(4,sp.getDate());
            int res=ps.executeUpdate();
            if (res>0){
                JOptionPane.showMessageDialog(null,"Cita agregada con exito");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al generar una cita post adopcion"+e.getMessage());
        }
    }

    public static List<Seguimiento_PostAdopcion> getAllFollowUps() throws SQLException {
        List<Seguimiento_PostAdopcion> SPAList=new ArrayList<>();

        String sql="Select * from seguimiento_post_adopcion";

        try(Connection con =Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Seguimiento_PostAdopcion sp=new Seguimiento_PostAdopcion();
                sp.setAppointment_number(rs.getInt(1));
                sp.setContractId(rs.getInt(2));
                sp.setDetails(rs.getString(3));
                sp.setDate(rs.getString(4));
                SPAList.add(sp);
            }
        }catch (SQLException e){
            throw new SQLException("Error al obtener la lista de seguimientos "+e.getMessage());
        }

        return SPAList;
    }

}
