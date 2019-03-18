package vista;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.alumno;

public class CuentaAlumno extends javax.swing.JInternalFrame implements MouseListener{

    public DefaultTableModel control = new DefaultTableModel();
    
    public CuentaAlumno() {
        initComponents();
        jtbCuentaAlumno.addMouseListener(this);
        jtbCuentaAlumno.setModel(control);
        
    }
    
    public void llenarTabla(Vector<String> titulos,Vector<alumno> datos){
        
        for (String titulo : titulos){
            control.addColumn(titulo);//con esto llena los titulos de la tabla
        }
        
        for (alumno dato : datos) {
            control.addRow(dato.toArray());
        }
        
        
    

    }
    
     
     
     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlbBuscaAl = new javax.swing.JLabel();
        jtfBuscarCuentaAlumno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCuentaAlumno = new javax.swing.JTable();
        jbnActualizarCueAlum = new javax.swing.JButton();
        jbnBajaCueAlum = new javax.swing.JButton();

        jlbBuscaAl.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jlbBuscaAl.setText("Buscar");

        jtfBuscarCuentaAlumno.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N

        jtbCuentaAlumno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtbCuentaAlumno);

        jbnActualizarCueAlum.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jbnActualizarCueAlum.setText("Reiniciar Password");

        jbnBajaCueAlum.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jbnBajaCueAlum.setText("Baja");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jbnActualizarCueAlum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbnBajaCueAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jlbBuscaAl, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfBuscarCuentaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jbnActualizarCueAlum, jbnBajaCueAlum});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscarCuentaAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbBuscaAl, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbnActualizarCueAlum)
                    .addComponent(jbnBajaCueAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jbnActualizarCueAlum, jbnBajaCueAlum});

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JButton jbnActualizarCueAlum;
    public javax.swing.JButton jbnBajaCueAlum;
    public javax.swing.JLabel jlbBuscaAl;
    public javax.swing.JTable jtbCuentaAlumno;
    public javax.swing.JTextField jtfBuscarCuentaAlumno;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
       JTable click=(JTable)e.getSource();//creamos la variable que escuchará cuando demos click sobre la tabla       
       if (click.equals(jtbCuentaAlumno)) {
           String nombre=(String)jtbCuentaAlumno.getValueAt(jtbCuentaAlumno.getSelectedRow(), 1);
           String pass=(String)jtbCuentaAlumno.getValueAt(jtbCuentaAlumno.getSelectedRow(), 4);
           
        }
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
