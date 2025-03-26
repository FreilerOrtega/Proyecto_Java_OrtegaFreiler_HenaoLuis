package Controlador;

import Modelo.Persona;
import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlPeoplesManagement implements ActionListener {

    ViewPeoplesManagement VPM=new ViewPeoplesManagement();
    Persona people;

    public CtrlPeoplesManagement(ViewPeoplesManagement VPM, Persona people) {
        this.VPM = VPM;
        this.people = people;
        this.VPM.btnExit.addActionListener(this);
        this.VPM.btnAddPeople.addActionListener(this);
        this.VPM.btnModifyPeople.addActionListener(this);
        this.VPM.btnModifyLog.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==VPM.btnAddPeople){
            VPM.setVisible(false);
            ViewAddPeople VAP=new ViewAddPeople();
            VAP.setVisible(true);
            CtrlAddPeople CAP=new CtrlAddPeople(VAP,people);
        }else if (e.getSource()==VPM.btnExit){
            VPM.setVisible(false);
            ViewAdministratorHome VAH=new ViewAdministratorHome();
            VAH.setVisible(true);
            CtrlAdministratorHome CAH=new CtrlAdministratorHome(VAH,people);
        } else if (e.getSource()==VPM.btnModifyPeople) {
            VPM.setVisible(false);
            ViewModifyPeople VMP=new ViewModifyPeople();
            VMP.setVisible(true);
            CtrlModifyPeople CMP=new CtrlModifyPeople(VMP,people);
        } else if (e.getSource()==VPM.btnModifyLog){
            VPM.setVisible(false);
            ViewModifyLogin VML=new ViewModifyLogin();
            VML.setVisible(true);
            CtrlModifyLogin CML=new CtrlModifyLogin(VML,people);
        }

    }
}
