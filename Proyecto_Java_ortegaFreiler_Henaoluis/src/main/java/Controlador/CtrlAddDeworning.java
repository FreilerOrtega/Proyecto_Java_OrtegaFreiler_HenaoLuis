package Controlador;

import Modelo.*;
import vista.AddDeworning;
import vista.AddDiagnosis;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class CtrlAddDeworning implements ActionListener {
    List<Lote> batchList = LoteDAO.getBatchList();
    List<Medicamento> medicineList = MedicamentoDAO.getMedicineList();
    AddDeworning addDeworning;
    Persona people;
    DefaultTableModel model;

    public CtrlAddDeworning(AddDeworning addDeworning, Persona people) throws SQLException {
        this.addDeworning = addDeworning;
        this.people = people;

        this.addDeworning.ButtonAddDeworming.addActionListener(this);
        this.addDeworning.ButtonBackDeworming.addActionListener(this);


        getMedicines(addDeworning.TableIdMedicamento);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == addDeworning.ButtonBackDeworming) {

                addDeworning.setVisible(false);
                AddDiagnosis addDiagnosis = new AddDiagnosis();
                addDiagnosis.setVisible(true);
                CtrlAddDiagnosis ctrlAddDiagnosis = new CtrlAddDiagnosis(addDiagnosis, people);
            } else if (e.getSource() == addDeworning.ButtonAddDeworming) {

                addDeworning();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(addDeworning, ex.getMessage());
        }
    }

    // Cargar los medicamentos disponibles en la tabla
    public void getMedicines(JTable jTable) {
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
        addDeworning.TableIdMedicamento.setModel(model);
    }





    public void addDeworning() throws SQLException {
        Desparacitaciones desparacitaciones = new Desparacitaciones();
        try {
                      if (!addDeworning.TextidMediacamento.getText().trim().isEmpty()) {
                desparacitaciones.setMedicine_id(Integer.parseInt(addDeworning.TextidMediacamento.getText()));
            } else {
                throw new RuntimeException("Por favor ingrese un id de medicamento");
            }


            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            desparacitaciones.setApplicationDate(simpleDateFormat.format(addDeworning.inputDate.getDate()));


            DesparacitacionesDAO.insertDeworning(desparacitaciones);


            getMedicines(addDeworning.TableIdMedicamento);

        } catch (NumberFormatException es) {
            throw new NumberFormatException("Por Favor Ingrese Un Id De Medicamento Válido");
        }
    }
}
