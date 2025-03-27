package Controlador;

import Modelo.*;
import vista.ViewInventoryManagement;
import vista.ViewSeeProducts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CtrlSeeProducts implements ActionListener {

    ViewSeeProducts VSP;
    Persona people;
    List<Medicamento> medicineList= MedicamentoDAO.getMedicineList();
    List<Lote> batchList= LoteDAO.getBatchList();
    DefaultTableModel model=new DefaultTableModel();

    public CtrlSeeProducts(ViewSeeProducts VSP, Persona people) throws SQLException {
        this.VSP = VSP;
        this.people = people;
        VSP.btnExit2.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VSP.btnExit2){
                VSP.setVisible(false);
                ViewInventoryManagement VIM=new ViewInventoryManagement();
                VIM.setVisible(true);
                CtrlInventoryManagement CIM=new CtrlInventoryManagement(VIM,people);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(VSP,ex.getMessage());
        }

    }

    public void seePrducts(JTable jTable){
        model=(DefaultTableModel)jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[11];

        for (Medicamento m:medicineList){
            object[0]=m.getId();
            object[1]=m.getName();
            object[2]=m.getManufacturer();
            object[3]=m.getType();
            object[4]=m.getPresentation();
            object[5]=m.getPrice();

            for (Lote l:batchList){
                if (m.getBatchId()==l.getId()){
                    object[6]=l.getId();
                    object[7]=m.getPrice();
                    object[8]=m.getPrice();
                    object[9]=m.getPrice();
                    object[10]=m.getPrice();
                }
            }
        }
    }
}
