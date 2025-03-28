package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Contractos_AdopcionDAO {
    public static void insertContract(Contractos_Adopcion ca) throws SQLException {

        String sql="INSERT INTO Contratos_Adopcion(pet_id,owner_id,dates) VALUES (?,?,?)";

        try(Connection con=Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ps.setInt(1,ca.getPetId());
            ps.setInt(2,ca.getOwnerId());
            ps.setString(3,ca.getDate());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException("Error al agregar contrato "+e.getMessage());
        }

    }

    public static List<Contractos_Adopcion> getAllContracts() throws SQLException {
        List<Contractos_Adopcion> contractsList=new ArrayList<>();

        String sql="select * from Contratos_Adopcion";
        try(Connection con=Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql)) {
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                Contractos_Adopcion ca=new Contractos_Adopcion();
                ca.setId(rs.getInt(1));
                ca.setPetId(rs.getInt(2));
                ca.setOwnerId(rs.getInt(3));
                ca.setDate(rs.getString(4));
                contractsList.add(ca);
            }
        }catch (SQLException e){
            throw new SQLException("Error al obtener la lista de contratos "+e.getMessage());
        }


        return contractsList;
    }
}
