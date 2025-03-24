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

public class CtrlAppointmentsHistory implements ActionListener {
    private int idPeople;
    viewAppointmentsHistory VAP=new viewAppointmentsHistory();
    DefaultTableModel model =  new DefaultTableModel();
    Persona people=new Persona();
    MascotaDAO mascotaDAO= new MascotaDAO();
    PersonaDAO peopleDao=new PersonaDAO();

    public CtrlAppointmentsHistory(){};

        public CtrlAppointmentsHistory(viewAppointmentsHistory VAP,int id) {
        this.VAP = VAP;
        idPeople=id;
        seePets(VAP.tablePets,id);
        VAP.btnViewHistory.addActionListener(this);
        VAP.btnExit.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==VAP.btnViewHistory){
            try {
                try {
                    int idPet=Integer.parseInt(VAP.idPet.getText());
                    //se obtienen las mascotas de la persona que inicio secion para ver si el id que ingresa es de su mascota
                    boolean idPetExist=mascotaDAO.viewPetsByOwner(idPeople).stream().anyMatch(n -> n.getId()==idPet);
                    if (idPetExist==true){
                        seeAppointmentPets(VAP.tableHistoryPet,idPet);
                    }
                    else {
                        throw new SQLException("Por favor ingresa el id de una de tus mascotas");
                    }
                }catch (NumberFormatException i){
                    throw new RuntimeException("Por favor ingresa un id valido");//en caso de que ingresen una letra en el imput maneja el error
                }
            }catch (Exception i){
                JOptionPane.showMessageDialog(VAP, i.getMessage());
            }
        }
        if (e.getSource()==VAP.btnExit) {
            System.out.println("Hola");
            VAP.setVisible(false);
            try {
                people=peopleDao.SearchPeopleById(idPeople);
                viewOwnerHome VOH = new viewOwnerHome();
                VOH.setVisible(true);
                ctrlOwnerHome ctrOwHom = new ctrlOwnerHome(VOH, people);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(VAP, ex.getMessage());
            }
        }

    }

    public void seeAppointmentPets(JTable jTable,int id){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        CitaDAO citaDAO= new CitaDAO();
        List<Cita>appointmentLis= new ArrayList<>();
        try {
            appointmentLis=citaDAO.viewPetsAppointments(id);// la funcion retorna todas las citas en las que aparece una mascota
            Object[] object=new Object[3];
            for(Cita c:appointmentLis){

                object[0]=c.getDates();

                people=peopleDao.SearchPeopleById(c.getVeterinarian_id());// se obtiene el veterinario para poder saber el nombre con base en su id

                object[1]=people.getAllName();
                object[2]=c.getStatus();
                model.addRow(object);
            }
            VAP.tableHistoryPet.setModel(model);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void seePets(JTable jTable, int peopleID) {
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        List<Mascota>petLis= new ArrayList<>();
        try {
            petLis=mascotaDAO.viewPetsByOwner(peopleID);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Object[] object=new Object[2];
        for(Mascota m:petLis){
            object[0]=m.getId();
            object[1]=m.getNameP();
            model.addRow(object);
        }
        VAP.tablePets.setModel(model);
    }
}
