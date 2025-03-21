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
    personaDAO DAO=new personaDAO();

    public crtllogin(viewLogin login) {
        vLogin = login;
        login.btnLogin.addActionListener(this);//crea la acion de boton de enviar
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vLogin.btnLogin){//si el evento es un click en el boton de iniciar se activa el siguiente bloque de codigo

            login.setUsuario(vLogin.inputUser.getText());//se toman los datos que se hayan ingresado en el input de usuario
            login.setContrasena(vLogin.inputPassword.getText());//se toman los datos que se hayan ingresado en el input de contrasena

            try {
                int id=logDao.logInConf(login);// se obtiene el id de la persona que tiene ese usuario y contrasena
                people=DAO.SearchPeopleById(id);//se asignan los datos de la persona en base al id

                if (people.getTipo().toLowerCase().equals("cliente")){
                    //si la persona es de tipo cliente se cierra la vista de login y se abre la de dueno
                    vLogin.setVisible(false);
                    viewOwnerHome VOH=new viewOwnerHome();
                    VOH.setVisible(true);
                }
            }catch (Exception i){
                JOptionPane.showMessageDialog(vLogin,i.getMessage());
            }

        }
    }
}
