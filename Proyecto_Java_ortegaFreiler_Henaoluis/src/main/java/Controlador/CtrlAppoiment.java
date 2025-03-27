package Controlador;

import Modelo.Persona;
import vista.ViewAppoiment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAppoiment implements ActionListener {
    ViewAppoiment ViewAppoiment;
    Persona people;

    public CtrlAppoiment(ViewAppoiment viewAppoiment, Persona people) {

        ViewAppoiment = viewAppoiment;
        this.people = people;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
