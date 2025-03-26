package Controlador;

import Modelo.Persona;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlPetsManagement implements ActionListener {

    ViewPetsManagement VPM;
    Persona people;

    public CtrlPetsManagement(ViewPetsManagement VPM, Persona people) {
        this.VPM = VPM;
        this.people = people;
        this.VPM.btnExit.addActionListener(this);
        this.VPM.btnAddPet.addActionListener(this);
        this.VPM.btnAddPetWithOutOwner.addActionListener(this);
        this.VPM.btnModifyPet.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==VPM.btnExit){
            VPM.setVisible(false);
            ViewAdministratorHome VAH = new ViewAdministratorHome();
            VAH.setVisible(true);
            CtrlAdministratorHome CAH=new CtrlAdministratorHome(VAH,people);
        } else if (e.getSource()==VPM.btnAddPet) {
            VPM.setVisible(false);
            ViewAddPetWithOwner VAPO=new ViewAddPetWithOwner();
            VAPO.setVisible(true);
            CtrlAddPetWithOwner CAP=new CtrlAddPetWithOwner(VAPO,people);
        } else if (e.getSource()==VPM.btnAddPetWithOutOwner) {
            VPM.setVisible(false);
            ViewAddPetWithOutOwner VPWO=new ViewAddPetWithOutOwner();
            VPWO.setVisible(true);
            CtrlAddPetWithOutOwner CAPWO=new CtrlAddPetWithOutOwner(VPWO,people);

        } else if (e.getSource()==VPM.btnModifyPet){
            VPM.setVisible(false);
            ViewModifyPet VMPet=new ViewModifyPet();
            VMPet.setVisible(true);
            CtrlModifyPet CMP=new CtrlModifyPet(VMPet,people);
        }

    }
}

