package Controlador;

import Modelo.Persona;
import vista.*;

import java.awt.event.*;

public class ctrlOwnerHome  implements ActionListener {
    viewOwnerHome viewOHome;

    public ctrlOwnerHome(viewOwnerHome viewOHome, Persona persona) {
        this.viewOHome = viewOHome;
        this.viewOHome.ownerName.setText(persona.getAllName());
        this.viewOHome.btnViewHistoryC.addActionListener(this);
        this.viewOHome.btnViewHistoryS.addActionListener(this);
        this.viewOHome.btnViewSurgeries.addActionListener(this);
        this.viewOHome.btnViewVaccine.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
