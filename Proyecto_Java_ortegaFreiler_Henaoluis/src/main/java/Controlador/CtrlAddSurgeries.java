package Controlador;

import Modelo.Persona;
import vista.AddDiagnosis;
import vista.AddSurgeries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrlAddSurgeries implements ActionListener {
    AddSurgeries addS ;
    Persona people;


    public CtrlAddSurgeries(AddSurgeries addS, Persona people) {
        addS=addS;
        this.addS = addS;
        this.people = people;
        this.addS.ButtonAddsurgeries.addActionListener(this);
        this.addS.ButtonBackSugeries.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if (e.getSource()==addS.ButtonBackSugeries){
                addS.setVisible(false);
                AddDiagnosis addDiagnosis = new AddDiagnosis();
                addDiagnosis.setVisible(true);
                CtrlAddDiagnosis ctrlAddDiagnosis = new CtrlAddDiagnosis(addDiagnosis,people);
            } else if(e.getSource()==addS.ButtonAddsurgeries){


            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(addS,ex.getMessage());
        }

    }
}
