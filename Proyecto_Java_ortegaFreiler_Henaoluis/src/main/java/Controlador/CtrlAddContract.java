package Controlador;

import Modelo.*;
import vista.ViewAddContract;
import vista.ViewContractManagement;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CtrlAddContract implements ActionListener {

    ViewAddContract VAC;
    Persona people;
    List<Mascota> petsList= MascotaDAO.viewPetsList();
    List<Persona> peoplesList= PersonaDAO.getPeopleList();
    DefaultTableModel model=new DefaultTableModel();

    public CtrlAddContract(ViewAddContract VAC, Persona people) throws SQLException {
        this.VAC = VAC;
        this.people = people;
        VAC.btnExit.addActionListener(this);
        VAC.btnAddContract.addActionListener(this);
        seePets(VAC.tablePets);
        seePeoples(VAC.tablePeoples);
        SearchInRealTimePeople(VAC.inputSearchPeople);
        SearchInRealTimePet(VAC.inputSearchPet);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VAC.btnExit){
                VAC.setVisible(false);
                ViewContractManagement VCM=new ViewContractManagement();
                VCM.setVisible(true);
                CtrlContractManagement CCM=new CtrlContractManagement(VCM,people);
            } else if (e.getSource()==VAC.btnAddContract) {
                addContract();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VAC,ex.getMessage());
        }
    }

    public void addContract() throws SQLException {

        Contractos_Adopcion ca=new Contractos_Adopcion();
        int newIDOwner=0;
        int idPet=0;
        try {
                ca.setPetId(Integer.parseInt(VAC.inputPetId.getText()));
                idPet=Integer.parseInt(VAC.inputPetId.getText());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ingresa un id de mascota valido");
        }

        try {
                ca.setOwnerId(Integer.parseInt(VAC.inputPeopleId.getText()));
                newIDOwner=Integer.parseInt(VAC.inputPeopleId.getText());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ingresa un id de persona valido");
        }

        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyy-MM-dd");
        Date today=new Date();
        ca.setDate(simpleDateFormat.format(today));
        Contractos_AdopcionDAO.insertContract(ca);
        MascotaDAO.ModifyOwnerOfPet(newIDOwner,idPet);
    }

    public void seePeoples(JTable jTable){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[3];

        for (Persona p:peoplesList){
            if (p.getPerson_type().equals("cliente")){
                object[0]=p.getId();
                object[1]=p.getAllName();
                object[2]=p.getId_number();
                model.addRow(object);
            };
        }
        VAC.tablePeoples.setModel(model);
    }

    public void seePets(JTable jTable){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[3];

        for (Mascota m:petsList){
            if (m.getOwner_id()==0){
                object[0]=m.getId();
                object[1]=m.getNameP();
                object[2]=m.getBirth_date();
                model.addRow(object);
            };
        }
        VAC.tablePets.setModel(model);
    }


    public void PeetTableSearch(JTable jTable,String contain){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[3];

        for (Mascota m:petsList){
            if (m.getNameP().toLowerCase().contains(contain)){
                if (m.getOwner_id()==0){
                    object[0]=m.getId();
                    object[1]=m.getNameP();
                    object[2]=m.getBirth_date();
                    model.addRow(object);
                };
            }
        }
        VAC.tablePets.setModel(model);
    }
    public void PeoplesTableSearch(JTable table,String contain){
        model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        try {
            Object[] object=new Object[3];
            for (Persona p:peoplesList){
                String IDNumber=p.getId_number()+"";
                if (IDNumber.contains(contain)){
                    object[0]=p.getId();
                    object[1]=p.getAllName();
                    object[2]=p.getId_number();
                    model.addRow(object);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VAC.tablePeoples.setModel(model);
    }

    public void SearchInRealTimePeople(JTextField jTextField){
        jTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                PeoplesTableSearch(VAC.tablePeoples,jTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                PeoplesTableSearch(VAC.tablePeoples,jTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                PeoplesTableSearch(VAC.tablePeoples,jTextField.getText());
            }
        });
    }

    public void SearchInRealTimePet(JTextField jTextField){
        jTextField.getDocument().addDocumentListener(new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent e) {
                PeetTableSearch(VAC.tablePets,jTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                PeetTableSearch(VAC.tablePets,jTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                PeetTableSearch(VAC.tablePets,jTextField.getText());
            }
        });
    }
}
