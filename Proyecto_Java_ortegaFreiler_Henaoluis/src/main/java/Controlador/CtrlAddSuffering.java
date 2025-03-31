package Controlador;

import Modelo.Persona;
import vista.AddSuffering;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAddSuffering implements ActionListener {
    AddSuffering addviewS ;
    Persona people;
    int pet_id;

    public CtrlAddSuffering(AddSuffering addviewS, Persona people,int pet_id) {
        addviewS = addviewS;
        this.addviewS = addviewS;
        this.people = people;
        this.pet_id = pet_id;

    }



    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
