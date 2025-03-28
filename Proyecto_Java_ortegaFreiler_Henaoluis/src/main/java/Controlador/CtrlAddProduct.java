package Controlador;

import Modelo.*;
import vista.ViewAddProduct;
import vista.ViewInventoryManagement;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CtrlAddProduct implements ActionListener {

    ViewAddProduct VAP;
    Persona people;

    public CtrlAddProduct(ViewAddProduct VAP, Persona people) {
        this.VAP = VAP;
        this.people = people;
        VAP.btnExit.addActionListener(this);
        VAP.btnAdd.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try{
            if (e.getSource()==VAP.btnExit){
                VAP.setVisible(false);
                ViewInventoryManagement VIM=new ViewInventoryManagement();
                VIM.setVisible(true);
                CtrlInventoryManagement CIM=new CtrlInventoryManagement(VIM,people);
            } else if (e.getSource()==VAP.btnAdd) {
                AddProduct();
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VAP,ex.getMessage());
        }
    }
    public void AddProduct() throws SQLException {
        Lote batch=new Lote();

        try {
            batch.setEntryQuantity(Integer.parseInt(VAP.inputEntryQuantity.getText()));
            batch.setCurrentQuantity(Integer.parseInt(VAP.inputEntryQuantity.getText()));

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Por favor ingresa una cantidad de producto valida");
        }

        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        batch.setExpirationDate(sdf.format(VAP.inputDate.getDate()));
        Date today=new Date();
        batch.setEntryDate(sdf.format(today));

        int idBatch= LoteDAO.insertBatch(batch);

        Medicamento medicine=new Medicamento();
        medicine.setName(VAP.inputName.getText());
        medicine.setBatchId(idBatch);
        medicine.setManufacturer(VAP.inputManufacturer.getText());
        medicine.setType(VAP.inputType.getText());
        medicine.setPresentation(VAP.inputPresentation.getText());

        try {
            medicine.setPrice(Integer.parseInt(VAP.inputPrice.getText()));

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Por favor ingresa un precio de producto valida");
        }

        MedicamentoDAO.insertMedicine(medicine);
    }
}
