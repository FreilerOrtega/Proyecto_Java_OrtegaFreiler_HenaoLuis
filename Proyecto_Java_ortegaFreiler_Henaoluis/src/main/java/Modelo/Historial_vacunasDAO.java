package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

}
