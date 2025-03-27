package Controlador;

import Modelo.Persona;
import vista.AddSuffering;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAddSuffering implements ActionListener {
    AddSuffering addviewS ;
    Persona people;

    public CtrlAddSuffering(AddSuffering addviewS, Persona people) {
        addviewS = addviewS;
        this.addviewS = addviewS;
        this.people = people;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
