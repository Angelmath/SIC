package sgi.tablas;
// Generated 21-sep-2015 12:32:52 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * RPall generated by hbm2java
 */
public class RPall  implements java.io.Serializable {


     private int id;
     private String numero;
     private Date fecha;
     private String horaini;
     private String horafin;
     private String tipo;
     private Integer idfoto;
     private String punto;

    public RPall() {
    }

	
    public RPall(int id) {
        this.id = id;
    }
    public RPall(int id, String numero, Date fecha, String horaini, String horafin, String tipo, Integer idfoto, String punto) {
       this.id = id;
       this.numero = numero;
       this.fecha = fecha;
       this.horaini = horaini;
       this.horafin = horafin;
       this.tipo = tipo;
       this.idfoto = idfoto;
       this.punto = punto;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero() {
        return this.numero;
    }
    
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getHoraini() {
        return this.horaini;
    }
    
    public void setHoraini(String horaini) {
        this.horaini = horaini;
    }
    public String getHorafin() {
        return this.horafin;
    }
    
    public void setHorafin(String horafin) {
        this.horafin = horafin;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Integer getIdfoto() {
        return this.idfoto;
    }
    
    public void setIdfoto(Integer idfoto) {
        this.idfoto = idfoto;
    }
    public String getPunto() {
        return this.punto;
    }
    
    public void setPunto(String punto) {
        this.punto = punto;
    }




}


