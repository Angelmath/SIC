package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA



/**
 * CvAdicional generated by hbm2java
 */
public class CvAdicional  implements java.io.Serializable {


     private int id;
     private String aspiracion;
     private String discapacidad;
     private String conadis;
     private String tipo;
     private String conocimientos;
     private String porcentaje;
     private String nivel;
     private String cedula;

    public CvAdicional() {
    }

	
    public CvAdicional(int id) {
        this.id = id;
    }
    public CvAdicional(int id, String aspiracion, String discapacidad, String conadis, String tipo, String conocimientos, String porcentaje, String nivel, String cedula) {
       this.id = id;
       this.aspiracion = aspiracion;
       this.discapacidad = discapacidad;
       this.conadis = conadis;
       this.tipo = tipo;
       this.conocimientos = conocimientos;
       this.porcentaje = porcentaje;
       this.nivel = nivel;
       this.cedula = cedula;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getAspiracion() {
        return this.aspiracion;
    }
    
    public void setAspiracion(String aspiracion) {
        this.aspiracion = aspiracion;
    }
    public String getDiscapacidad() {
        return this.discapacidad;
    }
    
    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }
    public String getConadis() {
        return this.conadis;
    }
    
    public void setConadis(String conadis) {
        this.conadis = conadis;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getConocimientos() {
        return this.conocimientos;
    }
    
    public void setConocimientos(String conocimientos) {
        this.conocimientos = conocimientos;
    }
    public String getPorcentaje() {
        return this.porcentaje;
    }
    
    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }
    public String getNivel() {
        return this.nivel;
    }
    
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }




}


