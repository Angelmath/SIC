package Login.Entidad;
// Generated 14/03/2014 02:47:46 AM by Hibernate Tools 3.2.1.GA



/**
 * Inventario3 generated by hbm2java
 */
public class Inventario3  implements java.io.Serializable {


     private int id;
     private String tipo;
     private String descripcion;

    public Inventario3() {
    }

	
    public Inventario3(int id) {
        this.id = id;
    }
    public Inventario3(int id, String tipo, String descripcion) {
       this.id = id;
       this.tipo = tipo;
       this.descripcion = descripcion;
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
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }




}


