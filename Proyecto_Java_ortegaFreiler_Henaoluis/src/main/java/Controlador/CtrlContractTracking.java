package Controlador;

import Modelo.*;
import vista.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CtrlContractTracking implements ActionListener {

    ViewContractTracking VCT;
    Persona people;
    DefaultTableModel model=new DefaultTableModel();
    List<Contractos_Adopcion> caList=Contractos_AdopcionDAO.getAllContracts();
    List<Persona> peopleList=PersonaDAO.getPeopleList();
    List<Mascota> petsList=MascotaDAO.viewPetsList();
    List<Seguimiento_PostAdopcion> SPList=Seguimiento_postAdopcionDAO.getAllFollowUps();

    public CtrlContractTracking(ViewContractTracking VCT, Persona people) throws SQLException {
        this.VCT = VCT;
        this.people = people;
        VCT.btnExit.addActionListener(this);
        VCT.btnAddTracking.addActionListener(this);
        SeeContracts(VCT.tableContracts);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VCT.btnExit){
                VCT.setVisible(false);
                ViewContractManagement VCM=new ViewContractManagement();
                VCM.setVisible(true);
                CtrlContractManagement CCM=new CtrlContractManagement(VCM,people);
            } else if (e.getSource()==VCT.btnAddTracking) {
                generateTraking();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VCT,ex.getMessage());
        }
    }

    public void generateTraking() throws SQLException {
        Seguimiento_PostAdopcion sp=new Seguimiento_PostAdopcion();
        int IDContract;
        try {
            sp.setContractId(Integer.parseInt(VCT.inputContractId.getText()));
            IDContract=Integer.parseInt(VCT.inputContractId.getText());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Por favor ingrese un id de contrato valido");
        }
        sp.setDetails(VCT.inputDetails.getText());

        int numberVisit=1;
        for (Seguimiento_PostAdopcion spa:SPList){
            if (spa.getContractId()==IDContract){
                numberVisit++;
            }
        };
        sp.setAppointment_number(numberVisit);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date today=new Date();
        sp.setDate(simpleDateFormat.format(today));

        Seguimiento_postAdopcionDAO.insertContract(sp);

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
            for (Persona p:peopleList){
                if (ca.getOwnerId()==p.getId()){

                    object[2]=p.getAllName();
                }
            }
            object[3]=ca.getDate();
            model.addRow(object);
        }
        VCT.tableContracts.setModel(model);
    }
}
