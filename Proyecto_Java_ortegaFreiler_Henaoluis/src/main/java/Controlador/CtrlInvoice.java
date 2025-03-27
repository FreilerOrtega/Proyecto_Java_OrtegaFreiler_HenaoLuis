package Controlador;

import Modelo.Persona;
import Modelo.PersonaDAO;
import vista.ViewAddInvoice;
import vista.viewInvoice;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class CtrlInvoice implements ActionListener {
    viewInvoice VI;
    Persona people;
    Object[] peopleAndFacture;
    List<Object[]> medicineListInvoice;
    int totalEnd=0;
    DefaultTableModel model=new DefaultTableModel();

    public CtrlInvoice(viewInvoice VI, Persona people, Object[] peopleAndFacture, List<Object[]> medicineListInvoice) {
        this.VI = VI;
        this.people = people;
        this.peopleAndFacture = peopleAndFacture;
        this.medicineListInvoice=medicineListInvoice;
        this.VI.btnExit.addActionListener(this);
        try {
            viewOwnerdates();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(VI,e.getMessage());
        }
        viewMedicineAdded(VI.table);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource()==VI.btnExit){
                VI.setVisible(false);
                ViewAddInvoice VAI = new ViewAddInvoice();
                VAI.setVisible(true);
                CtrlAddInvoice CAI = new CtrlAddInvoice(VAI, people);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(VI,ex.getMessage());
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
        VI.full.setText(totalEnd+"");
        VI.table.setModel(model);
    }

    public void viewOwnerdates() throws SQLException {
        Persona owner= PersonaDAO.SearchPeopleById((int)peopleAndFacture[1]);

        VI.nameCostumer.setText(owner.getAllName());
        VI.documentCostumer.setText(owner.getId_number()+"");
        VI.labelAddres.setText(owner.getAddress());
    }


}
