package Controlador;

import Modelo.Login;
import Modelo.LoginDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import vista.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CtrlAddPeople implements ActionListener {

    ViewAddPeople VAddPeople=new ViewAddPeople();
    Persona people;

    public CtrlAddPeople(ViewAddPeople VAddPeople, Persona people) {
        this.VAddPeople = VAddPeople;
        this.people = people;
        this.VAddPeople.btnAddPeople.addActionListener(this);
        this.VAddPeople.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VAddPeople.btnAddPeople){
                addPeople();
            } else if (e.getSource()==VAddPeople.btnExit) {
                VAddPeople.setVisible(false);
                ViewPeoplesManagement VPM=new ViewPeoplesManagement();
                VPM.setVisible(true);
                CtrlPeoplesManagement CPM=new CtrlPeoplesManagement(VPM,people);
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(VAddPeople, ex.getMessage());
        }

    }

    public void addPeople() throws SQLException {
        Persona people=new Persona();
        Login log=new Login();

        people.setFirst_name(VAddPeople.input1Name.getText());
        people.setSecond_name(VAddPeople.input2Name.getText()==""?null:VAddPeople.input2Name.getText());
        people.setLast_name1(VAddPeople.input1LastName.getText());
        people.setLast_name2(VAddPeople.input2LastName.getText());
        try{
            people.setId_number(Long.parseLong(VAddPeople.inputIDNumber.getText()));
        }catch (NumberFormatException nf){
            throw new NumberFormatException("Por favor ingrese un numero de identificacion valido");
        }
        people.setAddress(VAddPeople.inputAddres.getText());
        try{
            people.setPhone(Long.parseLong(VAddPeople.inputPhone.getText()));
        }catch (NumberFormatException nf) {
            throw new NumberFormatException("Por favor ingrese un numero de telefono valido");
        }
        people.setEmail(VAddPeople.inputEmail.getText());
        if (!VAddPeople.inputEmergencyContact.getText().trim().isEmpty()){
            try{
                people.setEmergency_contact(Long.parseLong(VAddPeople.inputEmergencyContact.getText()));
            }catch (NumberFormatException nf){
                throw new NumberFormatException("Por favor ingrese un numero de telefono de emergencia valido");
            }
        }
        people.setPerson_type(VAddPeople.CombSex.getSelectedItem().toString());

        int idOwner=PersonaDAO.AddPeople(people);

        log.setPersonId(idOwner);
        log.setUsername(VAddPeople.inputUser.getText());
        log.setPassword(VAddPeople.inputPassword.getText());

        LoginDAO.AddLogIn(log);

        VAddPeople.inputEmergencyContact.setText("");
        VAddPeople.inputPhone.setText("");
        VAddPeople.input1LastName.setText("");
        VAddPeople.input2LastName.setText("");
        VAddPeople.input1Name.setText("");
        VAddPeople.input2Name.setText("");
        VAddPeople.inputPhone.setText("");
        VAddPeople.inputAddres.setText("");
        VAddPeople.inputEmail.setText("");
        VAddPeople.inputIDNumber.setText("");
        VAddPeople.inputPassword.setText("");
        VAddPeople.inputUser.setText("");
    }
}
