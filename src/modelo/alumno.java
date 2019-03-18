
package modelo;

public class alumno {
  private int matricula;
  private String nombre;
  private String apellidos;
  private byte statusAlumno;
  private int idUsuario;
  private String password;

    public alumno() {
        this.matricula = 0;
        this.nombre = "";
        this.apellidos = "";
        this.statusAlumno = 0;
        this.idUsuario = 0;
        this.password = "0";
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public byte getStatusAlumno() {
        return statusAlumno;
    }

    public void setStatusAlumno(byte statusAlumno) {
        this.statusAlumno = statusAlumno;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
     //se añaden los strings necesarios para llenar la tabla
      public String[] toArray(){
        String[] datosArray = new String[5];
        datosArray[0] = String.valueOf(matricula);
        datosArray[1]=nombre;
        datosArray[2]=apellidos;
        datosArray[3]=String.valueOf(statusAlumno);
        datosArray[4]=password;
        return datosArray;
    }
    
      
  
}
