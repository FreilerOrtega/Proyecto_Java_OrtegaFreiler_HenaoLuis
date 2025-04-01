package Controlador;

import Modelo.Padecimiento;
import Modelo.PadecimientoDAO;
import Modelo.Persona;
import vista.AddDiagnosis;
import vista.AddSuffering;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CtrlAddSuffering implements ActionListener {
    AddSuffering addviewS ;
    Persona people;
    int pet_id;

    public CtrlAddSuffering(AddSuffering addviewS, Persona people,int pet_id) {
        addviewS = addviewS;
        this.addviewS = addviewS;
        this.people = people;
        this.pet_id = pet_id;
        this.addviewS.asignate.addActionListener(this);
        this.addviewS.backsufferries.addActionListener(this);


    }



    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==addviewS.backsufferries){
                addviewS.setVisible(false);
                AddDiagnosis addDiagnosis = new AddDiagnosis();
                addDiagnosis.setVisible(true);
                CtrlAddDiagnosis ctrlAddDiagnosis = new CtrlAddDiagnosis(addDiagnosis,people);
            } else if(e.getSource()==addviewS.asignate){
                addsuffering();


            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(addviewS,ex.getMessage());
        }

    }

    public void addsuffering() throws SQLException {
        Padecimiento suffering = new Padecimiento();

        suffering.setPet_id(pet_id);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        suffering.setDetection_date(simpleDateFormat.format(addviewS.inputDate.getDate()));
        suffering.setDiagnosis(addviewS.diagnosticotxt.getText());
        PadecimientoDAO.insertsuffering(suffering);
    }
}
