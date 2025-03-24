package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CirujiasDAO {

    public static List<Cirujias> getSurgeriesListByPetID(int id_pet) throws SQLException {
        List<Cirujias> sugeriesList=new ArrayList<>();

        String sql="select * from Cirugias where pet_id=?";

        try(Connection con =Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,id_pet);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Cirujias sugeries= new Cirujias();
                sugeries.setId(rs.getInt(1));
                sugeries.setPetId(rs.getInt(2));
                sugeries.setVeterinarianId(rs.getInt(3));
                sugeries.setSurgeryDate(rs.getString(4));
                sugeries.setRecoveryDays(rs.getInt(5));
                sugeries.setRecovery_status(rs.getString(6));
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
}
