package sgi.tablas;
// Generated 21-sep-2015 12:32:52 by Hibernate Tools 4.3.1



/**
 * Panico generated by hbm2java
 */
public class Panico  implements java.io.Serializable {


     private int id;
     private String dispositivo;
     private String correo;
     private String mac;
     private String tipoAlerta;

    public Panico() {
    }

	
    public Panico(int id) {
        this.id = id;
    }
    public Panico(int id, String dispositivo, String correo, String mac, String tipoAlerta) {
       this.id = id;
       this.dispositivo = dispositivo;
       this.correo = correo;
       this.mac = mac;
       this.tipoAlerta = tipoAlerta;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getDispositivo() {
        return this.dispositivo;
    }
    
    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getMac() {
        return this.mac;
    }
    
    public void setMac(String mac) {
        this.mac = mac;
    }
    public String getTipoAlerta() {
        return this.tipoAlerta;
    }
    
    public void setTipoAlerta(String tipoAlerta) {
        this.tipoAlerta = tipoAlerta;
    }




}


