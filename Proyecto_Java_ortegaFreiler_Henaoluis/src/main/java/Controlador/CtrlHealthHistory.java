package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Modelo.*;
import vista.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CtrlHealthHistory implements ActionListener {
    viewHealthHistory VHH;
    int idPeople;
    CtrlAppointmentsHistory CAH=new CtrlAppointmentsHistory();
    DefaultTableModel model =  new DefaultTableModel();
    PadecimientoDAO padecimientoDAO=new PadecimientoDAO();
    MascotaDAO mascotaDAO =new MascotaDAO();
    Historial_vacunasDAO HVDAO=new Historial_vacunasDAO();
    MedicamentoDAO medicineDAO=new MedicamentoDAO();
    DesparacitacionesDAO DewDAO=new DesparacitacionesDAO();
    PersonaDAO peopleDAO=new PersonaDAO();

    List<Persona> peopleList=peopleDAO.getPeopleList();
    List<Medicamento> medicineList =medicineDAO.getMedicineList();

    public CtrlHealthHistory(viewHealthHistory VHH, int id) throws SQLException {
        this.VHH = VHH;
        idPeople=id;
        CAH.seePets(VHH.tablePets,id);//se llama a la funcion que muestra las mascotas que tiene un dueño. esta funcion esta en la clase CtrlAppointmentsHistory
        VHH.btnViewH.addActionListener(this);
        VHH.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==VHH.btnViewH){

            try {
                int idPet;
                try {
                    idPet= Integer.parseInt(VHH.id_pet.getText());
                }catch (NumberFormatException i){
                    throw new NumberFormatException("Por favor ingrese un id valido");
                }
                boolean idPetExist=mascotaDAO.viewPetsByOwner(idPeople).stream().anyMatch(n -> n.getId()==idPet);
                if (idPetExist==true){
                    datesOFPet(idPet);
                    ConditionsOfPets(VHH.tableCondition,idPet);
                    VaccineHistoryOfPets(VHH.tableVaccine,idPet);
                    DewormingsPet(VHH.tableDeworming,idPet);
                }
                else {
                    throw new SQLException("Por favor ingresa el id de una de tus mascotas");}

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(VHH, ex.getMessage());
            }


        }else if (e.getSource()==VHH.btnExit) {
            VHH.setVisible(false);
            try {
                Persona people=peopleDAO.SearchPeopleById(idPeople);
                viewOwnerHome VOH = new viewOwnerHome();
                VOH.setVisible(true);
                ctrlOwnerHome ctrOwHom = new ctrlOwnerHome(VOH, people);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
    public void datesOFPet(int idPet){
        Mascota pet;
        try {
            pet=mascotaDAO.getPetDates(idPet);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        VHH.labelName.setText(pet.getNameP());
        VHH.labelSpecies.setText(pet.getSpecies());
        VHH.labelRace.setText(pet.getBreed());
        VHH.labelAge.setText(""+pet.getAge()+" años");
        VHH.labelBirthDate.setText(pet.getBirth_date());
        VHH.labelSex.setText(pet.getGender());
        VHH.labelWeight.setText(""+pet.getWeight());
        if (pet.getTatto()==null){
            VHH.labelTatto.setText("No aplica");
        } else if (pet.getMicroChip()==null) {
            VHH.labelMC.setText("No aplica");
        }
    }

    public void ConditionsOfPets(JTable table,int id){
        model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        List<Padecimiento> ConditionList = new ArrayList<>();
        try {
            ConditionList=padecimientoDAO.getConditionByPet(id);
            Object[] object=new Object[2];
            for (Padecimiento c:ConditionList){
                object[0]=c.getDetection_date();
                object[1]=c.getDiagnosis();
                model.addRow(object);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VHH.tableCondition.setModel(model);
    }

    public void VaccineHistoryOfPets(JTable table,int id){
        model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);

        List<Historial_vacuna> vaccineList = new ArrayList<>();
        try {
            vaccineList=HVDAO.getVaccineHistoryByPet_id(id);


            Object[] object=new Object[3];
            for (Historial_vacuna HV:vaccineList){

                object[0]=GetMedicineName(HV.getVaccineId());
                object[1]=HV.getApplicationDate();
                object[2]=HV.getNextDose();
                model.addRow(object);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VHH.tableVaccine.setModel(model);
    }

    public void DewormingsPet(JTable table,int id){
        model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);

        List<Desparacitaciones> dewormingList=new ArrayList<>();
        try {
            dewormingList=DewDAO.getDewormingsBypetId(id);


            Object[] object=new Object[4];
            for (Desparacitaciones d:dewormingList){
                object[0]=GetPeopleName(d.getVeterinarianId());
                object[1]=GetMedicineName(d.getDoctorId());
                object[2]=d.getApplicationDate();
                object[3]=d.getNextApplication();
                model.addRow(object);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VHH.tableDeworming.setModel(model);
    }

    public String GetMedicineName(int id){
        String name="";
        for (Medicamento m:medicineList){
            if (m.getId()==id){
                name=m.getName();
            }
        }
        return name;
    }
    public String GetPeopleName(int id){
        String name="";
        for (Persona p:peopleList){
            if (p.getId()==id){
                name=p.getAllName();
            }
        }
        return name;
    }
}
