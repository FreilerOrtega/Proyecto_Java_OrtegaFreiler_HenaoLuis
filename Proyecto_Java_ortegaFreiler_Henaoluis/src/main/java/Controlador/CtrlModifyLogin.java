package Controlador;

import Modelo.Login;
import Modelo.LoginDAO;
import Modelo.Persona;
import Modelo.PersonaDAO;
import vista.ViewModifyLogin;
import vista.ViewPeoplesManagement;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CtrlModifyLogin implements ActionListener {

    ViewModifyLogin VML;
    Persona people;
    DefaultTableModel model =  new DefaultTableModel();

    public CtrlModifyLogin(ViewModifyLogin VML, Persona people) {
        this.VML = VML;
        this.people = people;
        PeoplesTable(VML.tablePeoples);
        this.VML.btnModify.addActionListener(this);
        this.VML.btnExit.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource()==VML.btnExit){
                VML.setVisible(false);
                ViewPeoplesManagement VPM=new ViewPeoplesManagement();
                VPM.setVisible(true);
                CtrlPeoplesManagement CPM=new CtrlPeoplesManagement(VPM,people);
            } else if (e.getSource()==VML.btnModify) {
                ModifyLogin();
            }

        }catch (Exception ex){
            JOptionPane.showMessageDialog(VML,ex.getMessage());
        }

    }

    public void ModifyLogin() throws SQLException {
        Login oldLogin=new Login();
        Login newLogin=new Login();


        try{
            int idPeople=Integer.parseInt(VML.inputPeople.getText());// se verifica de que la persona haya ingresado un numero
            oldLogin= LoginDAO.searchByPeopleID(idPeople);// se obtienen los datos de la persona en caso de que no valla a modificar algun dto permanezca igual
            newLogin.setPersonId(idPeople);
            newLogin.setId(oldLogin.getId());
        }catch (NumberFormatException e){
            throw new NumberFormatException("Por favor ingrese un id valido");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        newLogin.setUsername(VML.inputUser.getText().trim().isEmpty()?oldLogin.getUsername():VML.inputUser.getText());// verifica que el imput tenga informacion y en caso de que no tenga poner la direccion vieja
        newLogin.setPassword(VML.inputPassword.getText().trim().isEmpty()?oldLogin.getPassword():VML.inputPassword.getText());// verifica que el imput tenga informacion y en caso de que no tenga poner la direccion vieja

        LoginDAO.ModifyLogin(newLogin);
    }

    public void PeoplesTable(JTable table){
        model=(DefaultTableModel)table.getModel();
        model.setRowCount(0);
        List<Persona> peoplesList = new ArrayList<>();
        try {
            peoplesList= PersonaDAO.getPeopleList();
            Object[] object=new Object[3];
            for (Persona p:peoplesList){
                object[0]=p.getId();
                object[1]=p.getAllName();
                object[2]=p.getId_number();
                model.addRow(object);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        VML.tablePeoples.setModel(model);
    }
}
