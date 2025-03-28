package Controlador;

import Modelo.Persona;
import vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlContractManagement implements ActionListener {
    ViewContractManagement VCM;
    Persona people;

    public CtrlContractManagement(ViewContractManagement VCM, Persona people) {
        this.VCM = VCM;
        this.people = people;
        VCM.btnExit2.addActionListener(this);
        VCM.btnAddContract.addActionListener(this);
        VCM.btnAddTraking.addActionListener(this);
        VCM.btnSeeTraking.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VCM.btnExit2){
                VCM.setVisible(false);
                ViewAdministratorHome VAH = new ViewAdministratorHome();
                VAH.setVisible(true);
                CtrlAdministratorHome CAH = new CtrlAdministratorHome(VAH, people);
            } else if (e.getSource()==VCM.btnAddContract) {
                VCM.setVisible(false);
                ViewAddContract VAC=new ViewAddContract();
                VAC.setVisible(true);
                CtrlAddContract CAP=new CtrlAddContract(VAC,people);
            } else if (e.getSource()==VCM.btnAddTraking){
                VCM.setVisible(false);
                ViewContractTracking VCT=new ViewContractTracking();
                VCT.setVisible(true);
                CtrlContractTracking CCT=new CtrlContractTracking(VCT,people);
            } else if (e.getSource()==VCM.btnSeeTraking) {
                VCM.setVisible(false);
                ViewSeeTrackingOfContract VSTOC=new ViewSeeTrackingOfContract();
                VSTOC.setVisible(true);
                CtrlSeeTrackingOfContract CSTOC=new CtrlSeeTrackingOfContract(VSTOC,people);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VCM,ex.getMessage());
        }
    }
}
