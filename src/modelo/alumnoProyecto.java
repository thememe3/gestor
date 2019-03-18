package modelo;
public class alumnoProyecto {
private int matricula;
private int idProyecto;
private String fecha;
private String auditorio;

    public alumnoProyecto() {
        this.matricula = matricula;
        this.idProyecto = idProyecto;
        this.fecha = fecha;
        this.auditorio = auditorio;
    }




    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
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
    
    //se añaden los strings necesarios para llenar la tabla
      public String[] toArray(){
        String[] datosArray = new String[4];
        datosArray[0] = String.valueOf(matricula);
        datosArray[1]=String.valueOf(idProyecto);
        datosArray[2]=fecha;
        datosArray[3]=auditorio;
        
        return datosArray;
    }

    

}
