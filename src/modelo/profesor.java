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
   private String profesorEje;
   private String password;

    public profesor() {
        this.codigoProfesor=0;
        this.nombresProfesor="";
        this.apellidosProfesor="";
        this.profesorEje="";
        this.password="";
    }

    public String getProfesorEje() {
        return profesorEje;
    }

    public void setProfesorEje(String profesorEje) {
        this.profesorEje = profesorEje;
    }
    
    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        String[] datosArray = new String[5];
        datosArray[0] = String.valueOf(codigoProfesor);
        datosArray[1]=nombresProfesor;
        datosArray[2]=apellidosProfesor;
        datosArray[3]=profesorEje;
        datosArray[4]=password;
    
        return datosArray;
    }
      
      
   
   
}
