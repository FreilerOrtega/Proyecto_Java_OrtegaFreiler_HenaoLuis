package Controlador;

import Modelo.*;
import vista.ViewAppoiment;
import vista.veterinarian;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static Modelo.CitaDAO.getsurgeriesByveterinarianId;

public class CtrlAppoiment implements ActionListener {
    ViewAppoiment ViewAppoiment;
    Persona people;
    DefaultTableModel model = new DefaultTableModel();

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
    public void citaTable(JTable table) {
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<Cita> AppoimentList = new ArrayList<>();
        try {
            AppoimentList = getsurgeriesByveterinarianId(people.getId());

            Object[] object = new Object[8];
            for (Cita P : AppoimentList) {

                object[0] = P.getId();
                object[1] = P.getPet_id();
                object[2] = P.getOwner_id();
                object[3] = P.getDates();
                object[4]= P.getConsultation_reason();
                object[5]=P.getDiagnosis();
                object[6]=P.isAttendance();
                object[7]=P.getStatus();

                model.addRow(object);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ViewAppoiment.ViewtableAppoiment.setModel(model);
    }
}
