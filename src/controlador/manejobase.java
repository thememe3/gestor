package controlador;

import static java.awt.Frame.MAXIMIZED_BOTH;
import modelo.database;
import vista.CuentaAlumno;
import vista.CuentaProfesor;
import vista.GestionAsignarFechas;
import vista.Login;
import vista.MenuGeneral;



public class manejobase {

    public static void main(String[] args) {

        database b = new database();
            Login lo= new Login();
            MenuGeneral menu= new MenuGeneral();
            CuentaAlumno cuenta=new CuentaAlumno();
            CuentaProfesor prof=new CuentaProfesor();
            controlProfesor profesor= new controlProfesor(prof, b);
            GestionAsignarFechas asig=new GestionAsignarFechas();
//            int ancho = (int)menu.getWidth()/2;
//            int alto = (int)menu.getHeight()/2;
//            menu.setSize(ancho, alto);   
            //menu.setExtendedState(MAXIMIZED_BOTH);
           // controlador co=new controlador(lo, b,menu,cuenta,profesor,asig);
           controlPrincipal principal=new controlPrincipal(menu,b);
    }
}
  