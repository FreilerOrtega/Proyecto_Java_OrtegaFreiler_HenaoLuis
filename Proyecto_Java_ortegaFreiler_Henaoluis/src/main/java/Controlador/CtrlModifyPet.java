package Controlador;

import Modelo.Mascota;
import Modelo.MascotaDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import vista.ViewModifyPet;
import vista.ViewPetsManagement;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrlModifyPet implements ActionListener {

    ViewModifyPet VMP;
    Persona people;
    DefaultTableModel model=new DefaultTableModel();
    List<Mascota> petsList= MascotaDAO.viewPetsList();
    List<Persona> peopleList = PersonaDAO.getPeopleList();

    public CtrlModifyPet(ViewModifyPet VMP, Persona people) throws SQLException {
        this.VMP = VMP;
        this.people = people;
        PetsTable(VMP.tablePets);
        this.VMP.btnExit.addActionListener(this);
        this.VMP.btnAddPet.addActionListener(this);
        SearchInRealTimePet(VMP.inputSearchPet);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VMP.btnExit){
                VMP.setVisible(false);
                ViewPetsManagement VPetM=new ViewPetsManagement();
                VPetM.setVisible(true);
                CtrlPetsManagement CPM=new CtrlPetsManagement(VPetM,people);
            } else if (e.getSource()==VMP.btnAddPet){
                ModifyPet();
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(VMP,"error: "+ex.getMessage());
        }
    }

    public void ModifyPet() throws SQLException {


        Mascota oldPet=new Mascota();

        Mascota newPet=new Mascota();

        try{
            int idPet=Integer.parseInt(VMP.inputIdPet.getText());
            oldPet=MascotaDAO.getPetDates(idPet);
            newPet.setId(idPet);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingrese un id de mascota valido");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        newPet.setAge(VMP.inputAge.getText().trim().isEmpty() ? oldPet.getAge() : Integer.parseInt(VMP.inputAge.getText()));// verifica que el imput tenga informacion y en caso de que no tenga poner la direccion vieja
        newPet.setWeight(VMP.inputWeight.getText().trim().isEmpty() ? oldPet.getWeight() : Double.parseDouble(VMP.inputWeight.getText()));// verifica que el imput tenga informacion y en caso de que no tenga poner la direccion vieja
        newPet.setMicroChip(VMP.inputMicroChip.getText().trim().isEmpty() ? oldPet.getMicroChip() : VMP.inputMicroChip.getText());// verifica que el imput tenga informacion y en caso de que no tenga poner la direccion vieja

        MascotaDAO.ModifyPet(newPet);

    }

    public void PetsTable(JTable table) {
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try {

            Object[] object = new Object[4];
            for (Mascota m : petsList) {

                object[0] = m.getId();
                object[1] = m.getNameP();
                object[2] = m.getSpecies();
                object[3] = "";
                for (Persona p : peopleList) {
                    if (p.getId() == m.getOwner_id()) {
                        object[3] = p.getAllName();
                    }
                }
                model.addRow(object);

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VMP.tablePets.setModel(model);
    }

    public void PetsTableSearch(JTable table,String contain) {
        model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        try {

            Object[] object = new Object[4];
            for (Mascota m : petsList) {
                if (m.getNameP().toLowerCase().contains(contain)){

                    object[0] = m.getId();
                    object[1] = m.getNameP();
                    object[2] = m.getSpecies();
                    object[3] = "";
                    for (Persona p : peopleList) {
                        if (p.getId() == m.getOwner_id()) {
                            object[3] = p.getAllName();
                        }
                    }
                    model.addRow(object);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VMP.tablePets.setModel(model);
    }



    public void SearchInRealTimePet(JTextField jTextField){
        jTextField.getDocument().addDocumentListener(new DocumentListener() {



            @Override
            public void insertUpdate(DocumentEvent e) {
                PetsTableSearch(VMP.tablePets,jTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                PetsTableSearch(VMP.tablePets,jTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                PetsTableSearch(VMP.tablePets,jTextField.getText());
            }
        });
    }
}
