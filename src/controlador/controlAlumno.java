package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.alumno;
import modelo.database;
import vista.CuentaAlumno;

public class controlAlumno implements ActionListener, MouseListener{
    CuentaAlumno alumno;
    database db;
     Vector<String> titulos= new Vector<String>();//vector para guardar todos los nombres
            Vector<alumno> datos = new Vector<alumno>();//vector para guardar todos los datos
            String nombreUsuario,password,nombres;
    public controlAlumno(CuentaAlumno alumno, database db) {
        
    this.alumno=alumno;
    this.db=db;    
          this.alumno.setClosable(true);//lo hago cerrable
          this.alumno.setMaximizable(true);//lo hago maximizable
          this.alumno.setVisible(true);// lo hago visible
          this.alumno.setTitle("Alumno");//añado un titulo al frame
          consCuenAlumnos();
          this.alumno.llenarTabla(titulos, datos);
    this.alumno.jbnActualizarCueAlum.addActionListener(this);
    this.alumno.jbnBajaCueAlum.addActionListener(this);
    this.alumno.jtbCuentaAlumno.addMouseListener(this);
    
    }
    
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
    
      public void bajaCuenta(String nombre){
        try {
            
            if (nombre!=null) {
                db.actualizar("UPDATE Alumno SET statusAlumno=0 WHERE nombres='"+nombre+"';");
            JOptionPane.showMessageDialog(alumno, "Cambios realizados Correctamente");
            }else{
                JOptionPane.showMessageDialog(alumno, "Por favor intente de nuevo");
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(alumno, e.getMessage());
        }
      }//fin de bajaCUentaAlumno
      
       public void resPassword(String nombre, String pass){
        try {
            
            
            if (nombre!=null) {
                
                db.actualizar("UPDATE Usuario SET password='"+pass+"' WHERE nombreUsuario='"+nombre+"';");
                JOptionPane.showMessageDialog(alumno, "Contraseña actualizada");
                
            }else{
                JOptionPane.showMessageDialog(alumno, "Por favor intente de nuevo");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(alumno, e.getMessage());
        }
    }//fin del reinicio de password

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if (source instanceof JButton) {
            if (source.equals(alumno.jbnBajaCueAlum)) {
                bajaCuenta(nombres);
            }//fin del if boton baja cuenta/alumno
            if (source.equals(alumno.jbnActualizarCueAlum)) {
                password=JOptionPane.showInputDialog(alumno, "Ingrese la nueva contraseña");
                resPassword(nombreUsuario, password);
            }
        }//fin del listener de los JBUttons
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source=e.getSource();
        if (source instanceof JTable) {
            if (source.equals(alumno.jtbCuentaAlumno)) {//escucha a la tabla cuando damos click
                 nombreUsuario=(String)alumno.jtbCuentaAlumno.getValueAt(alumno.jtbCuentaAlumno.getSelectedRow(), 0); 
                 
                 nombres=(String)alumno.jtbCuentaAlumno.getValueAt(alumno.jtbCuentaAlumno.getSelectedRow(), 1); 
                 ;
            }//fin del if jtable alumno
        }//fin del listener del JTable
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
    
}
