package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.*;
import vista.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CtrlHealthHistory implements ActionListener {
    viewHealthHistory VHH;
    int idPeople;
    CtrlAppointmentsHistory CAH=new CtrlAppointmentsHistory();
    DefaultTableModel model =  new DefaultTableModel();
    PadecimientoDAO padecimientoDAO=new PadecimientoDAO();
    MascotaDAO mascotaDAO =new MascotaDAO();

    public CtrlHealthHistory(viewHealthHistory VHH, int id) {
        this.VHH = VHH;
        idPeople=id;
        CAH.seePets(VHH.tablePets,id);//se llama a la funcion que muestra las mascotas que tiene un dueño. esta funcion esta en la clase CtrlAppointmentsHistory
        VHH.btnViewH.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==VHH.btnViewH){

            try {
                int idPet;
                try {
                    idPet= Integer.parseInt(VHH.id_pet.getText());
                }catch (NumberFormatException i){
                    throw new NumberFormatException("Por favor ingrese un id valido");
                }
                boolean idPetExist=mascotaDAO.viewPetsByOwner(idPeople).stream().anyMatch(n -> n.getId()==idPet);
                if (idPetExist==true){
                    datesOFPet(idPet);
                    ConditionsOfPets(VHH.tableCondition,idPet);
                }
                else {
                    throw new SQLException("Por favor ingresa el id de una de tus mascotas");}

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(VHH, ex.getMessage());
            }


        }

    }
    public void datesOFPet(int idPet){
        Mascota pet;
        try {
            pet=mascotaDAO.getPetDates(idPet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        VHH.labelName.setText(pet.getNombre());
        VHH.labelSpecies.setText(pet.getEspecie());
        VHH.labelRace.setText(pet.getRaza());
        VHH.labelAge.setText(""+pet.getEdad()+" años");
        VHH.labelBirthDate.setText(pet.getFecha_nacimiento());
        VHH.labelSex.setText(pet.getSexo());
        VHH.labelWeight.setText(""+pet.getPeso());
        if (pet.getTatuaje()==null){
            VHH.labelTatto.setText("No aplica");
        } else if (pet.getMicroChip()==null) {
            VHH.labelMC.setText("No aplica");
        }
    }

    public void ConditionsOfPets(JTable table,int id){
        model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        List<Padecimiento> ConditionList = new ArrayList<>();
        try {
            ConditionList=padecimientoDAO.getConditionByPet(id);
            Object[] object=new Object[2];
            for (Padecimiento c:ConditionList){
                object[0]=c.getFecha_deteccion();
                object[1]=c.getDiagnostico();
                model.addRow(object);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VHH.tableCondition.setModel(model);
    }
}
