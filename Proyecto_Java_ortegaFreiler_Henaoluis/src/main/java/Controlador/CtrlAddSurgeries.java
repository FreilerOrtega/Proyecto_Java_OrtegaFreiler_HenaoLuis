package Controlador;

import Modelo.*;
import vista.AddDiagnosis;
import vista.AddSurgeries;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CtrlAddSurgeries implements ActionListener {
    AddSurgeries addS ;
    Persona people;
    int pet_id;


    public CtrlAddSurgeries(AddSurgeries addS, Persona people,int pet_id) {
        addS=addS;
        this.addS = addS;
        this.people = people;
        this.addS.ButtonAddsurgeries.addActionListener(this);
        this.addS.ButtonBackSugeries.addActionListener(this);
        this.pet_id = pet_id;

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
                addSugery();


            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(addS,ex.getMessage());
        }

    }

    public  void addSugery() throws SQLException {
        Cirugias Sugery = new Cirugias();
        //OBTENER DATOS DESDE LOS INPUTS PARA PODER AGREGARLOS AL BASE DE DATOS
        Sugery.setPetId(pet_id);
        Sugery.setVeterinarianId(people.getId());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Sugery.setSurgeryDate(simpleDateFormat.format(addS.inputDate.getDate()));
        try {
            Sugery.setRecoveryDays(Integer.parseInt(addS.DaysRecovery.getText()));
        }catch (NumberFormatException e){
            throw new NumberFormatException("por favor ingrese una cantidad de dias valido");
        }
        Sugery.setRecovery_status("En espera");
        Sugery.setTypeSugery(addS.TextTypeSugery.getText());
        CirugiasDAO.insertsurgeries(Sugery);

    }


}
