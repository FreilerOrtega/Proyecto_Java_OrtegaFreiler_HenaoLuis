package Controlador;

import Modelo.Padecimiento;
import Modelo.Persona;
import Modelo.PersonaDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vista.ViewModifyPeople;
import vista.ViewPeoplesManagement;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrlModifyPeople implements ActionListener {
    private static final Logger log = LoggerFactory.getLogger(CtrlModifyPeople.class);
    ViewModifyPeople VMP=new ViewModifyPeople();
    Persona people;
    DefaultTableModel model =  new DefaultTableModel();

    public CtrlModifyPeople(ViewModifyPeople VMP, Persona people) {
        this.VMP = VMP;
        this.people = people;
        PeoplesTable(VMP.tablePeoples);
        this.VMP.btnModPeople.addActionListener(this);
        this.VMP.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VMP.btnExit){
                VMP.setVisible(false);
                ViewPeoplesManagement VPM=new ViewPeoplesManagement();
                VPM.setVisible(true);
                CtrlPeoplesManagement CPM=new CtrlPeoplesManagement(VPM,people);
            } else if (e.getSource()==VMP.btnModPeople) {
                ModifyPeople();
                JOptionPane.showMessageDialog(VMP,"Persona modificada con exito");
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(VMP,ex.getMessage());
        }

    }

    public void ModifyPeople() throws SQLException {
        Persona peopleOld=new Persona();
        Persona peopleNew=new Persona();

        try{
            int idPeople=Integer.parseInt(VMP.inputPeople.getText());// se verifica de que la persona haya ingresado un numero
            peopleOld=PersonaDAO.SearchPeopleById(idPeople);// se obtienen los datos de la persona en caso de que no valla a modificar algun dto permanezca igual
            peopleNew.setId(idPeople);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingrese un id valido");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        peopleNew.setAddress(VMP.inputAddress.getText().trim().isEmpty()?peopleOld.getAddress():VMP.inputAddress.getText());// verifica que el imput tenga informacion y en caso de que no tenga poner la direccion vieja

        if (!VMP.inputPhone.getText().trim().isEmpty()){
            try{
                long newNumber=Long.parseLong(VMP.inputPhone.getText());
                peopleNew.setPhone(newNumber);

            }catch (NumberFormatException e){
                throw new NumberFormatException("Por favor ingrese un numero de telefono valido");
            }
        }else {
            peopleNew.setPhone(peopleOld.getPhone());
        }

        peopleNew.setEmail(VMP.inputEmail.getText().trim().isEmpty()?peopleOld.getEmail():VMP.inputEmail.getText());

        if (!VMP.inputnumberEmergency.getText().trim().isEmpty()){
            try{
                long newNumberEmergency=Long.parseLong(VMP.inputnumberEmergency.getText());
                peopleNew.setEmergency_contact(newNumberEmergency);

            }catch (NumberFormatException e){
                throw new NumberFormatException("Por favor ingrese un numero de emergencia valido");
            }
        }else {
            peopleNew.setEmergency_contact(peopleOld.getEmergency_contact());
        }

        PersonaDAO.ModifyPeople(peopleNew);

    }

    public void PeoplesTable(JTable table){
        model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        List<Persona> peoplesList = new ArrayList<>();
        try {
            peoplesList= PersonaDAO.getPeopleList();
            Object[] object=new Object[3];
            for (Persona p:peoplesList){
                object[0]=p.getId();
                object[1]=p.getAllName();
                object[2]=p.getId_number();
                model.addRow(object);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VMP.tablePeoples.setModel(model);
    }

    public void SearchInRealTime(JTextField jTextField){
        jTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                //textoCompleto.toLowerCase().contains(textoBuscado.toLowerCase());
            }
        });
    }
}
