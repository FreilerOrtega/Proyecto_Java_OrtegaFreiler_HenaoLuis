package Controlador;

import Modelo.*;
import vista.ViewContractManagement;
import vista.ViewSeeTrackingOfContract;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CtrlSeeTrackingOfContract implements ActionListener {

    ViewSeeTrackingOfContract VSTOC;
    Persona people;
    DefaultTableModel model=new DefaultTableModel();
    List<Mascota> petsList= MascotaDAO.viewPetsList();
    List<Persona> peoplesList= PersonaDAO.getPeopleList();
    List<Seguimiento_PostAdopcion> spList=Seguimiento_postAdopcionDAO.getAllFollowUps();
    List<Contractos_Adopcion> caList=Contractos_AdopcionDAO.getAllContracts();

    public CtrlSeeTrackingOfContract(ViewSeeTrackingOfContract VSTOC, Persona people) throws SQLException {
        this.VSTOC = VSTOC;
        this.people = people;
        VSTOC.btnExit2.addActionListener(this);
        VSTOC.btnSee.addActionListener(this);
        SeeContracts(VSTOC.tableContracts);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VSTOC.btnExit2){
                VSTOC.setVisible(false);
                ViewContractManagement VCM=new ViewContractManagement();
                VCM.setVisible(true);
                CtrlContractManagement CCM=new CtrlContractManagement(VCM,people);
            } else if (e.getSource()==VSTOC.btnSee) {
                SeeContractsTraking(VSTOC.tableTraking);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VSTOC,ex.getMessage());
        }
    }

    public void SeeContractsTraking(JTable jTable ){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        int idContract=0;
        try {
            idContract=Integer.parseInt(VSTOC.inputContractId.getText());
        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingresa un id de contrato valido");
        }
        Object[] object=new Object[3];

        for (Seguimiento_PostAdopcion sp:spList){
            if (sp.getContractId()==idContract){
                object[0]=sp.getAppointment_number();
                object[1]=sp.getDetails();
                object[2]=sp.getDate();
                model.addRow(object);
            }
        }

        VSTOC.tableTraking.setModel(model);
    }

    public void SeeContracts(JTable jTable ){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[4];

        for (Contractos_Adopcion ca:caList){
            object[0]=ca.getId();

            for (Mascota m:petsList){
                if (ca.getPetId()==m.getId()){
                    object[1]=m.getNameP();
                }
            }

            for (Persona p:peoplesList){
                if (ca.getOwnerId()==p.getId()){
                    object[2]=p.getAllName();
                }
            }
            object[3]=ca.getDate();
            model.addRow(object);
        }
        VSTOC.tableContracts.setModel(model);
    }
}
