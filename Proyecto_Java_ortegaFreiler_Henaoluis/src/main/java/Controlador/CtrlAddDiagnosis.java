package Controlador;

import Modelo.Cita;
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

    public CtrlAddDiagnosis(AddDiagnosis diagnosis, Persona people) {
        Diagnosis = diagnosis;
        this.people = people;
        this.Diagnosis.ButtonAddSurgeries.addActionListener(this);
        this.Diagnosis.ButtonBackDiagnosis.addActionListener(this);
        this.Diagnosis.ButtonAddVaccination.addActionListener(this);
        this.Diagnosis.ButtonAddSuffering.addActionListener(this);
        this.Diagnosis.ButtonAddDeworning.addActionListener(this);
        this.Diagnosis.ButtonAddProcedure.addActionListener(this);
        this.Diagnosis.ButtonAddDiagnosis.addActionListener(this);



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
                 CtrlAddSurgeries ctrlAddSurgeries = new CtrlAddSurgeries(addSurgeries,people);

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
                 AddSurgeries addSurgeries= new AddSurgeries();
                 addSurgeries.setVisible(true);
                 CtrlAddSurgeries ctrlAddSurgeries = new CtrlAddSurgeries(addSurgeries,people);

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
                 CtrlAddDeworning ctrlAddDeworning = new CtrlAddDeworning(addDeworning,people);

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
                  crtlVaccine crtlVaccine_history = new crtlVaccine (addVaccination,people);


            }else if (e.getSource()==Diagnosis.ButtonAddDiagnosis) {
                 try {
                     if (!Diagnosis.IdCitaAsiganar.getText().trim().isEmpty()) {
                         idAppointment = Integer.parseInt(Diagnosis.IdCitaAsiganar.getText());
                     } else {
                         throw new RuntimeException("por favor ingrese un id de cita");

                     }

                 } catch (NumberFormatException es) {
                     throw new NumberFormatException("Por Favor Ingrese Un Id De Cita Valido");
                 }



            }


        }catch  (Exception ex){
                JOptionPane.showMessageDialog(Diagnosis, ex.getMessage());

        }





    }









}
