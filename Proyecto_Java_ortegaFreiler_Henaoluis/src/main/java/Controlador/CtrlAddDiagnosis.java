package Controlador;

import Modelo.Persona;
import vista.AddDiagnosis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAddDiagnosis implements ActionListener {
    AddDiagnosis Diagnosis;
    Persona people;

    public CtrlAddDiagnosis(AddDiagnosis diagnosis, Persona people) {
        Diagnosis = diagnosis;
        this.people = people;
        this.Diagnosis.ButtonSearchCita.addActionListener(this);
        this.Diagnosis.ButtonAddSugeries.addActionListener(this);
        this.Diagnosis.ButtonBackDiagnosis.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
