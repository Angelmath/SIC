package Login.Entidad;
// Generated 30/08/2014 10:19:38 AM by Hibernate Tools 3.2.1.GA



/**
 * Orden generated by hbm2java
 */
public class Orden  implements java.io.Serializable {


     private int id;
     private String nombre;
     private String instalacion;
     private String proyecto;
     private String grupo;

    public Orden() {
    }

	
    public Orden(int id) {
        this.id = id;
    }
    public Orden(int id, String nombre, String instalacion, String proyecto, String grupo) {
       this.id = id;
       this.nombre = nombre;
       this.instalacion = instalacion;
       this.proyecto = proyecto;
       this.grupo = grupo;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getInstalacion() {
        return this.instalacion;
    }
    
    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }
    public String getProyecto() {
        return this.proyecto;
    }
    
    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }
    public String getGrupo() {
        return this.grupo;
    }
    
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }




}

