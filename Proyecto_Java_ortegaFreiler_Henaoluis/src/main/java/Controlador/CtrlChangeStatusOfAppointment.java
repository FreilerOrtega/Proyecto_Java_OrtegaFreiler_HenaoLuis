package Controlador;

import Modelo.*;
import vista.ViewAppointmentsManagement;
import vista.ViewChangeStatusOfAppointment;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CtrlChangeStatusOfAppointment implements ActionListener {

    ViewChangeStatusOfAppointment VCHOP;
    Persona people;
    List<Cita> appointmentsList= CitaDAO.getAllAppointments();
    DefaultTableModel model =new DefaultTableModel();
    List<Persona> peopleList= PersonaDAO.getPeopleList();
    List<Mascota> petsList=MascotaDAO.viewPetsList();

    public CtrlChangeStatusOfAppointment(ViewChangeStatusOfAppointment VCHOP, Persona people) throws SQLException {
        this.VCHOP = VCHOP;
        this.people = people;
        VCHOP.btnExit.addActionListener(this);
        VCHOP.btnChangeStatus.addActionListener(this);
        seeAppointments(VCHOP.appointmentsTable);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VCHOP.btnChangeStatus){
                changeStatus();
            } else if (e.getSource()==VCHOP.btnExit) {
                VCHOP.setVisible(false);
                ViewAppointmentsManagement VAM=new ViewAppointmentsManagement();
                VAM.setVisible(true);
                CtrlAppointmentsManagement CAP=new CtrlAppointmentsManagement(VAM,people);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VCHOP,ex.getMessage());
        }
    }
    public void seeAppointments(JTable jTable){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[7];

        for (Cita c:appointmentsList){
            object[0]=c.getId();
            for (Mascota m:petsList){
                if (c.getPet_id()==m.getId()){
                    object[1]=m.getNameP();
                };
            }
            for (Persona p:peopleList){
                if (c.getOwner_id()==p.getId()){
                    object[2]=p.getAllName();
                };
            }

            object[3]=c.getDates();
            object[4]=c.getHours();
            object[5]=c.getStatus();
            for (Persona p:peopleList){
                if (c.getVeterinarian_id()==p.getId()){
                    object[6]=p.getAllName();
                };
            }
            model.addRow(object);
        }
        VCHOP.appointmentsTable.setModel(model);
    }

    public void changeStatus() throws SQLException {
        String newStatus="";
        int appointmentID=0;
        try {
            appointmentID=Integer.parseInt(VCHOP.inputIDApp.getText());
        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingrese un ID de cita valido");
        }
        if (VCHOP.InputNewStatus.getSelectedItem().toString().equals("------")){
            throw new RuntimeException("Por favor selecciona un estado");
        }else {
            newStatus=VCHOP.InputNewStatus.getSelectedItem().toString();
        }
        CitaDAO.changeStatus(newStatus,appointmentID);
    }
}
