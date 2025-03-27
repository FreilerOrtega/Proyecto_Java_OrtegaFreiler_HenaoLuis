package Controlador;

import Modelo.Persona;
import vista.AddDeworming;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAddDeworning implements ActionListener {

    AddDeworming addDeworming;
    Persona people;

    public CtrlAddDeworning(AddDeworming addDeworming, Persona people) {
        this.addDeworming = addDeworming;
        this.people = people;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
