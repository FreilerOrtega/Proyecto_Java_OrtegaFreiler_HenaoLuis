package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProcedimientoDAOveterinarian {


    public static List<Procedimientos> getProceduresByveterinarianId(int id) throws SQLException {
        List<Procedimientos> proceduresList=new ArrayList<>();

        String sql="select * from Procedimiento where veterinarian_id=?";

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
            throw new SQLException(("Error en la obtencion de procedimientos por id de veterinario ")+e.getMessage());
        }

        return proceduresList;
    }

    public static void insertprocedure(Procedimientos procedimientos)throws SQLException{

        String sql="INSERT INTO Procedimientos (pet_id,procedurer,dates,veterinarian_id,appoiment_id)\n \n"+
                "VALUES(?,?,?,?,?)";


        try (Connection con = Conect.getCon();
            PreparedStatement PS = con.prepareStatement(sql)) {
            PS.setInt(1,procedimientos.getPet_id());
            PS.setString(2,procedimientos.getProcedurer());
            PS.setString(3,procedimientos.getDates());
            PS.setInt(4,procedimientos.getVeterinarian_id());
            PS.setInt(5,procedimientos.getAppointment_id());


            int agg = PS.executeUpdate();
            if (agg>0){
                JOptionPane.showMessageDialog(null,"Procedimiento agregado con exito");

            }
            try{
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }
        }catch (SQLException e){
            throw new SQLException("Error al agregar mascota"+e.getMessage());
        }




    }
}