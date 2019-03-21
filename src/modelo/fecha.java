/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
public class fecha {
    private String fecha ;
    private  String auditorio;
    private String hora;
    private String grupo;
    private String equipo;

    public fecha() {
        this.fecha = fecha;
        this.auditorio = auditorio;
        this.hora = hora;
        this.grupo = grupo;
        this.equipo = equipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAuditorio() {
        return auditorio;
    }

    public void setAuditorio(String auditorio) {
        this.auditorio = auditorio;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    
    
     //se añaden los strings necesarios para llenar la tabla
      public String[] toArray(){
        String[] datosArray = new String[5];
        datosArray[0] = fecha;
        datosArray[1]=auditorio;
        datosArray[2]=hora;
        datosArray[3]=grupo;
        datosArray[4]=equipo;
        return datosArray;
    }
    
   
    
}
