package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA



/**
 * CvIdioma generated by hbm2java
 */
public class CvIdioma  implements java.io.Serializable {


     private int id;
     private String idioma;
     private String escrito;
     private String oral;
     private String cedula;

    public CvIdioma() {
    }

	
    public CvIdioma(int id) {
        this.id = id;
    }
    public CvIdioma(int id, String idioma, String escrito, String oral, String cedula) {
       this.id = id;
       this.idioma = idioma;
       this.escrito = escrito;
       this.oral = oral;
       this.cedula = cedula;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getIdioma() {
        return this.idioma;
    }
    
    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
    public String getEscrito() {
        return this.escrito;
    }
    
    public void setEscrito(String escrito) {
        this.escrito = escrito;
    }
    public String getOral() {
        return this.oral;
    }
    
    public void setOral(String oral) {
        this.oral = oral;
    }
    public String getCedula() {
        return this.cedula;
    }
    
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }




}


