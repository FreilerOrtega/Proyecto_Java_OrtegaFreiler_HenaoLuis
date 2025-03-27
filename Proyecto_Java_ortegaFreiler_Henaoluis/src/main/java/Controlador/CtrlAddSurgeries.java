package Controlador;

import Modelo.Persona;
import vista.AddSurgeries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAddSurgeries implements ActionListener {
    AddSurgeries addS ;
    Persona people;

    public CtrlAddSurgeries(AddSurgeries addS, Persona people) {
        addS=addS;
        this.addS = addS;
        this.people = people;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
