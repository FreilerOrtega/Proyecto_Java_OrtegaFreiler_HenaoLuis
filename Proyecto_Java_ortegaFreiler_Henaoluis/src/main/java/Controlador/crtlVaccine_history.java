package Controlador;

import Modelo.Persona;
import vista.AddVaccination;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class crtlVaccine_history implements ActionListener {
    AddVaccination addVaccination ;
    Persona people;

    public crtlVaccine_history(AddVaccination addVaccination, Persona people) {
        this.addVaccination = addVaccination;
        this.people = people;
        this.addVaccination.ButtonBackVaccination.addActionListener(this);
        this.addVaccination.ButtonAignarMedicamento.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
