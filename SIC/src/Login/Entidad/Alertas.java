package Login.Entidad;
// Generated 13/04/2015 15:59:07 by Hibernate Tools 3.2.1.GA



/**
 * Alertas generated by hbm2java
 */
public class Alertas  implements java.io.Serializable {


     private int id;
     private String tipo;
     private String desccripcion;

    public Alertas() {
    }

	
    public Alertas(int id) {
        this.id = id;
    }
    public Alertas(int id, String tipo, String desccripcion) {
       this.id = id;
       this.tipo = tipo;
       this.desccripcion = desccripcion;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getDesccripcion() {
        return this.desccripcion;
    }
    
    public void setDesccripcion(String desccripcion) {
        this.desccripcion = desccripcion;
    }




}


