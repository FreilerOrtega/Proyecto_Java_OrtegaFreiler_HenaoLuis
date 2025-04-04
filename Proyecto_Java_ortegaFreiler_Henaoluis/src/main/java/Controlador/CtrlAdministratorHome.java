package Controlador;

import Modelo.Persona;
import vista.*;

import javax.swing.*;
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
        try {

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

            } else if (e.getSource()==administratorHome.btnPets){
                administratorHome.setVisible(false);
                ViewPetsManagement VPetM=new ViewPetsManagement();
                VPetM.setVisible(true);
                CtrlPetsManagement CPM=new CtrlPetsManagement(VPetM,people);
            } else if(e.getSource()==administratorHome.btnInvoices) {
                administratorHome.setVisible(false);
                ViewAddInvoice VAI = new ViewAddInvoice();
                VAI.setVisible(true);
                CtrlAddInvoice CAI = new CtrlAddInvoice(VAI, people);
            } else if (e.getSource()==administratorHome.btnInventory) {
                administratorHome.setVisible(false);
                ViewInventoryManagement VIM=new ViewInventoryManagement();
                VIM.setVisible(true);
                CtrlInventoryManagement CIM=new CtrlInventoryManagement(VIM,people);
            } else if (e.getSource()==administratorHome.btnAppointments) {
                administratorHome.setVisible(false);
                ViewAppointmentsManagement VAM=new ViewAppointmentsManagement();
                VAM.setVisible(true);
                CtrlAppointmentsManagement CAP=new CtrlAppointmentsManagement(VAM,people);
            } else if (e.getSource()==administratorHome.btnContracts) {
                administratorHome.setVisible(false);
                ViewContractManagement VCM=new ViewContractManagement();
                VCM.setVisible(true);
                CtrlContractManagement CCM=new CtrlContractManagement(VCM,people);
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(administratorHome,ex.getMessage());
        }

    }
}
