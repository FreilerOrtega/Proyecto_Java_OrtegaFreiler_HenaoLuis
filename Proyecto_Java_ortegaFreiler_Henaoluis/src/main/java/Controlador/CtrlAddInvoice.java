package Controlador;

import Modelo.*;
import vista.ViewAddInvoice;
import vista.ViewAdministratorHome;
import vista.viewInvoice;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CtrlAddInvoice implements ActionListener {

    ViewAddInvoice VAI;
    Persona people;
    DefaultTableModel model=new DefaultTableModel();
    List<Persona> peopleList= PersonaDAO.getPeopleList();
    List<Medicamento> medicineList= MedicamentoDAO.getMedicineList();
    List<Lote> batchList=LoteDAO.getBatchList();
    List<Object[]> medicineListInvoice=new ArrayList<>();
    int totalEnd=0;
    int idOwner;


    public CtrlAddInvoice(ViewAddInvoice VAI, Persona people) throws SQLException {
        this.VAI = VAI;
        this.people = people;
        getPeoples(VAI.tablePeople);
        getMedicines(VAI.tableProduct);
        VAI.full.setText("-----");
        this.VAI.btnAddProduct.addActionListener(this);
        this.VAI.btnExit.addActionListener(this);
        this.VAI.btnFactureAdd.addActionListener(this);
        SearchInRealTimePeople(VAI.inputSearchName);
        SearchInRealTimeProducts(VAI.inputSearchProduct);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VAI.btnExit){
                VAI.setVisible(false);
                ViewAdministratorHome VAH = new ViewAdministratorHome();
                VAH.setVisible(true);
                CtrlAdministratorHome CAH=new CtrlAdministratorHome(VAH,people);
            } else if (e.getSource()==VAI.btnAddProduct) {
                addProduct();
                getMedicines(VAI.tableProduct);
                viewMedicineAdded(VAI.tableProductFacture);
            } else if (e.getSource()==VAI.btnFactureAdd) {
                int idFacture=AddFacture();
                VAI.setVisible(false);
                viewInvoice VI=new viewInvoice();
                VI.setVisible(true);
                Object[] peopleAndFacture={idFacture,idOwner};
                CtrlInvoice CI=new CtrlInvoice(VI,people,peopleAndFacture,medicineListInvoice);
                FacturaPDF.GenerateFacture(idOwner,medicineListInvoice,idFacture);
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(VAI,ex.getMessage());
        }

    }

    public void viewMedicineAdded(JTable jTable){
        totalEnd=0;
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] object=new Object[4];

        for (Object[] o:medicineListInvoice) {
            object[0] = o[1];
            object[1] = o[2];
            object[2] = o[3];
            object[3] = o[4];
            totalEnd=totalEnd+((int) o[4]);
            model.addRow(object);
        }
        VAI.full.setText(totalEnd+"");
        VAI.tableProductFacture.setModel(model);
        VAI.idProductAdd.setText("");
        VAI.countProductAdd.setText("1");
    }

    public int AddFacture() throws SQLException {
        Facturas facture=new Facturas();
        try {
            idOwner=Integer.parseInt(VAI.id_people.getText());
            facture.setClientId(idOwner);
        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingresa un id de cliente valido");
        }
        facture.setDescription(VAI.inputDescripcion.getText());
        facture.setTotal(totalEnd);
        LocalDate actualDate = LocalDate.now();
        DateTimeFormatter formatDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String DateOk = actualDate.format(formatDate);
        facture.setDate(DateOk);

        int idFactura=FacturasDAO.insertFacture(facture);

        for(Object[] o:medicineListInvoice){
            Medicamento_factura mf=new Medicamento_factura();
            mf.setInvoice_id(idFactura);
            mf.setMedicationId((int) o[0]);
            mf.setQuantity((int) o[2]);
            Medicamento_facturaDAO.InsertMF(mf);
        }
        return idFactura;
    }

    public void addProduct() throws SQLException {
        Object[] object=new Object[5];
        int idProduct=0;
        int price=0;
        int count=0;
        int oldCount=0;
        try {
            idProduct=Integer.parseInt(VAI.idProductAdd.getText());
            object[0]=idProduct;
            for(Medicamento m:medicineList){
                if (m.getId()==idProduct){
                    for (Lote l:batchList){
                        if (l.getId()==m.getBatchId()){
                            oldCount=l.getCurrentQuantity();
                        }
                    }
                }
            }
        }catch (NumberFormatException e) {
            throw new NumberFormatException("Por favor ingresa un id de producto valido");
        }

        try {
            count=Integer.parseInt(VAI.countProductAdd.getText());
            if (count>oldCount){
                throw new RuntimeException("Por favor ingresa una cantidad menor o igual a la disponible");
            }
            object[2]=count;

        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingresa una cantidad valida");
        }

        for (Medicamento m:medicineList){
            if (m.getId()==idProduct){
                object[1]=m.getName();
                object[3]=m.getPrice();
                price=m.getPrice();
            }
        }
        LoteDAO.subtractMedicine(idProduct,count);
        int total=price*count;

        object[4]=total;


        medicineListInvoice.add(object);
        batchList=LoteDAO.getBatchList();

    };

    public void getPeoples(JTable jTable){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] object=new Object[3];

        for (Persona p:peopleList){
            object[0]=p.getId();
            object[1]=p.getAllName();
            object[2]=p.getId_number();
            model.addRow(object);
        }
        VAI.tablePeople.setModel(model);
    }

    public void getPeoplesSearch(JTable jTable,String contain){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] object=new Object[3];

        for (Persona p:peopleList){
            String IDNumber=p.getId_number()+"";
            if (IDNumber.contains(contain)){
                object[0]=p.getId();
                object[1]=p.getAllName();
                object[2]=p.getId_number();
                model.addRow(object);
            }
        }
        VAI.tablePeople.setModel(model);
    }

    public void getMedicines(JTable jTable){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] object=new Object[4];

        for (Medicamento m:medicineList){

            object[0]=m.getId();
            object[1]=m.getName();
            object[2]=m.getPresentation();
            for(Lote l: batchList){
                if (l.getId()==m.getBatchId()){
                    object[3]=l.getCurrentQuantity();
                }
            }
            model.addRow(object);
        }
        VAI.tableProduct.setModel(model);
    }

    public void getMedicinesSearch(JTable jTable,String contain){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] object=new Object[4];

        for (Medicamento m:medicineList){
            if (m.getName().toLowerCase().contains(contain)){
                object[0]=m.getId();
                object[1]=m.getName();
                object[2]=m.getPresentation();
                for(Lote l: batchList){
                    if (l.getId()==m.getBatchId()){
                        object[3]=l.getCurrentQuantity();
                    }
                }
                model.addRow(object);
            }
        }
        VAI.tableProduct.setModel(model);
    }
    public void SearchInRealTimePeople(JTextField jTextField){
        jTextField.getDocument().addDocumentListener(new DocumentListener() {



            @Override
            public void insertUpdate(DocumentEvent e) {
                getPeoplesSearch(VAI.tablePeople,jTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getPeoplesSearch(VAI.tablePeople,jTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getPeoplesSearch(VAI.tablePeople,jTextField.getText());
            }
        });
    }

    public void SearchInRealTimeProducts(JTextField jTextField){
        jTextField.getDocument().addDocumentListener(new DocumentListener() {



            @Override
            public void insertUpdate(DocumentEvent e) {
                getMedicinesSearch(VAI.tableProduct,jTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                getMedicinesSearch(VAI.tableProduct,jTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                getMedicinesSearch(VAI.tableProduct,jTextField.getText());
            }
        });
    }
}
