package Controlador;

import Modelo.Persona;
import vista.AddDeworming;
import vista.AddDiagnosis;
import vista.AddSuffering;
import vista.AddSurgeries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAddDiagnosis implements ActionListener {
    AddDiagnosis Diagnosis;
    Persona people;

    public CtrlAddDiagnosis(AddDiagnosis diagnosis, Persona people) {
        Diagnosis = diagnosis;
        this.people = people;
        this.Diagnosis.ButtonSearchCita.addActionListener(this);
        this.Diagnosis.ButtonAddSurgeries.addActionListener(this);
        this.Diagnosis.ButtonBackDiagnosis.addActionListener(this);
        this.Diagnosis.ButtonAddDiagnosis.addActionListener(this);
        this.Diagnosis.ButtonAddVaccination.addActionListener(this);
        this.Diagnosis.ButtonAddSuffering.addActionListener(this);
        this.Diagnosis.ButtonAddDeworning.addActionListener(this);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==Diagnosis.ButtonSearchCita){

        } else if (e.getSource()==Diagnosis.ButtonAddSurgeries) {
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
        }

    }
}
