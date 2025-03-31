package Controlador;

import Modelo.*;
import vista.AddDiagnosis;
import vista.AddVaccination;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class crtlVaccine implements ActionListener {
    AddVaccination addVaccination ;
    List<Lote> batchList= LoteDAO.getBatchList();
    List<Medicamento> medicineList= MedicamentoDAO.getMedicineList();
    int idvaccine;
    Persona people;
    DefaultTableModel model;

    public crtlVaccine(AddVaccination addVaccination, Persona people) throws SQLException {
        this.addVaccination = addVaccination;
        this.people = people;
        this.idvaccine = 0;
        this.addVaccination.ButtonBackVaccination.addActionListener(this);
        this.addVaccination.ButtonAignarMedicamento.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        try{
            if (e.getSource()==addVaccination.ButtonBackVaccination){
                addVaccination.setVisible(false);
                AddDiagnosis addDiagnosis = new AddDiagnosis();
                addDiagnosis.setVisible(true);
                CtrlAddDiagnosis ctrlAddDiagnosis = new CtrlAddDiagnosis(addDiagnosis,people);
            } else if(e.getSource()==addVaccination.ButtonAignarMedicamento){
                addvaccination();


            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(addVaccination,ex.getMessage());
        }



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
        addVaccination.TableIdMedicamento2.setModel(model);
    }

    public void addvaccination () throws SQLException {
        Historial_vacuna historialVacuna = new Historial_vacuna();
        try {
            if (!addVaccination.IDvaccination.getText().trim().isEmpty()){
                historialVacuna.setVaccineId(Integer.parseInt(addVaccination.IDvaccination.getText()));
            } else {
                throw new RuntimeException("por favor ingrese un id de medicamento");

            }

        }catch (NumberFormatException es){
            throw new NumberFormatException("Por Favor Ingrese Un Id De medicamento  Valido");
        }
        //OBTENER DATOS DESDE LOS INPUTS PARA PODER AGREGARLOS AL BASE DE DATOS

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        historialVacuna.setNextDose(simpleDateFormat.format(addVaccination.inputDate.getDate()));
        Historial_vacunasDAO.insertvaccination(historialVacuna);
    }

    // Cargar los medicamentos disponibles en la tabla
    public void getMedicines2(JTable jTable) {
        model = (DefaultTableModel) jTable.getModel();
        model.setRowCount(0);
        Object[] object = new Object[4];

        for (Medicamento m : medicineList) {
            object[0] = m.getId();
            object[1] = m.getName();
            object[2] = m.getPresentation();
            for (Lote l : batchList) {
                if (l.getId() == m.getBatchId()) {
                    object[3] = l.getCurrentQuantity();
                }
            }
            model.addRow(object);
        }
        addVaccination.TableIdMedicamento2.setModel(model);
    }
}
