package Controlador;

import Modelo.*;
import com.mysql.cj.log.Log;
import vista.ViewAdministratorHome;
import vista.ViewInventoryManagement;
import vista.ViewSeeProducts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CtrlInventoryManagement implements ActionListener {

    ViewInventoryManagement VIM = new ViewInventoryManagement();
    Persona people;
    List<Medicamento> medicineList=MedicamentoDAO.getMedicineList();
    List<Lote> batchList=LoteDAO.getBatchList();


    DefaultTableModel model = new DefaultTableModel();

    public CtrlInventoryManagement(ViewInventoryManagement VIM, Persona people) throws SQLException, ParseException {
        this.VIM = VIM;
        this.people = people;
        this.VIM.btnAddProduct.addActionListener(this);
        this.VIM.btnViewProducts.addActionListener(this);
        this.VIM.btnExit.addActionListener(this);
        tableMedicineExpired( VIM.tableProductsEnd);
        ProductsResTock(VIM.tableProductCant);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == VIM.btnExit) {
                VIM.setVisible(false);
                ViewAdministratorHome VAH = new ViewAdministratorHome();
                VAH.setVisible(true);
                CtrlAdministratorHome CAH = new CtrlAdministratorHome(VAH, people);
            } else if (e.getSource()==VIM.btnViewProducts) {
                VIM.setVisible(false);
                ViewSeeProducts VSP=new ViewSeeProducts();
                VSP.setVisible(true);
                CtrlSeeProducts CSP=new CtrlSeeProducts(VSP,people);
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(VIM,ex.getMessage());
        }


    }

    public void tableMedicineExpired(JTable jTable) throws ParseException {
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] object = new Object[6];
        Date todayDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String todayFormat = simpleDateFormat.format(todayDate);
        Date today = simpleDateFormat.parse(todayFormat);

            for (Lote l : batchList) {

                Date Expired = simpleDateFormat.parse(l.getExpirationDate());
                long dif = Expired.getTime() - today.getTime();
                long diasDif = TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
                System.out.println(diasDif);
                if (diasDif>=0 && diasDif<=7){
                    for (Medicamento m : medicineList) {
                        if (m.getBatchId()==l.getId()){
                            object[0]=m.getId();
                            object[1]=m.getName();
                            object[2]=m.getPresentation();
                            object[3]=m.getBatchId();
                            object[4]=l.getExpirationDate();
                            object[5]=l.getCurrentQuantity();
                            model.addRow(object);
                        }
                    }
                };
            }

        VIM.tableProductsEnd.setModel(model);
    }

    public void ProductsResTock(JTable jTable){
        model=(DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] object=new Object[5];
        for (Lote l:batchList){
            if (l.getCurrentQuantity()<=10){
                for (Medicamento m:medicineList){
                    if (m.getBatchId()==l.getId()){
                        object[0]=m.getId();
                        object[1]=m.getName();
                        object[2]=m.getPresentation();
                        object[3]=m.getBatchId();
                        object[4]=l.getCurrentQuantity();
                        model.addRow(object);
                    }
                }
            }
        }
        VIM.tableProductCant.setModel(model);
    }

}
