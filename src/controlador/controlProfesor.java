/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import modelo.alumno;
import modelo.database;
import modelo.profesor;
import vista.CuentaProfesor;

/**
 *
 * @author devr
 */
public class controlProfesor implements ActionListener, MouseListener, InternalFrameListener{
    CuentaProfesor profesor;
    database db;
    Vector<profesor> datosP;//vector para guardar los datos en el internalFrame profesor
        Vector<String> titulos;//vector para guardar los titulos en el internalFrame 
            Vector<alumno> datos;//vector para guardar los datos en el internalFrame alumno
                String nombre,stat,password;
    public controlProfesor(CuentaProfesor profesor, database db) {
        this.profesor=profesor;
        this.db=db;
        this.profesor.setClosable(true);//lo hago cerrable
          this.profesor.setMaximizable(true);//lo hago maximizable
          this.profesor.setVisible(true);// lo hago visible
          this.profesor.setTitle("Profesor");//añado un titulo al frame
          consCuenProfesor();//hago el metodo de consulta para guardar los datos y los titulos
          this.profesor.llenarTabla(titulos, datosP);//metodo para llenar la tabla con los datos y titulos
          //listener de botones
        this.profesor.jbnActualizarCueProf.addActionListener(this);
        this.profesor.jbnBajaCueProf.addActionListener(this);
        this.profesor.jbnCuentaProfesorEje.addActionListener(this);
        this.profesor.jtbCuentaProfesor.addMouseListener(this);
        this.profesor.addInternalFrameListener(this);
    }

public void consCuenProfesor(){
        //realset funciona para mandar el query
         ResultSet alumnos = db.consultar("SELECT p.codigoProfesor, p.nombresProfesor, p.apellidosProfesor, "
                 + "p.statusProfesor, u.password FROM "
                 + "Profesor p INNER JOIN Usuario u on p.IdUsuario=u.IdUsuario;");
        Statement st;
        try {
            //hace el recorrido el next
           if (alumnos.next()) {
            Vector<String> columnas= new Vector<String>();//vector para guardar todos los nombres
            Vector<profesor> datosP = new Vector<profesor>();//vector para guardar todos los datos
            columnas.add("Codigo");//añades las columnas osea el nombre de cada dato
            columnas.add("Nombres");
            columnas.add("Apellidos");
            columnas.add("Status");
            columnas.add("Password");
            ResultSet profesoresTodos= db.consultar("SELECT p.codigoProfesor, p.nombresProfesor, p.apellidosProfesor, "
                 + "p.statusProfesor, u.password FROM "
                 + "Profesor p INNER JOIN Usuario u on p.IdUsuario=u.IdUsuario;");
            
            while(profesoresTodos.next()){
                profesor pr = new profesor();
                //guardas los datos en el modelo y en el get pones el tipo de dato que es 
                pr.setCodigoProfesor(profesoresTodos.getInt(1));
                pr.setNombresProfesor(profesoresTodos.getString(2));
                pr.setApellidosProfesor(profesoresTodos.getString(3));
                pr.setProfesorEje(profesoresTodos.getString(4));
                pr.setPassword(profesoresTodos.getString(5));
                datosP.add(pr);//guarda los datos en el vector
            }
               titulos=columnas;//guardo los nombres en otro vector para sacarlos del metodo y ponerlos en el internal frame
            this.datosP=datosP;//guardo los datos en otro vector para sacarlos del metodo y ponerlos en el internal frame
            
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }//fin de consulta profesor
     
     public CuentaProfesor abrirProfesor(JDesktopPane menu){
          CuentaProfesor profesor= new CuentaProfesor();//creo el internal frame
          
          return profesor;
          
      }//fin de crear nuevoProfesor
     
      public void statusProfesor(String nombre, String status){
        try {
            db.actualizar("UPDATE Profesor SET statusProfesor='"+status+"' WHERE nombresProfesor='"+nombre+"';");
            JOptionPane.showMessageDialog(profesor, "Cambios realizados Correctamente");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//fin de dar de baja cuenta profesor              
    
      public void consultaStatus() {
          ResultSet status=db.consultar("SELECT statusProfesor FROM Profesor WHERE nombresProfesor='"+nombre+"';");
          
          try{
          while(status.next()){
                stat=status.getString(1);
            }
          }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());  
          }
      }
      
      public void resPassword(String nombre, String pass){
        try {
            String opc=JOptionPane.showInputDialog(profesor,"Ingrese la nueva contraseña");
            if (nombre!=null) {
                 db.actualizar("UPDATE Usuario SET password='"+opc+"' WHERE nombreUsuario='"+nombre+"';");
                JOptionPane.showMessageDialog(profesor, "Contraseña actualizada\n Cambió de"
                +password+" a "+opc);
                password=null;
                
            }else{
                JOptionPane.showMessageDialog(profesor, "Por favor intente de nuevo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(profesor, e.getMessage());
        }
      }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source= e.getSource();
        
        if (source instanceof JButton) {
        
            if (source.equals(profesor.jbnCuentaProfesorEje)) {
               consultaStatus();
               int opc; 
                if (nombre == null) {
                    //validación para que no arroje nullerpoint cuando no han seleccionado nada
                }else{
                    if (stat.equals("ProfesorEje")) {
                   opc=JOptionPane.showConfirmDialog(profesor,"¿Desea remover profesor eje?"); 
                   if (opc==0) {
                       statusProfesor(nombre, "Profesor");
                       nombre=null;
                    
                   }//if por si es eje cambiar a profesor
                }else{//else de profesor
                   opc=JOptionPane.showConfirmDialog(profesor,"¿Desea configurar como profesor eje?"); 
                    if (opc==0) {
                       statusProfesor(nombre, "ProfesorEje");
                       nombre=null;
                    
                   }//if por si es normal cambiar a eje
                }//else de if profesor eje
                }//else principal
               
               
            }else if(source.equals(profesor.jbnBajaCueProf)){
                if (nombre==null || password == null) {
                    
                }else{//fin del if comparador de nulls
                    resPassword(nombre, password);
            }
            }
            
        }//fin del listener de botones
    }

    
    @Override
    public void mouseClicked(MouseEvent ae) {
        Object source=ae.getSource();
        if (source instanceof JButton) {
            
        }else if (source instanceof JTable) {
        
            if (source.equals(profesor.jtbCuentaProfesor)) {//escucha a la tabla cuando damos click
                 nombre=(String)profesor.jtbCuentaProfesor.getValueAt(profesor.jtbCuentaProfesor.getSelectedRow(), 1); 
                 password=(String)profesor.jtbCuentaProfesor.getValueAt(profesor.jtbCuentaProfesor.getSelectedRow(), 4); 
                 
            }//fin del if jtable alumno
            
        }//fin del listener de jtable
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
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
