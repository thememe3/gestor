package controlador;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JLabel;
import modelo.database;
import vista.Login;
import vista.MenuGeneral;

public class controlador implements ActionListener, KeyListener, MouseListener{
    
    Login lo;
    database db;
    MenuGeneral menu;
    public controlador(Login lo, database db, MenuGeneral menu) {
    this.lo=lo;
    this.db=db;
    this.menu=menu;
   // this.lo.setVisible(true);
   this.menu.setVisible(true);
    //Action listener de login
    this.lo.jbnAcceder.addActionListener(this);
    this.lo.jbnAceptar.addActionListener(this);
    //Action listener de menu
    this.menu.jlbPrueba.addMouseListener(this);
    this.menu.jlbprueba2.addMouseListener(this);
    }
    
            
        
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
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
        JLabel label=(JLabel)ae.getSource();
        if (label.equals(menu.jlbPrueba)) {
            System.out.println("Ready");
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
    public void mouseEntered(MouseEvent ae) {
       //esta es la función para que el mouse se subraye
       JLabel label=(JLabel)ae.getSource();
        if (label.equals(menu.jlbPrueba)) {
            font(menu.jlbPrueba);
        }
         if (label.equals(menu.jlbprueba2)) {
            font(menu.jlbprueba2);
        } 
       
       
    }

    @Override
    public void mouseExited(MouseEvent e) {
       //esta es la función para que el mouse se xdesubraye
       JLabel label=(JLabel)e.getSource();
        if (label.equals(menu.jlbPrueba)) {
            deseleccion(menu.jlbPrueba);
        }
         if (label.equals(menu.jlbprueba2)) {
            deseleccion(menu.jlbprueba2);
        } 
    }
    
}
