package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdecimientosDAO {

    public static List<Procedimientos> getProceduresByPetId(int id) throws SQLException {
        List<Procedimientos> proceduresList=new ArrayList<>();

        String sql="select * from Procedimiento where pet_id=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps=con.prepareStatement(sql)) {
            ps.setInt(1,id);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                Procedimientos procedure=new Procedimientos();
                procedure.setId(rs.getInt(1));
                procedure.setPet_id(rs.getInt(2));
                procedure.setProcedurer(rs.getString(3));
                procedure.setDates(rs.getString(4));
                procedure.setVeterinarian_id(rs.getInt(5));
                procedure.setAppointment_id(rs.getInt(6));
                proceduresList.add(procedure);
            }

        }catch (SQLException e){
            throw new SQLException(("Error en la obtencion de procedimientos por id de mascota")+e.getMessage());
        }

        return proceduresList;
    }


}
