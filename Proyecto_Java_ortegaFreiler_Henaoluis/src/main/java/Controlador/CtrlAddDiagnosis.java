package Controlador;

import Modelo.Cita;
import Modelo.CitaDAO;
import Modelo.Persona;
import vista.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrlAddDiagnosis implements ActionListener {
    AddDiagnosis Diagnosis;
    Persona people;
    int idAppointment;
    List<Cita>citaList = CitaDAO.getAllAppointments();
    DefaultTableModel model = new DefaultTableModel() ;

    public CtrlAddDiagnosis(AddDiagnosis diagnosis, Persona people) throws SQLException {
        Diagnosis = diagnosis;
        this.people = people;
        this.Diagnosis.ButtonAddSurgeries.addActionListener(this);
        this.Diagnosis.ButtonBackDiagnosis.addActionListener(this);
        this.Diagnosis.ButtonAddVaccination.addActionListener(this);
        this.Diagnosis.ButtonAddSuffering.addActionListener(this);
        this.Diagnosis.ButtonAddDeworning.addActionListener(this);
        this.Diagnosis.ButtonAddProcedure.addActionListener(this);
        this.Diagnosis.ButtonAddDiagnosis.addActionListener(this);
        ViewAppoimentByV(Diagnosis.TableViewCita);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{


             if (e.getSource()==Diagnosis.ButtonAddSurgeries) {
                 try {
                     if (!Diagnosis.IdCitaAsiganar.getText().trim().isEmpty()){
                         idAppointment = Integer.parseInt(Diagnosis.IdCitaAsiganar.getText());
                     } else {
                         throw new RuntimeException("por favor ingrese un id de cita");

                     }

                 }catch (NumberFormatException es){
                     throw new NumberFormatException("Por Favor Ingrese Un Id De Cita Valido");
                 }
                 Diagnosis.setVisible(false);
                 AddSurgeries addSurgeries= new AddSurgeries();
                 addSurgeries.setVisible(true);
                 int id_pet= 0;
                 for (Cita c:citaList){
                     if (c.getId()==idAppointment){
                         id_pet=c.getPet_id();
                     };
                 }

                 CtrlAddSurgeries ctrlAddSurgeries = new CtrlAddSurgeries(addSurgeries,people,id_pet);

             } else if (e.getSource()==Diagnosis.ButtonAddSuffering) {
                 try {
                     if (!Diagnosis.IdCitaAsiganar.getText().trim().isEmpty()){
                         idAppointment = Integer.parseInt(Diagnosis.IdCitaAsiganar.getText());
                     } else {
                         throw new RuntimeException("por favor ingrese un id de cita");

                     }

                 }catch (NumberFormatException es){
                     throw new NumberFormatException("Por Favor Ingrese Un Id De Cita Valido");
                 }
                 Diagnosis.setVisible(false);
                 AddSuffering suffering = new AddSuffering();
                 suffering.setVisible(true);
                 int id_pet= 0;
                 for (Cita c:citaList){
                     if (c.getId()==idAppointment){
                         id_pet=c.getPet_id();
                     };
                 }
                 CtrlAddSuffering ctrlAddSuffering = new CtrlAddSuffering(suffering,people,id_pet);



             } else if (e.getSource()==Diagnosis.ButtonAddDeworning) {
                 try {
                     if (!Diagnosis.IdCitaAsiganar.getText().trim().isEmpty()){
                         idAppointment = Integer.parseInt(Diagnosis.IdCitaAsiganar.getText());
                     } else {
                         throw new RuntimeException("por favor ingrese un id de cita");

                     }

                 }catch (NumberFormatException es){
                     throw new NumberFormatException("Por Favor Ingrese Un Id De Cita Valido");
                 }
                 Diagnosis.setVisible(false);
                 AddDeworning addDeworning= new AddDeworning();
                 addDeworning.setVisible(true);
                 int id_pet= 0;
                 for (Cita c:citaList){
                     if (c.getId()==idAppointment){
                         id_pet=c.getPet_id();
                     };
                 }
                 CtrlAddDeworning ctrlAddDeworning = new CtrlAddDeworning(addDeworning,people,id_pet);

            } else if (e.getSource()==Diagnosis.ButtonBackDiagnosis) {
                Diagnosis.setVisible(false);
                veterinarian vet = new veterinarian();
                vet.setVisible(true);
                Ctrlveterinarian ctrlv= new Ctrlveterinarian(vet, people);
            } else if (e.getSource()==Diagnosis.ButtonAddProcedure) {
                 try {
                     if (!Diagnosis.IdCitaAsiganar.getText().trim().isEmpty()){
                         idAppointment = Integer.parseInt(Diagnosis.IdCitaAsiganar.getText());
                     } else {
                         throw new RuntimeException("por favor ingrese un id de cita");

                     }

                 }catch (NumberFormatException es){
                     throw new NumberFormatException("Por Favor Ingrese Un Id De Cita Valido");
                 }
                Diagnosis.setVisible(false);
                AddProcedure addProcedure= new AddProcedure();
                addProcedure.setVisible(true);
                CtrlAddProcedures ctrlAddProcedures = new CtrlAddProcedures(addProcedure,people,idAppointment);


            } else if (e.getSource()==Diagnosis.ButtonAddVaccination) {
                 try {
                     if (!Diagnosis.IdCitaAsiganar.getText().trim().isEmpty()){
                         idAppointment = Integer.parseInt(Diagnosis.IdCitaAsiganar.getText());
                     } else {
                         throw new RuntimeException("por favor ingrese un id de cita");

                     }

                 }catch (NumberFormatException es){
                     throw new NumberFormatException("Por Favor Ingrese Un Id De Cita Valido");
                 }
                 Diagnosis.setVisible(false);
                 AddVaccination addVaccination= new AddVaccination();
                 addVaccination.setVisible(true);
                 int id_pet= 0;
                 for (Cita c:citaList){
                     if (c.getId()==idAppointment){
                         id_pet=c.getPet_id();
                     };
                 }
                 crtlVaccine crtlVaccine_history = new crtlVaccine (addVaccination,people,id_pet);


            }else if (e.getSource()==Diagnosis.ButtonAddDiagnosis) {
                 Cita cita = new Cita();

                 try {
                     if (!Diagnosis.IdCitaAsiganar.getText().trim().isEmpty()) {
                         idAppointment = Integer.parseInt(Diagnosis.IdCitaAsiganar.getText());
                         cita.setId(idAppointment);


                     } else {
                         throw new RuntimeException("por favor ingrese un id de cita");

                     }

                 } catch (NumberFormatException es) {
                     throw new NumberFormatException("Por Favor Ingrese Un Id De Cita Valido");
                 }
                 cita.setDiagnosis(Diagnosis.textaddD.getText());
                 CitaDAO.changediagnosis(cita);
            }
        }catch  (Exception ex){
                JOptionPane.showMessageDialog(Diagnosis, ex.getMessage());

        }

    }

    public void ViewAppoimentByV(JTable jtable){
        model = (DefaultTableModel) jtable.getModel();
        model.setRowCount(0);
        Object[] obj = new Object[5];
        for (Cita c : citaList){
            if (c.getVeterinarian_id()==people.getId()){

                obj[0]=c.getId();
                obj[1]=c.getPet_id();
                obj[2]=c.getOwner_id();
                obj[3]=c.getDates();
                obj[4]=c.getDiagnosis();

                model.addRow(obj);


            };

        }
        Diagnosis.TableViewCita.setModel(model);
    }







}
