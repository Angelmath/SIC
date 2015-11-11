package Login.Entidad;
// Generated 28/03/2014 02:37:07 AM by Hibernate Tools 3.2.1.GA
/**
 * Factu generated by hbm2java
 */
public class Factu  implements java.io.Serializable {

     private int id;
     private String nombre;
     private String instalacion;
     private String proyecto;
     private String grupo;
     private String valor;
     private String fecha;
     private String sri;
     
    public Factu() {
    }
	
    public Factu(int id) {
        this.id = id;
    }
    public Factu(int id, String nombre, String instalacion, String proyecto) {
       this.id = id;
       this.nombre = nombre;
       this.instalacion = instalacion;
       this.proyecto = proyecto;
    }

    public String getSri() {
        return sri;
    }

    public void setSri(String sri) {
        this.sri = sri;
    }
   
    public int getId() {
        return this.id;
    }

    public String getGrupo() {
        return grupo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return this.nombre;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
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
}


