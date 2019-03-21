/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import modelo.alumno;
import modelo.database;
import org.w3c.dom.events.MouseEvent;
import vista.CuentaAlumno;
import vista.CuentaProfesor;
import vista.GestionAsignarFechas;
import vista.MenuGeneral;

/**
 *
 * @author devr
 */
public class controlPrincipal implements ActionListener, MouseListener{
    
    MenuGeneral menu= new MenuGeneral();
    controlProfesor profesor;
    controlAlumno alumno;
    controlFecha fecha;
    database db;
    CuentaProfesor cp;
    CuentaAlumno ca;
    GestionAsignarFechas gf;
    public controlPrincipal(MenuGeneral menu, database db) {
    this.menu=menu;
    this.db=db;
    this.menu.jbnAlumno.addActionListener(this);
    this.menu.jbnProfesor.addActionListener(this);
    this.menu.jbnFechas.addActionListener(this);
    this.menu.setVisible(true);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object source=e.getSource();
        if (source instanceof JButton) {
            if (source.equals(menu.jbnProfesor)) {
                cp=new CuentaProfesor();
                profesor=new controlProfesor(cp, db);
                menu.jDesktopPane1.add(profesor.profesor);
              
            }//fin del if jbncuentas
            if (source.equals(menu.jbnAlumno)) {
                ca=new CuentaAlumno();
                alumno=new controlAlumno(ca, db);
                menu.jDesktopPane1.add(alumno.alumno);
            }//fin del jbnalumno
            
            if (source.equals(menu.jbnFechas)) {
                gf= new GestionAsignarFechas();
                fecha= new controlFecha(db, gf);
                menu.jDesktopPane1.add(fecha.fecha);
            }//fin del if jbnfechas
        }
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
       
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
       
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
       
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
       
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
      
    }
    
}
