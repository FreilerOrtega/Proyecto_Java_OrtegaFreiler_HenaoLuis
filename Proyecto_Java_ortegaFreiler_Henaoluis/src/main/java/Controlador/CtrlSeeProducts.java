package Controlador;

import Modelo.*;
import vista.ViewInventoryManagement;
import vista.ViewSeeProducts;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
        seePrducts(VSP.tableMedicines);
        searchProductInRealTime(VSP.inputSearchMedicine);
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
                    object[7]=l.getEntryDate();
                    object[8]=l.getEntryQuantity();
                    object[9]=l.getCurrentQuantity();
                    object[10]=l.getExpirationDate();
                    model.addRow(object);
                }
            }
        }
        VSP.tableMedicines.setModel(model);
    }


    public void seePrductsSearch(JTable jTable,String contain){
        model=(DefaultTableModel)jTable.getModel();
        model.setRowCount(0);

        Object[] object=new Object[11];

        for (Medicamento m:medicineList){
            if (m.getName().toLowerCase().contains(contain)){

                object[0]=m.getId();
                object[1]=m.getName();
                object[2]=m.getManufacturer();
                object[3]=m.getType();
                object[4]=m.getPresentation();
                object[5]=m.getPrice();

                for (Lote l:batchList){
                    if (m.getBatchId()==l.getId()){
                        object[6]=l.getId();
                        object[7]=l.getEntryDate();
                        object[8]=l.getEntryQuantity();
                        object[9]=l.getCurrentQuantity();
                        object[10]=l.getExpirationDate();
                    }
                }
                model.addRow(object);
            }
        }
        VSP.tableMedicines.setModel(model);
    }


    public void searchProductInRealTime(JTextField jTextField){
        jTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                seePrductsSearch(VSP.tableMedicines,jTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                seePrductsSearch(VSP.tableMedicines,jTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                seePrductsSearch(VSP.tableMedicines,jTextField.getText());
            }
        });
    }
}
