package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA



/**
 * Anticipos generated by hbm2java
 */
public class Permisos  implements java.io.Serializable {


     private int id;
     private String motivo;
     private String observacion;
     private String valor;
     private String accion;
     private String ci;
     private String mes;
     private String anio;
     private String responsable;
     private String fecha;
     private String detalle;

    public String getFecha() {
        return fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
     
    public Permisos() {
    }

	
    public Permisos(int id) {
        this.id = id;
    }
    public Permisos(int id, String motivo, String observacion, String valor, String accion, String ci, String mes, String anio, String responsable) {
       this.id = id;
       this.motivo = motivo;
       this.observacion = observacion;
       this.valor = valor;
       this.accion = accion;
       this.ci = ci;
       this.mes = mes;
       this.anio = anio;
       this.responsable = responsable;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getMotivo() {
        return this.motivo;
    }
    
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getValor() {
        return this.valor;
    }
    
    public void setValor(String valor) {
        this.valor = valor;
    }
    public String getAccion() {
        return this.accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }
    public String getCi() {
        return this.ci;
    }
    
    public void setCi(String ci) {
        this.ci = ci;
    }
    public String getMes() {
        return this.mes;
    }
    
    public void setMes(String mes) {
        this.mes = mes;
    }
    public String getAnio() {
        return this.anio;
    }
    
    public void setAnio(String anio) {
        this.anio = anio;
    }
    public String getResponsable() {
        return this.responsable;
    }
    
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }




}


