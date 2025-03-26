package Controlador;

import Modelo.Mascota;
import Modelo.MascotaDAO;
import Modelo.Persona;
import vista.ViewAddPetWithOutOwner;
import vista.ViewPetsManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CtrlAddPetWithOutOwner implements ActionListener {

    ViewAddPetWithOutOwner VAPWO;
    Persona people;

    public CtrlAddPetWithOutOwner(ViewAddPetWithOutOwner VAPWO, Persona people) {
        this.VAPWO = VAPWO;
        this.people = people;
        this.VAPWO.btnExit.addActionListener(this);
        this.VAPWO.btnAddPet.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VAPWO.btnExit){
                VAPWO.setVisible(false);
                ViewPetsManagement VPetM=new ViewPetsManagement();
                VPetM.setVisible(true);
                CtrlPetsManagement CPM=new CtrlPetsManagement(VPetM,people);
            } else if (e.getSource()==VAPWO.btnAddPet){
                AddPet();
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(VAPWO,ex.getMessage());
        }

    }
    public void AddPet() throws SQLException {
        Mascota pet=new Mascota();
        pet.setNameP(VAPWO.inputName.getText());
        pet.setSpecies(VAPWO.inputSpecie.getText());
        pet.setBreed(VAPWO.inputBreed.getText());
        try {
            pet.setAge(Integer.parseInt(VAPWO.inputAge.getText()));
        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingresa una edad valida");
        }
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        pet.setBirth_date(sdf.format(VAPWO.inputDate.getDate()));

        pet.setGender(VAPWO.CombSex.getSelectedItem().toString());
        pet.setWeight(Double.parseDouble(VAPWO.inputWeight.getText()));
        pet.setPhoto(VAPWO.inputPhoto.getText());
        if (!VAPWO.inputTatto.getText().trim().isEmpty()){
            pet.setTatto(VAPWO.inputTatto.getText());
        }
        if (!VAPWO.inputMicroChip.getText().trim().isEmpty()){
            pet.setMicroChip(VAPWO.inputMicroChip.getText());
        }

        MascotaDAO.InsertPets(pet);

    }
}
