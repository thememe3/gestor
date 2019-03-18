/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author devr
 */
public class profesor {
   private int codigoProfesor;
   private String nombresProfesor;
   private String apellidosProfesor;
   private String[] statusProfesorEje;
   private String password;

    public profesor() {
        this.codigoProfesor=0;
        this.nombresProfesor="";
        this.apellidosProfesor="";
        this.statusProfesorEje=new String[3];
        this.password="";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    
    
    public String[] getStatusProfesorEje() {
        return statusProfesorEje;
    }

    public void setStatusProfesorEje(String[] statusProfesorEje) {
        this.statusProfesorEje = statusProfesorEje;
    }

    
    
    public int getCodigoProfesor() {
        return codigoProfesor;
    }

    public void setCodigoProfesor(int codigoProfesor) {
        this.codigoProfesor = codigoProfesor;
    }

    public String getNombresProfesor() {
        return nombresProfesor;
    }

    public void setNombresProfesor(String nombresProfesor) {
        this.nombresProfesor = nombresProfesor;
    }

    public String getApellidosProfesor() {
        return apellidosProfesor;
    }

    public void setApellidosProfesor(String apellidosProfesor) {
        this.apellidosProfesor = apellidosProfesor;
    }
    
    //se añaden los strings necesarios para llenar la tabla
      public String[] toArray(){
        String[] datosArray = new String[4];
        datosArray[0] = String.valueOf(codigoProfesor);
        datosArray[1]=nombresProfesor;
        datosArray[2]=apellidosProfesor;
        datosArray[3]=password;
        
        
        return datosArray;
    }
      
      
   
   
}
