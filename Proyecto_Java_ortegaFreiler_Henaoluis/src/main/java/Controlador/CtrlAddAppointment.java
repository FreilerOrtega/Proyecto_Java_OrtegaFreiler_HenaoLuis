package Controlador;

import Modelo.*;
import vista.ViewAddAppointment;
import vista.ViewAppointmentsManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CtrlAddAppointment implements ActionListener {
    ViewAddAppointment VAP;
    Persona people;
    List<Persona> peopleList= PersonaDAO.getPeopleList();
    List<Mascota> petsList= MascotaDAO.viewPetsList();
    DefaultTableModel model=new DefaultTableModel();

    public CtrlAddAppointment(ViewAddAppointment VAP, Persona people) throws SQLException {
        this.VAP = VAP;
        this.people = people;
        VAP.btnAddAppointment.addActionListener(this);
        VAP.btnExit.addActionListener(this);
        SeePets(VAP.tablePets);
        SeeVeterinarians(VAP.tableVeterinarians);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VAP.btnExit){
                VAP.setVisible(false);
                ViewAppointmentsManagement VAM=new ViewAppointmentsManagement();
                VAM.setVisible(true);
                CtrlAppointmentsManagement CAP=new CtrlAppointmentsManagement(VAM,people);
            } else if (e.getSource()==VAP.btnAddAppointment) {
                AddAppointment();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VAP,ex.getMessage());
        }
    }

    public void AddAppointment() throws SQLException {

        Cita appointment=new Cita();

        try {
            appointment.setPet_id(Integer.parseInt(VAP.inputIdPet.getText()));

            for (Mascota m:petsList){
                if (m.getId()==Integer.parseInt(VAP.inputIdPet.getText())){
                    appointment.setOwner_id(m.getOwner_id());
                }
            }
        }catch (NumberFormatException e) {
            throw new NumberFormatException("Ingresa un id de mascota valido");
        }

        try {
            appointment.setVeterinarian_id(Integer.parseInt(VAP.inputIdVeterinarian.getText()));
        }catch (NumberFormatException e){
            throw new NumberFormatException("Ingresa un id de veterinario valido");
        }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        appointment.setDates(sdf.format(VAP.inputDate.getDate()));

        appointment.setHours(VAP.inputHour.getText());
        appointment.setAttendance(false);
        appointment.setStatus("Programada");

        CitaDAO.InsertAppointments(appointment);
    }

    public void SeePets(JTable jTable ){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[3];
        for (Mascota m:petsList){
            object[0]=m.getId();
            object[1]=m.getNameP();
            object[2]="";
            for (Persona p:peopleList){
                if (m.getOwner_id()==p.getId()){
                    object[2]=p.getAllName();
                }
            }
            model.addRow(object);
        }

        VAP.tablePets.setModel(model);
    }


    public void SeeVeterinarians(JTable jTable ){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[3];

        for (Persona p:peopleList){
            if (p.getPerson_type().equals("veterinario")){
                object[0]=p.getId();
                object[1]=p.getAllName();
                object[2]=p.getId_number();
                model.addRow(object);
            }
        }
        VAP.tableVeterinarians.setModel(model);

    }

}
