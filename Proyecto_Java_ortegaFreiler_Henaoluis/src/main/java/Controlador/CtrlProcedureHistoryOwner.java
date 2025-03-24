package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import Modelo.*;
import vista.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CtrlProcedureHistoryOwner implements ActionListener {

    viewVaccineHistory VVH=new viewVaccineHistory();
    int id_people;
    DefaultTableModel model=new DefaultTableModel();
    CtrlAppointmentsHistory CAH=new CtrlAppointmentsHistory();
    List<Persona> peopleList=PersonaDAO.getPeopleList();

    public CtrlProcedureHistoryOwner(viewVaccineHistory VVH, int id_people) throws SQLException {
        this.VVH = VVH;
        this.id_people = id_people;
        CAH.seePets(VVH.tablePets,this.id_people);
        this.VVH.btnExit.addActionListener(this);
        this.VVH.btnShowPets.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VVH.btnShowPets){

                int idPet;
                try {
                    idPet= Integer.parseInt(VVH.id_pet.getText());
                }catch (NumberFormatException i){
                    throw new NumberFormatException("Por favor ingrese un id valido");
                }
                boolean idPetExist= MascotaDAO.viewPetsByOwner(id_people).stream().anyMatch(n -> n.getId()==idPet);
                if (idPetExist==true){
                    getProceduresOfPets(VVH.tableHistory,idPet);
                }
                else {
                    throw new SQLException("Por favor ingresa el id de una de tus mascotas");
                }
            }
            if (e.getSource()==VVH.btnExit) {
                VVH.setVisible(false);

                Persona people= PersonaDAO.SearchPeopleById(id_people);
                viewOwnerHome VOH = new viewOwnerHome();
                VOH.setVisible(true);
                ctrlOwnerHome ctrOwHom = new ctrlOwnerHome(VOH, people);

            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(VVH,ex.getMessage());
        }

    }
    public void getProceduresOfPets(JTable jTable,int  idPet) throws SQLException {
        model=(DefaultTableModel)jTable.getModel();
        model.setRowCount(0);

        List<Procedimientos> proceduresList=ProdecimientosDAO.getProceduresByPetId(idPet);

        Object[] object=new Object[3];
        for (Procedimientos p:proceduresList){
            object[0]=p.getProcedurer();
            object[1]=p.getDates();
            object[2]=getVeterinarianName(p.getVeterinarian_id());
            model.addRow(object);
        }
        VVH.tableHistory.setModel(model);
    }
    public String getVeterinarianName(int id){
        String name="";

        for (Persona p: peopleList){
            if(p.getId()==id){
                name=p.getAllName();
            }
        }

        return name;
    };
}
