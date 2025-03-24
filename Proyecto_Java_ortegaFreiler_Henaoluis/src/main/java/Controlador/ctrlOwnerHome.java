package Controlador;

import Modelo.CitaDAO;
import Modelo.Persona;
import vista.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class ctrlOwnerHome  implements ActionListener {
    viewOwnerHome viewOHome;
    CitaDAO citaDAO=new CitaDAO();
    int peopleID;
    public ctrlOwnerHome(viewOwnerHome viewOHome, Persona persona) throws SQLException {

        String cantApp= String.valueOf(citaDAO.viewOwnerAppointments(persona));
        this.peopleID=persona.getId();
        this.viewOHome = viewOHome;
        this.viewOHome.ownerName.setText(persona.getAllName());
        this.viewOHome.visits.setText(cantApp);
        this.viewOHome.btnViewHistoryC.addActionListener(this);
        this.viewOHome.btnViewHistoryS.addActionListener(this);
        this.viewOHome.btnViewSurgeries.addActionListener(this);
        this.viewOHome.btnViewProcedures.addActionListener(this);
        this.viewOHome.btnLogOut.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if(e.getSource()==viewOHome.btnViewHistoryC){

                viewOHome.setVisible(false);
                viewAppointmentsHistory VAH=new viewAppointmentsHistory();
                VAH.setVisible(true);
                CtrlAppointmentsHistory CAH=new CtrlAppointmentsHistory(VAH,peopleID);

            } else if (e.getSource()==viewOHome.btnViewHistoryS) {

                viewOHome.setVisible(false);
                viewHealthHistory VHH=new viewHealthHistory();
                VHH.setVisible(true);

                CtrlHealthHistory CHH=new CtrlHealthHistory(VHH,peopleID);

            }else if (e.getSource()==viewOHome.btnViewProcedures) {
                viewOHome.setVisible(false);
                viewVaccineHistory VVS=new viewVaccineHistory();
                VVS.setVisible(true);
                CtrlProcedureHistoryOwner CPHO=new CtrlProcedureHistoryOwner(VVS,peopleID);

            }else if (e.getSource()==viewOHome.btnViewSurgeries) {
                viewOHome.setVisible(false);
                viewSurgeriesHistory VSH=new viewSurgeriesHistory();
                VSH.setVisible(true);

                CtrlSurgeriesHistory CSH=new CtrlSurgeriesHistory(VSH,peopleID);
            } else if (e.getSource()==viewOHome.btnLogOut) {
                viewOHome.setVisible(false);
                viewLogin VL=new viewLogin();
                VL.setVisible(true);
                crtllogin control=new crtllogin(VL);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(viewOHome,ex.getMessage());
        }


    }
}
