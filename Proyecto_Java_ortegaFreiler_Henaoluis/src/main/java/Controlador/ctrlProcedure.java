package Controlador;

import Modelo.*;
import vista.AddProcedure;
import vista.ViewProcedures;
import vista.veterinarian;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ctrlProcedure implements ActionListener {
    ViewProcedures ViewPro ;
    Persona people ;
    DefaultTableModel model = new DefaultTableModel();

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
    public void ProcedureTable(JTable table) {
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        List<Procedimientos> procedureList = new ArrayList<>();
        try {
            procedureList = ProcedimientoDAOveterinarian.getProceduresByveterinarianId(people.getId());
            List<Persona> peopleList = PersonaDAO.getPeopleList();
            Object[] object = new Object[4];
            for (Procedimientos P : procedureList) {

                object[0] = P.getPet_id();
                object[1] = P.getProcedurer();
                object[2] = P.getDates();
                object[3] = P.getAppointment_id();



                model.addRow(object);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ViewPro.tableviewprocedure.setModel(model);
    }

    public void addprocedure() throws SQLException{
        Procedimientos procedimientos = new Procedimientos();
        procedimientos.setPet_id(AddProcedure.);//AQUI VOY FREILER 

    }
}
