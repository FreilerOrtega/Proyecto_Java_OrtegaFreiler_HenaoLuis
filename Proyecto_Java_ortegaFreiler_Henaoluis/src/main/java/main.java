

import Controlador.crtllogin;
import vista.viewLogin;

public class main {

    public static void main(String[] args) {
        viewLogin VL=new viewLogin();
        VL.setVisible(true);
        crtllogin control=new crtllogin(VL);
    }

}
