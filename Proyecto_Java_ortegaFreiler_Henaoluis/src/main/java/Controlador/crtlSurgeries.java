package Controlador;

import Modelo.Persona;
import vista.veterinarian;
import vista.viewsurgeriesperformed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class crtlSurgeries implements ActionListener {
    viewsurgeriesperformed vsurgeries;
    Persona people;

    public crtlSurgeries(viewsurgeriesperformed vsurgeries, Persona people) {
        this.vsurgeries = vsurgeries;
        this.people = people;
        this.vsurgeries.Buttonbacksugeries.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==vsurgeries.Buttonbacksugeries){
            vsurgeries.setVisible(false);
            veterinarian vet = new veterinarian();
            vet.setVisible(true);
            Ctrlveterinarian name = new Ctrlveterinarian(vet,people);
        }

    }
}
