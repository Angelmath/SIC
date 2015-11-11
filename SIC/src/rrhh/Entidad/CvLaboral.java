package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * CvLaboral generated by hbm2java
 */
public class CvLaboral  implements java.io.Serializable {


     private int id;
     private String cargo;
     private String institucion;
     private String puesto;
     private String funciones;
     private String jefe;
     private String telefono;
     private String cedula;
     private Date fechaInicio;
     private Date fechaFinal;

    public CvLaboral() {
    }

	
    public CvLaboral(int id) {
        this.id = id;
    }
    public CvLaboral(int id, String cargo, String institucion, String puesto, String funciones, String jefe, String telefono, String cedula, Date fechaInicio, Date fechaFinal) {
       this.id = id;
       this.cargo = cargo;
       this.institucion = institucion;
       this.puesto = puesto;
       this.funciones = funciones;
       this.jefe = jefe;
       this.telefono = telefono;
       this.cedula = cedula;
       this.fechaInicio = fechaInicio;
       this.fechaFinal = fechaFinal;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getCargo() {
        return this.cargo;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public String getInstitucion() {
        return this.institucion;
    }
    
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    public String getPuesto() {
        return this.puesto;
    }
    
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    public String getFunciones() {
        return this.funciones;
    }
    
    public void setFunciones(String funciones) {
        this.funciones = funciones;
    }
    public String getJefe() {
        return this.jefe;
    }
    
    public void setJefe(String jefe) {
        this.jefe = jefe;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public Date getFechaInicio() {
        return this.fechaInicio;
    }
    
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFinal() {
        return this.fechaFinal;
    }
    
    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }




}

