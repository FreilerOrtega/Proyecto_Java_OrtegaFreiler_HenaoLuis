package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoteDAO {

    public static List<Lote> getBatchList() throws SQLException {

        List<Lote> batchList=new ArrayList<>();
        String sql="select l.* from Medicamento m INNER JOIN Lote l ON m.batch_id=l.id where l.current_quantity>0";
        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs= ps.executeQuery();

            while (rs.next()){
                Lote batch = new Lote();
                batch.setId(rs.getInt(1));
                batch.setEntryDate(rs.getString(2));
                batch.setEntryQuantity(rs.getInt(3));
                batch.setCurrentQuantity(rs.getInt(4));
                batch.setExpirationDate(rs.getString(5));
                batchList.add(batch);
            }
        }catch (SQLException e){
            throw new SQLException("Error en la busquedad de Lotes ");
        };
        return batchList;
    }


    public static Lote getBatchByID(int id) throws SQLException {

        Lote batch = new Lote();
        String sql="select * from Lote where id=?";
        try(Connection con= Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();

            if (rs.next()){

                batch.setId(rs.getInt(1));
                batch.setEntryDate(rs.getString(2));
                batch.setEntryQuantity(rs.getInt(3));
                batch.setCurrentQuantity(rs.getInt(4));
                batch.setExpirationDate(rs.getString(5));

            }
        }catch (SQLException e){
            throw new SQLException("Error en la busquedad de Lote por id ");
        };
        return batch;
    }

    public static void subtractMedicine(int idMedicine,int quantitySubstract) throws SQLException {

        Medicamento medicine=MedicamentoDAO.getMedicineById(idMedicine);
        Lote lote=LoteDAO.getBatchByID(medicine.getBatchId());
        String sql="UPDATE Lote SET current_quantity=? WHERE id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
            int newQuantity=lote.getCurrentQuantity()-quantitySubstract;
            ps.setInt(1,newQuantity);
            ps.setInt(2,medicine.getBatchId());
            int res= ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar cantidad"+e.getMessage());
        }
    }

}

