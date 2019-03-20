/*

package controlador;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.TableRowSorter;
import modelo.alumno;
import modelo.database;
import modelo.grupo;
import modelo.profesor;
import vista.CuentaAlumno;
import vista.CuentaProfesor;
import vista.GestionAsignarFechas;
import vista.Login;
import vista.MenuGeneral;

public class controlador implements ActionListener, KeyListener, MouseListener,InternalFrameListener{
    private TableRowSorter trsfiltro;
    Login lo;
    database db;
    MenuGeneral menu;
    CuentaAlumno cuenta;
    CuentaProfesor cuentaP;
    GestionAsignarFechas asig;
    
    
    Vector<profesor> datosP;//vector para guardar los datos en el internalFrame profesor
    Vector<grupo>datosG;//vector para guardar los datos en el internalFrame grupo
    String nombre,pass,nombreU,grado;
    public controlador(Login lo, database db, MenuGeneral menu, CuentaAlumno cuenta,
    CuentaProfesor cuentaP, GestionAsignarFechas asig) {
    //llamar menu, login y base de datos.
    this.lo=lo;
    this.db=db;
    this.menu=menu;
    this.cuenta=cuenta;
    this.cuentaP=cuentaP;
    this.asig=asig;
    //seteamos todos lo labels a false para que se vayan activando conforme a el presionar los botones
    this.menu.jlbAlumno.setVisible(false);
    this.menu.jlbProfesor.setVisible(false);
    
   //hacer visible menu o login
   this.menu.setVisible(true);
   // this.lo.setVisible(true);
    
    //Action listener de login
    this.lo.jbnAcceder.addActionListener(this);
    this.lo.jbnAceptar.addActionListener(this);
    
    //Action listener de menu
    this.menu.jbnCuentas.addActionListener(this);
    this.menu.jbnGestion.addActionListener(this);
    this.menu.jlbAlumno.addMouseListener(this);
    this.menu.jlbProfesor.addMouseListener(this);
    
    }
    //base de datos
    
    //metodos alumno
    
    public void resPassword(String nombre, String pass){
        try {
            db.actualizar("UPDATE Usuario SET password='"+pass+"' WHERE nombreUsuario='"+nombre+"';");
            
            if (nombre!=null) {
                JOptionPane.showMessageDialog(menu, "Contraseña actualizada");
                
            }else{
                JOptionPane.showMessageDialog(menu, "Por favor intente de nuevo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(menu, e.getMessage());
        }
    }//fin del reinicio de password
    
    public void bajaCuenta(String nombre){
        try {
            db.actualizar("UPDATE Alumno SET statusAlumno=0 WHERE nombres='"+nombre+"';");
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(menu, e.getMessage());
        }
    }//fin de dar de baja cuenta
      
    public CuentaAlumno abrirAlumno(){
          CuentaAlumno alumno= new CuentaAlumno();//creo el internal frame
          alumno.setClosable(true);//lo hago cerrable
          alumno.setMaximizable(true);//lo hago maximizable
          alumno.setVisible(true);// lo hago visible
          alumno.setTitle("Alumno");//añado un titulo al frame
          menu.jDesktopPane1.add(alumno);//lo añado ald desktopPane
          consCuenAlumnos();//hago el metodo de consulta para guardar los datos y los titulos
          alumno.llenarTabla(titulos, datos);//metodo para llenar la tabla con los datos y titulos
          //listener de botones
          alumno.jtbCuentaAlumno.addMouseListener(this);
          alumno.jbnActualizarCueAlum.addActionListener(this);
          alumno.jbnBajaCueAlum.addActionListener(this);
          
          alumno.addInternalFrameListener(this);
          return alumno;
          
      }//fin de crear internalFrame alumno
    
    //fin de metodos alumno
    
    public void consCuenAlumnos(){
        //realset funciona para mandar el query
         ResultSet alumnos = db.consultar("SELECT a.matricula, a.nombres, a.apellidos, a.statusAlumno, u.password FROM "
                 + "Alumno a INNER JOIN Usuario u on a.IdUsuario=u.IdUsuario;");
        Statement st;
        try {
            //hace el recorrido el next
           if (alumnos.next()) {
            Vector<String> columnas= new Vector<String>();//vector para guardar todos los nombres
            Vector<alumno> datos = new Vector<alumno>();//vector para guardar todos los datos
            columnas.add("Matricula");//añades las columnas osea el nombre de cada dato
            columnas.add("Nombres");
            columnas.add("Apellidos");
            columnas.add("Status");
            columnas.add("Password");
            ResultSet alumnosTodos= db.consultar("SELECT a.matricula, a.nombres, a.apellidos, a.statusAlumno, u.password FROM"
                    + " Alumno a INNER JOIN Usuario u on a.IdUsuario=u.IdUsuario;");
            
            while(alumnosTodos.next()){
                alumno al = new alumno();
                //guardas los datos en el modelo y en el get pones el tipo de dato que es 
                al.setMatricula(alumnosTodos.getInt(1));
                al.setNombre(alumnosTodos.getString(2));
                al.setApellidos(alumnosTodos.getString(3));
                al.setStatusAlumno(alumnosTodos.getByte(4));
                al.setPassword(alumnosTodos.getString(5));
                datos.add(al);//guarda los datos en el vector
            }
               titulos=columnas;//guardo los nombres en otro vector para sacarlos del metodo y ponerlos en el internal frame
            this.datos=datos;//guardo los datos en otro vector para sacarlos del metodo y ponerlos en el internal frame
            
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }//fin de consulta alumno
    
    //inicio metodos profesor
    
     
      
      
       
      //fin de metodos profesor
        
       //inicio de fechas
       
        public GestionAsignarFechas abrirAsignarFecha(){
          GestionAsignarFechas asig= new GestionAsignarFechas();//creo el internal frame
          asig.setClosable(true);//lo hago cerrable
          asig.setMaximizable(true);//lo hago maximizable
          asig.setVisible(true);// lo hago visible
          asig.setTitle("Fechas");//añado un titulo al frame
          menu.jDesktopPane1.add(asig);//lo añado ald desktopPane
          llenarComboGrupo();//hago el metodo de consulta para guardar los datos del grupo
          asig.llenarCombo(datosG);//metodo para llenar la tabla con los datos y titulos
          //listener de botones
          
          return asig;
       
        }
       
        public void llenarComboGrupo(){
        //realset funciona para mandar el query
         
        try {
            //hace el recorrido el next
            ResultSet gruposTodos= db.consultar("SELECT grado FROM Grupo;");
            Vector<grupo> datosG = new Vector<grupo>();//vector para guardar todos los datos
            while(gruposTodos.next()){
                grupo gr = new grupo();
                //guardas los datos en el modelo y en el get pones el tipo de dato que es 
                gr.setGrado(gruposTodos.getString(1));
                
                datosG.add(gr);//guarda los datos en el vector
                this.datosG=datosG;//guardo los datos en otro vector para sacarlos del metodo y ponerlos en el internal frame
            }
               
            
            
            
            }
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }//fin de llenado combo
        
        public void filtroTableConfechas(String query){
        //realset funciona para mandar el query
         ResultSet alumnos = db.consultar("SELECT g.grado  ;");
        Statement st;
        try {
            //hace el recorrido el next
           if (alumnos.next()) {
            Vector<String> columnas= new Vector<String>();//vector para guardar todos los nombres
            Vector<profesor> datosP = new Vector<profesor>();//vector para guardar todos los datos
            columnas.add("Codigo");//añades las columnas osea el nombre de cada dato
            columnas.add("Nombres");
            columnas.add("Apellidos");
            //columnas.add("Status");
            columnas.add("Password");
            ResultSet profesoresTodos= db.consultar("SELECT p.codigoProfesor, p.nombresProfesor, p.apellidosProfesor, "
                 + " u.password FROM "
                 + "Profesor p INNER JOIN Usuario u on p.IdUsuario=u.IdUsuario;");
            
            while(profesoresTodos.next()){
                profesor pr = new profesor();
                //guardas los datos en el modelo y en el get pones el tipo de dato que es 
                pr.setCodigoProfesor(profesoresTodos.getInt(1));
                pr.setNombresProfesor(profesoresTodos.getString(2));
                pr.setApellidosProfesor(profesoresTodos.getString(3));
                pr.setPassword(profesoresTodos.getString(4));
                //al.setPassword(alumnosTodos.getString(5));
                datosP.add(pr);//guarda los datos en el vector
            }
               titulos=columnas;//guardo los nombres en otro vector para sacarlos del metodo y ponerlos en el internal frame
            this.datosP=datosP;//guardo los datos en otro vector para sacarlos del metodo y ponerlos en el internal frame
            
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }//fin de consulta grupo filtro
        
       //fin de fechas
       
       
       
       
       
       
    //eventos
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
         
         CuentaAlumno cuentas = (CuentaAlumno)menu.jDesktopPane1.getSelectedFrame();//observa el objeto y saca sus metodos y listeners
         
         if (source instanceof JButton) {
            if (source.equals(menu.jbnCuentas)) {//escucha al boton de cuentas
                menu.jlbAlumno.setVisible(true);//hace el jlb
                menu.jlbProfesor.setVisible(true);//hace visible al label

            }//fin del if}
            
             if (source.equals(menu.jbnGestion)) {
                 abrirAsignarFecha();
                  System.out.println("siu");
             }//fin del if cuentas
            
            
            if (source.equals(cuentas.jbnActualizarCueAlum)) {
                //ventana emergente que guarda la nueva contraseña
                pass=String.valueOf(JOptionPane.showInputDialog(cuentas, "Ingresa la nueva contraseña"));
                resPassword(nombre, pass);//metodo para actualziar la contraseña
                cuentas.dispose();//cierra el internalframe para actualizar
                abrirAlumno();//vuelve a abrir el internalframe para actualizar
                 
            }//fin del if alumno
            
            
            if (source.equals(cuentas.jbnBajaCueAlum)) {
                int opc=JOptionPane.showConfirmDialog(menu, "Está seguro de eliminar la cuenta de"+""+nombreU);
                if (opc==0) {
                    bajaCuenta(nombreU);
                cuentas.dispose();
                abrirAlumno();
                nombreU=null;
                }else{
                    
                }
                
            }//fin del if alumno
            
            
            
          
         
         
         }//fin del instanceof jbutton
         
        
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        Object source=e.getSource();
        
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseClicked(MouseEvent ae) {
        //mouse clicked, aquí van las opciones para que se abran los internalframes
        Object source=ae.getSource();//con el source oye los mouse clicked
        if (source instanceof JLabel) {//if para seleccionar y escuchar los diferentes tipos en este caso es jlabel
            if (source.equals(menu.jlbAlumno)) {         
            abrirAlumno();//metodo para crear y abrir el internalframe de alumno    
        }
            if (source.equals(menu.jlbProfesor)) {
                abrirProfesor();
            }
        }else if(source instanceof JTable){//if para seleccionar y escuchar los tipo jtable
            CuentaAlumno cuentas = (CuentaAlumno)menu.jDesktopPane1.getSelectedFrame();//observa el objeto y saca sus metodos y listeners
           
            if (source.equals(cuentas.jtbCuentaAlumno)) {//escucha a la tabla cuando damos click
                   
                    //obtiene el valor de el campo nombreUsuario cuando damos click y lo guarda en la variable nombre
                 nombre=(String)cuentas.jtbCuentaAlumno.getValueAt(cuentas.jtbCuentaAlumno.getSelectedRow(), 0);
                    //obtiene el valor de el campo nombre cuando damos click y lo guarda en la variable nombre
                 nombreU=(String)cuentas.jtbCuentaAlumno.getValueAt(cuentas.jtbCuentaAlumno.getSelectedRow(), 1);
                 
            }//fin del if jtable alumno
            
            
            
        }//fin del if instance of jtable
        else if(source instanceof JComboBox){
            GestionAsignarFechas asig=(GestionAsignarFechas)menu.jDesktopPane1.getSelectedFrame();
            if (source.equals(asig.jcbGrupo)) {
                grado=(String)asig.jcbGrupo.getSelectedItem();
                
            }
        } 
    }
    

    @Override
    public void mousePressed(MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       
    }
        
    
      public void font(JLabel label){
          Font font = label.getFont();
    Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
    label.setFont(font.deriveFont(attributes));
    
      }
      
      public void deseleccion(JLabel label){
          Font font = label.getFont();
Map<TextAttribute, Object> attributes = new HashMap<>(font.getAttributes());
attributes.put(TextAttribute.UNDERLINE, -1);
label.setFont(font.deriveFont(attributes));
      }
    
    @Override
    public void mouseEntered(MouseEvent e) {
       //esta es la función para que el mouse se subraye
       Object source=e.getSource();
        if (source instanceof JLabel) {
         if (source.equals(menu.jlbAlumno)) {
            font(menu.jlbAlumno);
        }//fin del if
         if (source.equals(menu.jlbProfesor)) {
            font(menu.jlbProfesor);
        }//fin del if
         
        }//fin del if
        else if(source instanceof JTable){
            
        }//fin del ifelse
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
       //esta es la función para que el mouse se xdesubraye
       Object source=e.getSource();
        if (source instanceof JLabel) {
         if (source.equals(menu.jlbAlumno)) {
            deseleccion(menu.jlbAlumno);
        }//fin del if
         if (source.equals(menu.jlbProfesor)) {
            deseleccion(menu.jlbProfesor);
        } //fin del if
        }//fin del if
        else if(source instanceof JTable){
            
        }//fin del ifelse
       
       
       
       
        
    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
       
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
       
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
       
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
       
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
       
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
       
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
       
    }

    
    
    
}
*/