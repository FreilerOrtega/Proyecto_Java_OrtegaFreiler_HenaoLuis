package Controlador;

import Modelo.Persona;
import vista.ViewAddPeople;
import vista.ViewAdministratorHome;
import vista.ViewPeoplesManagement;
import vista.viewLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAdministratorHome implements ActionListener {

    ViewAdministratorHome administratorHome=new ViewAdministratorHome();
    Persona people;

    public CtrlAdministratorHome(ViewAdministratorHome administratorHome, Persona people) {
        this.administratorHome = administratorHome;
        this.people = people;
        this.administratorHome.labelNameAdmin.setText(people.getAllName());
        this.administratorHome.btnInventory.addActionListener(this);
        this.administratorHome.btnExit.addActionListener(this);
        this.administratorHome.btnPeoples.addActionListener(this);
        this.administratorHome.btnInvoices.addActionListener(this);
        this.administratorHome.btnContracts.addActionListener(this);
        this.administratorHome.btnPets.addActionListener(this);
        this.administratorHome.btnAppointments.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==administratorHome.btnExit) {
            administratorHome.setVisible(false);
            viewLogin VL=new viewLogin();
            VL.setVisible(true);
            crtllogin control=new crtllogin(VL);
        }else if (e.getSource()==administratorHome.btnPeoples) {
            administratorHome.setVisible(false);
            ViewPeoplesManagement VPM=new ViewPeoplesManagement();
            VPM.setVisible(true);
            CtrlPeoplesManagement CPM=new CtrlPeoplesManagement(VPM,people);

        }

    }
}
