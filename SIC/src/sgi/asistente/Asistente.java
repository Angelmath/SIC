package asistente;
// Generated 11/03/2015 11:13:37 by Hibernate Tools 4.3.1



/**
 * Asistente generated by hbm2java
 */
public class Asistente  implements java.io.Serializable {


     private String cedula;
     private String nombre;
     private String apellido;
     private String placa;
     private String acreditacion;
     private String observacion;
     private String familia;

    public Asistente() {
    }

    public Asistente(String cedula, String nombre, String apellido, String placa, String acreditacion, String observacion, String familia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.placa = placa;
        this.acreditacion = acreditacion;
        this.observacion = observacion;
        this.familia = familia;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

	
    public Asistente(String cedula) {
        this.cedula = cedula;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
   
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getAcreditacion() {
        return this.acreditacion;
    }
    
    public void setAcreditacion(String acreditacion) {
        this.acreditacion = acreditacion;
    }




}


