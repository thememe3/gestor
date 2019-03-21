package vista;

import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import modelo.alumno;
import modelo.fecha;
import modelo.grupo;

public class GestionAsignarFechas extends javax.swing.JInternalFrame {
         public DefaultTableModel control = new DefaultTableModel();
    public GestionAsignarFechas() {
        initComponents();
        jTable1.setModel(control);
    }
    
       public void llenarTabla(Vector<String> titulos,Vector<fecha> datos){
        
        for (String titulo : titulos){
            control.addColumn(titulo);//con esto llena los titulos de la tabla
        }
        
        for (fecha dato : datos) {
            control.addRow(dato.toArray());
        }
       }
    
    public void llenarCombo(Vector<grupo> datos){
        for (grupo gru : datos) {
                jcbGrupo.addItem(gru.getGrado());
        }
    }
      public void llenarComboEquipo(Vector<fecha> datos){
        for (fecha fe : datos) {
                jcbEquipo.addItem(fe.getEquipo());
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jcbEquipo = new javax.swing.JComboBox<>();
        jlbEquipo = new javax.swing.JLabel();
        jlbFecha = new javax.swing.JLabel();
        jlbHora = new javax.swing.JLabel();
        jlbLugar = new javax.swing.JLabel();
        jcbLugar = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jcbGrupo = new javax.swing.JComboBox<>();
        jbnAsignar = new javax.swing.JButton();
        JbnEliminar = new javax.swing.JButton();
        jbnModificar = new javax.swing.JButton();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jcbHora = new javax.swing.JComboBox<>();
        jcbMinuto = new javax.swing.JComboBox<>();

        jTable1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fecha", "Lugar", "Hora", "Grupo", "Equipo"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jcbEquipo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N

        jlbEquipo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jlbEquipo.setText("Equipo");

        jlbFecha.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jlbFecha.setText("Fecha");

        jlbHora.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jlbHora.setText("Hora");

        jlbLugar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jlbLugar.setText("Lugar");

        jcbLugar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jcbLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Auditorio 1", "Auditorio 2" }));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Grupo");

        jcbGrupo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jcbGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige una opción..." }));

        jbnAsignar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jbnAsignar.setText("Asignar");

        JbnEliminar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        JbnEliminar.setText("Eliminar");

        jbnModificar.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jbnModificar.setText("Modificar");

        jcbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24" }));
        jcbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbHoraActionPerformed(evt);
            }
        });

        jcbMinuto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "10", "20", "30", "40", "50", " " }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbGrupo, 0, 215, Short.MAX_VALUE)
                .addGap(312, 312, 312))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbFecha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlbEquipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbLugar)
                            .addComponent(jlbHora))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jbnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbnModificar)
                        .addGap(18, 18, 18)
                        .addComponent(JbnEliminar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JbnEliminar, jbnAsignar, jbnModificar});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlbLugar)
                        .addComponent(jcbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlbFecha))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbHora)
                    .addComponent(jlbEquipo)
                    .addComponent(jcbEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMinuto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbnAsignar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbnModificar)
                    .addComponent(JbnEliminar))
                .addGap(103, 103, 103))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {JbnEliminar, jbnAsignar, jbnModificar});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbHoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton JbnEliminar;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    public javax.swing.JButton jbnAsignar;
    public javax.swing.JButton jbnModificar;
    public javax.swing.JComboBox<String> jcbEquipo;
    public javax.swing.JComboBox<String> jcbGrupo;
    public javax.swing.JComboBox<String> jcbHora;
    public javax.swing.JComboBox<String> jcbLugar;
    public javax.swing.JComboBox<String> jcbMinuto;
    public com.toedter.calendar.JDateChooser jdcFecha;
    public javax.swing.JLabel jlbEquipo;
    public javax.swing.JLabel jlbFecha;
    public javax.swing.JLabel jlbHora;
    public javax.swing.JLabel jlbLugar;
    // End of variables declaration//GEN-END:variables
}
