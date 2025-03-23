package Modelo;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {

    public int logInConf(Login login) throws SQLException {
        String sql="Select person_id from login where username=? and passwordU=?";

        try(Connection con=Conect.getCon();
            PreparedStatement ps= con.prepareStatement(sql);)
        {
            ps.setString(1,login.getUsername());
            ps.setString(2,login.getPassword());

                ResultSet rs=ps.executeQuery();
            if (rs.next()){//si encuentra un login que cumplan con los datos se retorna el id de la persona que tenga ese login
                return rs.getInt(1);
            }
            try {
                con.close();
            }catch (SQLException i){
                System.out.println(i.getMessage());
            }

        } catch (SQLException e) {
            throw new SQLException("Error en la confirmacion de login"+e.getMessage());
        }
        return 0;// si no encuentra un login que cumpla con los datos se retorna 0 para darle manejo
    };
}
