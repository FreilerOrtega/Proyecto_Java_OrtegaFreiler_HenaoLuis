package Controlador;

import Modelo.*;
import vista.veterinarian;
import vista.viewsurgeriesperformed;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class crtlSurgeries implements ActionListener {
    viewsurgeriesperformed vsurgeries;
    Persona people;
    DefaultTableModel model = new DefaultTableModel();

    public crtlSurgeries(viewsurgeriesperformed vsurgeries, Persona people) {
        this.vsurgeries = vsurgeries;
        this.people = people;
        this.vsurgeries.Buttonbacksugeries.addActionListener(this);
        surgeriesTable(vsurgeries.Tablesurgeries);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==vsurgeries.Buttonbacksugeries){
            vsurgeries.setVisible(false);
            veterinarian vet = new veterinarian();
            vet.setVisible(true);
            Ctrlveterinarian name = new Ctrlveterinarian(vet, people);

        }

    }

    public void surgeriesTable(JTable table) {
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<Cirugias> surgeriesList = new ArrayList<>();
        try {
            surgeriesList = CirugiasDAO.getsurgeriesByveterinarianId(people.getId());

            Object[] object = new Object[6];
            for (Cirugias P : surgeriesList) {

                object[0] = P.getId();
                object[1] = P.getPetId();
                object[2] = P.getSurgeryDate();
                object[3] = P.getSurgeryDate();
                object[4] = P.getRecoveryDays();
                object[5] = P.getRecovery_status();


                model.addRow(object);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        vsurgeries.Tablesurgeries.setModel(model);
    }
}
