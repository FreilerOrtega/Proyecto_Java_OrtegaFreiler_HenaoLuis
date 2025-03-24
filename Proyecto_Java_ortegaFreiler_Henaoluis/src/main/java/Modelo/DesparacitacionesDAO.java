package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DesparacitacionesDAO {
    public List<Desparacitaciones> getDewormingsBypetId(int id) throws SQLException {
        List<Desparacitaciones> dewormingList=new ArrayList<>();

        String sql="select * from Desparacitaciones where pet_id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();

            while (rs.next()){
                Desparacitaciones Deworming=new Desparacitaciones();
                Deworming.setId(rs.getInt(1));
                Deworming.setType(rs.getString(2));
                Deworming.setApplicationDate(rs.getString(3));
                Deworming.setNextApplication(rs.getString(4));
                Deworming.setDoctorId(rs.getInt(5));
                Deworming.setPetId(rs.getInt(6));
                Deworming.setVeterinarianId(rs.getInt(7));
                dewormingList.add(Deworming);
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busquedad de vacunas por mascota");
        };

        return dewormingList;
    }
}
