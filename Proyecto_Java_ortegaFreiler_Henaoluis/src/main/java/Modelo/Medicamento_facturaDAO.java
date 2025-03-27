package Modelo;

import java.sql.*;

public class Medicamento_facturaDAO {

    public static void InsertMF(Medicamento_factura mf) throws SQLException {
        String sql="INSERT INTO medicamento_factura (invoice_id, medicine_id, quantity) VALUES (?, ?, ?);";
        try(Connection con=Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1,mf.getInvoice_id());
            ps.setInt(2,mf.getMedicationId());
            ps.setInt(3,mf.getQuantity());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

}
