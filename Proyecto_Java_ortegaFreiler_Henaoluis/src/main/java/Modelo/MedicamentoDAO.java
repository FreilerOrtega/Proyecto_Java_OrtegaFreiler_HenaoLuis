package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAO {

    public static Medicamento getMedicineById(int id) throws SQLException {
        Medicamento Medicine = new Medicamento();

        String sql="select * from Medicamento where id=?";

        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();

            if (rs.next()){
                Medicine.setId(rs.getInt(1));
                Medicine.setName(rs.getString(2));
                Medicine.setBatchId(rs.getInt(3));
                Medicine.setManufacturer(rs.getString(4));
                Medicine.setType(rs.getString(5));
                Medicine.setPresentation(rs.getString(6));
                Medicine.setPrice(rs.getInt(7));
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busquedad de medicina por id");
        };
        return Medicine;
    }

    public static List<Medicamento> getMedicineList() throws SQLException {

        List<Medicamento> medicineList=new ArrayList<>();
        String sql="select m.* from Medicamento m INNER JOIN Lote l ON m.batch_id=l.id where l.current_quantity>0";
        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs= ps.executeQuery();

            while (rs.next()){
                Medicamento Medicine = new Medicamento();
                Medicine.setId(rs.getInt(1));
                Medicine.setName(rs.getString(2));
                Medicine.setBatchId(rs.getInt(3));
                Medicine.setManufacturer(rs.getString(4));
                Medicine.setType(rs.getString(5));
                Medicine.setPresentation(rs.getString(6));
                Medicine.setPrice(rs.getInt(7));
                medicineList.add(Medicine);
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busquedad de medicina");
        };
        return medicineList;
    }

}
