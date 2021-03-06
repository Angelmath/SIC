package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA

import java.util.Date;

/**
 * CvEstudio generated by hbm2java
 */
public class CvEstudio  implements java.io.Serializable {


     private int id;
     private String pais;
     private String institucion;
     private String nivel;
     private String area;
     private String cedula;
     private Date fechaInicio;
     private Date fechaFinal;

    public CvEstudio() {
    }

	
    public CvEstudio(int id) {
        this.id = id;
    }
    public CvEstudio(int id, String pais, String institucion, String nivel, String area, String cedula, Date fechaInicio, Date fechaFinal) {
       this.id = id;
       this.pais = pais;
       this.institucion = institucion;
       this.nivel = nivel;
       this.area = area;
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
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getInstitucion() {
        return this.institucion;
    }
    
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    public String getNivel() {
        return this.nivel;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public String getArea() {
        return this.area;
    }
    
    public void setArea(String area) {
        this.area = area;
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


