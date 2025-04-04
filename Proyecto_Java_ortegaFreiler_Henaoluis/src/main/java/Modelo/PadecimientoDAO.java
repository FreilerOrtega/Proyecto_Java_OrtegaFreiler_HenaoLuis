package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PadecimientoDAO {

    public List<Padecimiento> getConditionByPet(int id) throws SQLException {
        List<Padecimiento> conditionList=new ArrayList<>();
        String sql="select * from Padecimientos where pet_id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps = con.prepareStatement(sql);) {
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Padecimiento condition=new Padecimiento();
                condition.setId(rs.getInt(1));
                condition.setPet_id(rs.getInt(2));
                condition.setDetection_date(rs.getString(3));
                condition.setDiagnosis(rs.getString(4));
                conditionList.add(condition);
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }

        } catch (Exception e) {
            throw new SQLException("Error en la busqueda de mascotas por id"+e.getMessage());
        }
        return conditionList;
    }

    public static void insertsuffering(Padecimiento padecimiento) throws SQLException {
        String SQL = "INSERT INTO Padecimientos (pet_id,detection_date,diagnosis) VALUES (?,?,?)";

        try (Connection con = Conect.getCon();
             PreparedStatement PS = con.prepareStatement(SQL);
        ){
            PS.setInt(1,padecimiento.getPet_id());
            PS.setString(2,padecimiento.getDetection_date());
            PS.setString(3,padecimiento.getDiagnosis());
            int res=PS.executeUpdate();
            if (res>0){
                JOptionPane.showMessageDialog(null,"Padecimiento agregado con exito");
            }




        }catch (SQLException ex){
            throw new SQLException("error al insertar padecimiento"+ex.getMessage());
        }


    }
}
