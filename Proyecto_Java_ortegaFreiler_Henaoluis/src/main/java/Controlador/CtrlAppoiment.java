package Controlador;

import Modelo.Persona;
import vista.ViewAppoiment;
import vista.veterinarian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAppoiment implements ActionListener {
    ViewAppoiment ViewAppoiment;
    Persona people;

    public CtrlAppoiment(ViewAppoiment viewAppoiment, Persona people) {

        ViewAppoiment = viewAppoiment;
        this.people = people;
        this.ViewAppoiment.Buttonbackappoiment.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==ViewAppoiment.Buttonbackappoiment){
            ViewAppoiment.setVisible(false);
            veterinarian vet = new veterinarian();
            vet.setVisible(true);
            Ctrlveterinarian name = new Ctrlveterinarian(vet,people);

        }

    }
}
