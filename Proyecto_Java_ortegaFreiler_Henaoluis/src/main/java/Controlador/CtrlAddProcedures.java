package Controlador;

import Modelo.Conect;
import Modelo.Persona;
import Modelo.Procedimientos;
import Modelo.ProdecimientosDAO;
import vista.AddDiagnosis;
import vista.AddProcedure;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CtrlAddProcedures implements ActionListener {
    AddProcedure addProcedure = new AddProcedure();
    Persona people;
    int IdAppointment;

    public CtrlAddProcedures(AddProcedure addProcedure, Persona people,int IdAppointment) {
        this.addProcedure = addProcedure;
        this.people = people;
        this.IdAppointment=IdAppointment;
        this.addProcedure.ButtonAddNewProcedure.addActionListener(this);
        this.addProcedure.ButtonBackProcedures.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            if (e.getSource()==addProcedure.ButtonBackProcedures){
                addProcedure.setVisible(false);
                AddDiagnosis addDiagnosis = new AddDiagnosis();
                addDiagnosis.setVisible(true);
                CtrlAddDiagnosis ctrlAddDiagnosis = new CtrlAddDiagnosis(addDiagnosis,people);

            } else if (e.getSource()==addProcedure.ButtonAddNewProcedure) {
                addprocedurer();


            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(addProcedure,ex.getMessage());

        }
    }

    public void addprocedurer() throws SQLException {
        Procedimientos procedimientos = new Procedimientos();
        try {
            if (!addProcedure.IDMASCOTA.getText().trim().isEmpty()) {
                procedimientos.setPet_id(Integer.parseInt(addProcedure.IDMASCOTA.getText()));
            } else {
                throw new RuntimeException("por favor ingrese un id de mascota");
            }
        } catch (NumberFormatException es) {
            throw new NumberFormatException("Por Favor Ingrese Un Id De mascota Valido");
        }


        procedimientos.setProcedurer(addProcedure.TEXTPROCEDIMIENTO.getText());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        procedimientos.setDates(simpleDateFormat.format(addProcedure.inputDate.getDate()));
        procedimientos.setVeterinarian_id(people.getId());
        procedimientos.setAppointment_id(IdAppointment);


        System.out.println("Veterinarian ID: " + procedimientos.getVeterinarian_id());
        System.out.println("Appointment ID: " + procedimientos.getAppointment_id());


        ProdecimientosDAO.insertProcedure(procedimientos);
    }

}
