package Controlador;

import Modelo.CitaDAO;
import Modelo.Persona;
import vista.*;

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
        this.viewOHome.btnViewVaccine.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        }

    }
}
