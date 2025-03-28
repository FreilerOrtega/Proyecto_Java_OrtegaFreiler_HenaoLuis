package Controlador;

import Modelo.Persona;
import vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAddDiagnosis implements ActionListener {
    AddDiagnosis Diagnosis;
    Persona people;
    int idAppointment;

    public CtrlAddDiagnosis(AddDiagnosis diagnosis, Persona people) {
        Diagnosis = diagnosis;
        this.people = people;
        this.Diagnosis.ButtonAddSurgeries.addActionListener(this);
        this.Diagnosis.ButtonBackDiagnosis.addActionListener(this);
        this.Diagnosis.ButtonAddDiagnosis.addActionListener(this);
        this.Diagnosis.ButtonAddVaccination.addActionListener(this);
        this.Diagnosis.ButtonAddSuffering.addActionListener(this);
        this.Diagnosis.ButtonAddDeworning.addActionListener(this);
        this.Diagnosis.ButtonAddProcedure.addActionListener(this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{


             if (e.getSource()==Diagnosis.ButtonAddSurgeries) {
                Diagnosis.setVisible(false);

                AddSurgeries addS = new AddSurgeries();
                addS.setVisible(true);
                CtrlAddSurgeries crtLS= new CtrlAddSurgeries(addS,people);
            } else if (e.getSource()==Diagnosis.ButtonAddSuffering) {
                Diagnosis.setVisible(false);
                AddSuffering addviewS = new AddSuffering();
                addviewS.setVisible(true);
                CtrlAddSuffering CrtlSuff = new CtrlAddSuffering(addviewS,people);

            } else if (e.getSource()==Diagnosis.ButtonAddDeworning) {
                Diagnosis.setVisible(false);
                AddDeworming addDeworming = new AddDeworming();
                addDeworming.setVisible(true);
                CtrlAddDeworning ctrlAddDeworning = new CtrlAddDeworning(addDeworming,people);

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


            }


        }catch  (Exception ex){
            JOptionPane.showMessageDialog(Diagnosis,ex.getMessage());
        }


    }
}
