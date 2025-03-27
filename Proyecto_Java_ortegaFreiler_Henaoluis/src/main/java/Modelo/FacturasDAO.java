package Modelo;

import java.sql.*;

public class FacturasDAO {
    public static int insertFacture(Facturas facture) throws SQLException {
        int idNewFacture=0;

        String sql = "INSERT INTO Facturas (client_id, descriptions, total, date) VALUES (?, ?, ?, ?)";

        try(Connection con=Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1,facture.getClientId());
            ps.setString(2,facture.getDescription());
            ps.setInt(3,facture.getTotal());
            ps.setString(4,facture.getDate());
            int res=ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()){
                idNewFacture=rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new SQLException(e);
        }

        return idNewFacture;
    }
}
