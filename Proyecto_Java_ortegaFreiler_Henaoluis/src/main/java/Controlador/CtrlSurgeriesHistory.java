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

public class CtrlSurgeriesHistory implements ActionListener {
    viewSurgeriesHistory VSH;
    int id_people;
    DefaultTableModel model=new DefaultTableModel();
    CtrlAppointmentsHistory CAH=new CtrlAppointmentsHistory();
    List<Persona> peopleList=PersonaDAO.getPeopleList();


    public CtrlSurgeriesHistory(viewSurgeriesHistory VSH, int id_people) throws SQLException {
        this.VSH = VSH;
        this.id_people = id_people;
        CAH.seePets(VSH.tablePets,this.id_people);
        this.VSH.btnExit.addActionListener(this);
        this.VSH.btnIdPet.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VSH.btnIdPet){

                int idPet;
                try {
                    idPet= Integer.parseInt(VSH.id_pet.getText());
                }catch (NumberFormatException i){
                    throw new NumberFormatException("Por favor ingrese un id valido");
                }
                boolean idPetExist=MascotaDAO.viewPetsByOwner(id_people).stream().anyMatch(n -> n.getId()==idPet);
                if (idPetExist==true){
                    getSugeriesOfPet(VSH.tableSugeries,idPet);
                }
                else {
                    throw new SQLException("Por favor ingresa el id de una de tus mascotas");
                }
            }
            if (e.getSource()==VSH.btnExit) {
                VSH.setVisible(false);

                Persona people= PersonaDAO.SearchPeopleById(id_people);
                viewOwnerHome VOH = new viewOwnerHome();
                VOH.setVisible(true);
                ctrlOwnerHome ctrOwHom = new ctrlOwnerHome(VOH, people);

            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(VSH,ex.getMessage());
        }
    }

    public void getSugeriesOfPet(JTable jTable,int idPet) throws SQLException {
        List<Cirujias> sugeriesList=CirujiasDAO.getSurgeriesListByPetID(idPet);

        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[4];
        for(Cirujias c:sugeriesList){
            object[0]=getNameVeterinarian(c.getVeterinarianId());
            object[1]=c.getSurgeryDate();
            object[2]=c.getRecoveryDays();
            object[3]=c.getRecovery_status();
            model.addRow(object);
        }
        VSH.tableSugeries.setModel(model);
    };

    public String getNameVeterinarian(int id_veterinarian){
        String name="";
        for (Persona p:peopleList){
            if (p.getId()==id_veterinarian){
                name=p.getAllName();
            }
        }
        return name;
    }

}
