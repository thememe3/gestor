package controlador;

import com.toedter.calendar.JDateChooser;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import modelo.database;
import modelo.fecha;
import modelo.grupo;
import vista.GestionAsignarFechas;

public class controlFecha implements ActionListener,MouseListener{
    database db;
    GestionAsignarFechas fecha;
    Vector<grupo> datosG = new Vector<grupo>();//vector para guardar todos los datos
    Vector<fecha> datosF = new Vector<fecha>();//vector para guardar todos los datos
    Vector<String> titulos= new Vector<String>();//vector para guardar todos los nombres
    String grado;
    SimpleDateFormat Formato = new SimpleDateFormat("yyyy-MM-dd");
    public controlFecha(database db, GestionAsignarFechas fecha) {
        this.db=db;
        this.fecha=fecha;
        this.fecha.setClosable(true);//lo hago cerrable
          this.fecha.setMaximizable(true);//lo hago maximizable
          this.fecha.setVisible(true);// lo hago visible
          this.fecha.setTitle("Fechas");//añado un titulo al frame
        this.fecha.jbnAsignar.addActionListener(this);
        this.fecha.JbnEliminar.addActionListener(this);
        this.fecha.jbnModificar.addActionListener(this);
        this.fecha.jcbGrupo.addActionListener(this);
        
        
        llenarComboGrupo();//hago el metodo de consulta para guardar los datos del grupo
          this.fecha.llenarCombo(datosG);//metodo para llenar la tabla con los datos y titulos
    }
    
         public void filtroTableConfechas(String grado){
        //realset funciona para mandar el query
         ResultSet alumnos = db.consultar("SELECT DISTINCT ap.fecha, ap.auditorio, ap.hora, p.nombreEquipo, p.numEquipo  "
                    + "FROM Proyecto p INNER JOIN Alumno_Proyecto ap JOIN Grupo g ON p.IdProyecto=ap.IdProyecto WHERE g.grado='"+grado+"';");
        Statement st;
        try {
            //hace el recorrido el next
           if (alumnos.next()) {
            Vector<String> columnas= new Vector<String>();//vector para guardar todos los nombres
            Vector<fecha> datosF = new Vector<fecha>();//vector para guardar todos los datos
            columnas.add("Fecha");//añades las columnas osea el nombre de cada dato
            columnas.add("Lugar");
            columnas.add("Hora");
            columnas.add("Equipo");
            columnas.add("No. Equipo");
            ResultSet fechasTodos= db.consultar("SELECT DISTINCT ap.fecha, ap.auditorio, ap.hora, p.nombreEquipo, p.numEquipo  "
                    + "FROM Proyecto p INNER JOIN Alumno_Proyecto ap JOIN Grupo g ON p.IdProyecto=ap.IdProyecto WHERE g.grado='"+grado+"';");
            
            while(fechasTodos.next()){
                fecha fr = new fecha();
                //guardas los datos en el modelo y en el get pones el tipo de dato que es 
                fr.setFecha(fechasTodos.getString(1));
                fr.setAuditorio(fechasTodos.getString(2));
                fr.setHora(fechasTodos.getString(3));
                fr.setGrupo(fechasTodos.getString(4));
                fr.setEquipo(fechasTodos.getString(5));
                datosF.add(fr);//guarda los datos en el vector
            }
               titulos=columnas;//guardo los nombres en otro vector para sacarlos del metodo y ponerlos en el internal frame
            this.datosF=datosF;//guardo los datos en otro vector para sacarlos del metodo y ponerlos en el internal frame
            
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }
    }//fin de consulta grupo filtro
    
    
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
            }//fin del while             
            }//fin del try
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }//fin del catch
    }//fin de llenado combo
    
        public void jcomboEquipo(String grado){
             //realset funciona para mandar el query
        try {
            //hace el recorrido el next
            ResultSet fechasTodos= db.consultar("SELECT distinct p.nombreEquipo FROM Proyecto p INNER JOIN "
                    + "Alumno_Proyecto ap JOIN Grupo g ON p.IdProyecto=ap.IdProyecto WHERE g.grado='5-C';");
            Vector<fecha> datosF = new Vector<fecha>();//vector para guardar todos los datos
            while(fechasTodos.next()){
                fecha fe = new fecha();
                //guardas los datos en el modelo y en el get pones el tipo de dato que es 
                fe.setEquipo(fechasTodos.getString(1));
                datosF.add(fe);//guarda los datos en el vector
                this.datosF=datosF;//guardo los datos en otro vector para sacarlos del metodo y ponerlos en el internal frame
            }//fin del while             
            }//fin del try
         catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se encontró");
        }//fin del catch
        }//fin de jcombo
        
         public String getFecha(JDateChooser jd){
         if (jd.getDate()!=null){
         return Formato.format(jd.getDate());
         }else{
         return null;
         }
         }//getfecha
         
         public java.util.Date StringADate(String fecha){
            SimpleDateFormat formato_del_Texto = new SimpleDateFormat("dd-MM-yyyy");
            Date fechaE=null;
                try {
                fechaE = formato_del_Texto.parse(fecha);
                    return fechaE;
            } catch (ParseException ex) {
                    return null;
                }
            }//Stringadate
         
         public void actualizarFecha(String tiempo, String date, String lugar,String equipo,String grupo){
             db.actualizar();
         }

    @Override
    public void actionPerformed(ActionEvent e) {
     Object source=e.getSource();
      
     if (source instanceof JButton) {
            if (source.equals(fecha.jbnAsignar)) {
                String hora=(String)fecha.jcbHora.getSelectedItem();
                String minuto=(String)fecha.jcbMinuto.getSelectedItem();
                String tiempo=hora+":"+minuto;
                String date=getFecha(fecha.jdcFecha);
                String lugar=(String)fecha.jcbLugar.getSelectedItem();
                String equipo=(String)fecha.jcbEquipo.getSelectedItem();
                String grupo=(String)fecha.jcbGrupo.getSelectedItem();
                System.out.println(tiempo+date+lugar+equipo+grupo);
         }//fin del jbnAsignar
            if (source.equals(fecha.jbnModificar)) {
                    
         }//fin de button modificar
        }//fin del jbutton   
        
        if (source instanceof JComboBox) {
            if (source.equals(fecha.jcbGrupo)) {
                
                grado=fecha.jcbGrupo.getItemAt(fecha.jcbGrupo.getSelectedIndex());
                 filtroTableConfechas(grado);
                fecha.llenarTabla(titulos, datosF);
                datosF.clear();
                jcomboEquipo(grado);
                fecha.llenarComboEquipo(datosF);
                
            }
        }//fin de combobox
    }

    @Override
    public void mouseClicked(MouseEvent ae) {
        Object source=ae.getSource();
        if (source instanceof JTable) {
            if (source.equals(fecha.jTable1)) {
            
                String fechas=(String)fecha.jTable1.getValueAt(fecha.jTable1.getSelectedRow(), 0); 
                String lugar=(String)fecha.jTable1.getValueAt(fecha.jTable1.getSelectedRow(), 1); 
                String hora=(String)fecha.jTable1.getValueAt(fecha.jTable1.getSelectedRow(), 2); 
                String grupo=(String)fecha.jTable1.getValueAt(fecha.jTable1.getSelectedRow(), 3); 
                String Equipo=(String)fecha.jTable1.getValueAt(fecha.jTable1.getSelectedRow(), 4); 
            }
        }//fin del listener jbutton
        
    }

    @Override
    public void mousePressed(MouseEvent ae) {
          
    }

    @Override
    public void mouseReleased(MouseEvent ae) {
   
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
    }

    @Override
    public void mouseExited(MouseEvent ae) {
     
    }
    
}
