package Controlador;

import Modelo.Mascota;
import Modelo.MascotaDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import vista.ViewAddPetWithOwner;
import vista.ViewPetsManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CtrlAddPetWithOwner implements ActionListener {

    ViewAddPetWithOwner VAPO;
    Persona people;
    DefaultTableModel model=new DefaultTableModel();

    public CtrlAddPetWithOwner(ViewAddPetWithOwner VAPO, Persona people) {
        this.VAPO = VAPO;
        this.people = people;
        PeoplesTable(this.VAPO.tablePeople);
        this.VAPO.btnExit.addActionListener(this);
        this.VAPO.btnAddPet.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource()==VAPO.btnExit){
                VAPO.setVisible(false);
                ViewPetsManagement VPetM=new ViewPetsManagement();
                VPetM.setVisible(true);
                CtrlPetsManagement CPM=new CtrlPetsManagement(VPetM,people);
            } else if (e.getSource()==VAPO.btnAddPet){
                AddPet();
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(VAPO,ex.getMessage());
        }

    }

    public void AddPet() throws SQLException {
        Mascota pet=new Mascota();
        pet.setNameP(VAPO.inputName.getText());
        pet.setSpecies(VAPO.inputSpecie.getText());
        pet.setBreed(VAPO.inputBreed.getText());
        try {
            pet.setAge(Integer.parseInt(VAPO.inputAge.getText()));
        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingresa una edad valida");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        pet.setBirth_date(sdf.format(VAPO.inputDate.getDate()));
        if (!VAPO.inputIdOwner.getText().trim().isEmpty()){
            try {
                pet.setOwner_id(Integer.parseInt(VAPO.inputIdOwner.getText()));
            }catch (NumberFormatException e){
                throw new NumberFormatException("Por favor ingresa un id de dueño valido");
            }
        }

        pet.setGender(VAPO.CombSex.getSelectedItem().toString());
        pet.setWeight(Double.parseDouble(VAPO.inputWeight.getText()));
        pet.setPhoto(VAPO.inputPhoto.getText());
        if (!VAPO.inputTatto.getText().trim().isEmpty()){
            pet.setTatto(VAPO.inputTatto.getText());
        }
        if (!VAPO.inputMicroChip.getText().trim().isEmpty()){
            pet.setMicroChip(VAPO.inputMicroChip.getText());
        }

        MascotaDAO.InsertPets(pet);

    }

    public void PeoplesTable(JTable table){
        model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        List<Persona> peoplesList = new ArrayList<>();
        try {
            peoplesList= PersonaDAO.getPeopleList();
            Object[] object=new Object[2];
            for (Persona p:peoplesList){
                if (p.getPerson_type().toLowerCase().equals("cliente")){
                    object[0]=p.getId();
                    object[1]=p.getAllName();
                    model.addRow(object);
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VAPO.tablePeople.setModel(model);
    }

}
