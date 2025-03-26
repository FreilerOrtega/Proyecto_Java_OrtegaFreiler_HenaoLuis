package Controlador;

import vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.*;

import javax.swing.*;

public class crtllogin  implements ActionListener {
    viewLogin vLogin=new viewLogin();
    Login login=new Login();
    LoginDAO logDao = new LoginDAO();
    Persona people= new Persona();
    PersonaDAO DAO=new PersonaDAO();

    public crtllogin(viewLogin login) {
        vLogin = login;
        login.btnLogin.addActionListener(this);//crea la acion de boton de enviar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vLogin.btnLogin){//si el evento es un click en el boton de iniciar se activa el siguiente bloque de codigo

            CheckUserPassword();
        }
    }

    public void CheckUserPassword() {
        login.setUsername(vLogin.inputUser.getText());//se toman los datos que se hayan ingresado en el input de usuario
        login.setPassword(vLogin.inputPassword.getText());//se toman los datos que se hayan ingresado en el input de contrasena

        try {
            int id = logDao.logInConf(login);// se obtiene el id de la persona que tiene ese usuario y contrasena
            if (id == 0) {
                throw new Exception("Usuario o contraseña incorrecto");
            }
            people = DAO.SearchPeopleById(id);//se asignan los datos de la persona en base al id
            System.out.println(people.getPerson_type());
            if (people.getPerson_type().toLowerCase().equals("cliente")) {
                //si la persona es de tipo cliente se cierra la vista de login y se abre la de dueno
                vLogin.setVisible(false);
                viewOwnerHome VOH = new viewOwnerHome();
                VOH.setVisible(true);
                ctrlOwnerHome ctrOwHom = new ctrlOwnerHome(VOH, people);
            }else if (people.getPerson_type().toLowerCase().equals("administrador")) {
                //si la persona es de tipo cliente se cierra la vista de login y se abre la de dueno
                vLogin.setVisible(false);
                ViewAdministratorHome VAH = new ViewAdministratorHome();
                VAH.setVisible(true);
                CtrlAdministratorHome CAH=new CtrlAdministratorHome(VAH,people);
            } else if (people.getPerson_type().toLowerCase().equals("veterinario")) {
                // si la persona es de tipo cliente se cierra y abre el la de el veterinario
                vLogin.setVisible(false);
                veterinarian vet = new veterinarian();
                vet.setVisible(true);
                Ctrlveterinarian name = new Ctrlveterinarian(vet,people);


            }
        } catch (Exception i) {
            JOptionPane.showMessageDialog(vLogin, i.getMessage());
        }
    }

}
