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
import modelo.database;
import org.w3c.dom.events.MouseEvent;
import vista.CuentaProfesor;
import vista.MenuGeneral;

/**
 *
 * @author devr
 */
public class controlPrincipal implements ActionListener, MouseListener{
    
    MenuGeneral menu= new MenuGeneral();
    controlProfesor profesor;
    database db;
    CuentaProfesor cp;
    public controlPrincipal(MenuGeneral menu, database db) {
    this.menu=menu;
    this.db=db;
    this.menu.jbnCuentas.addActionListener(this);
    this.menu.jbnGestion.addActionListener(this);
  //  this.menu.jlbAlumno.addMouseListener(this);
    //this.menu.jlbProfesor.addMouseListener(this);
    this.menu.setVisible(true);
    }

    
    
    @Override
    public void actionPerformed(ActionEvent e) {
       Object source=e.getSource();
        if (source instanceof JButton) {
            if (source.equals(menu.jbnCuentas)) {
                cp=new CuentaProfesor();
                profesor=new controlProfesor(cp, db);
                menu.jDesktopPane1.add(profesor.profesor);
              
            }
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
