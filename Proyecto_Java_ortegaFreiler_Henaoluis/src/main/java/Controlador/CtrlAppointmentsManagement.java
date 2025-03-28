package Controlador;

import Modelo.Persona;
import vista.ViewAddAppointment;
import vista.ViewAdministratorHome;
import vista.ViewAppointmentsManagement;
import vista.ViewChangeStatusOfAppointment;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAppointmentsManagement implements ActionListener {

    ViewAppointmentsManagement VAM;
    Persona people;

    public CtrlAppointmentsManagement(ViewAppointmentsManagement VAM, Persona people) {
        this.VAM = VAM;
        this.people = people;
        VAM.btnExit.addActionListener(this);
        VAM.btnAddAppointment.addActionListener(this);
        VAM.btnAppointmentsStatus.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VAM.btnExit){
                VAM.setVisible(false);
                ViewAdministratorHome VAH = new ViewAdministratorHome();
                VAH.setVisible(true);
                CtrlAdministratorHome CAH=new CtrlAdministratorHome(VAH,people);
            }
            if (e.getSource()==VAM.btnAddAppointment){
                VAM.setVisible(false);
                ViewAddAppointment VAA=new ViewAddAppointment();
                VAA.setVisible(true);
                CtrlAddAppointment CAA=new CtrlAddAppointment(VAA,people);
            }
            if (e.getSource()==VAM.btnAppointmentsStatus){
                VAM.setVisible(false);
                ViewChangeStatusOfAppointment VCSOP=new ViewChangeStatusOfAppointment();
                VCSOP.setVisible(true);
                CtrlChangeStatusOfAppointment CCSOP=new CtrlChangeStatusOfAppointment(VCSOP,people);
            }


        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VAM,ex.getMessage());
        }
    }
}
