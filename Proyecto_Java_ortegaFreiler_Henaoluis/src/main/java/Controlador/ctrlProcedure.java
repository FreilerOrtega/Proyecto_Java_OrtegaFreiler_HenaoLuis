package Controlador;

import Modelo.Persona;
import vista.ViewProcedures;
import vista.veterinarian;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ctrlProcedure implements ActionListener {
    ViewProcedures ViewPro ;
    Persona people ;

    public ctrlProcedure(ViewProcedures viewPro, Persona people) {
        ViewPro = viewPro;
        this.people = people;
        this.ViewPro.Buttonbackprocedures.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==ViewPro.Buttonbackprocedures){
            ViewPro.setVisible(false);
            veterinarian vet = new veterinarian();
            vet.setVisible(true);
            Ctrlveterinarian name = new Ctrlveterinarian(vet,people);

        }

    }
}
