/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
public class grupo {
private String grado;
private String turno;

    public grupo() {
        this.grado = grado;
        this.turno = turno;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    
    //se añaden los strings necesarios para llenar la tabla
      public String[] toArray(){
        String[] datosArray = new String[2];
        datosArray[0] = grado;
        datosArray[1]=turno;
        
        return datosArray;
    }


}
