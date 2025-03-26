package Controlador;

import Modelo.CitaDAO;
import Modelo.Persona;
import vista.ViewProcedures;
import vista.veterinarian;
import vista.viewsurgeriesperformed;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Ctrlveterinarian implements ActionListener {
    veterinarian ViewVeterinarian;
    Persona people;


    public Ctrlveterinarian(veterinarian viewVeterinarian, Persona poeple) {

        ViewVeterinarian = viewVeterinarian;
        this.people = poeple;
        this.ViewVeterinarian.labelnameveterinarian.setText(poeple.getAllName());
        this.ViewVeterinarian.Buttonprocedure.addActionListener(this);
        this.ViewVeterinarian.Buttonsurgeries.addActionListener(this);
        this.ViewVeterinarian.Buttonappoinment.addActionListener(this);
        this.ViewVeterinarian.ButtonAddDiagnosis.addActionListener(this);
        this.ViewVeterinarian.ButtonClosedSesion.addActionListener(this);
        this.ViewVeterinarian.Buttonback.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    if(e.getSource()==ViewVeterinarian.Buttonprocedure){

        ViewVeterinarian.setVisible(false);
        ViewProcedures ViewPro = new ViewProcedures();
        ViewPro.setVisible(true);
        ctrlProcedure ctrp = new ctrlProcedure(ViewPro,people);
    } else if (e.getSource()==ViewVeterinarian.Buttonsurgeries) {
        ViewVeterinarian.setVisible(false);
        viewsurgeriesperformed viewS = new viewsurgeriesperformed();
        viewS.setVisible(true);
        crtlSurgeries ctrls = new crtlSurgeries(viewS,people);



    }

    }
}
