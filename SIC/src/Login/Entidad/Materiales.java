package Login.Entidad;
// Generated 28/08/2014 03:32:24 PM by Hibernate Tools 3.2.1.GA

import java.util.Date;




/**
 * Materiales generated by hbm2java
 */
public class Materiales  implements java.io.Serializable {

     private int id;
     private String nombre;
     private String orden;
     private Date inicio;
     private Date fin;
     private String aprobado;
     private String ordentrabajo;
     
    public Materiales() {
    }

    public String getOrden() {
        return orden;
    }

    public String getOrdentrabajo() {
        return ordentrabajo;
    }

    public void setOrdentrabajo(String ordentrabajo) {
        this.ordentrabajo = ordentrabajo;
    }

    public String getAprobado() {
        return aprobado;
    }

    public void setAprobado(String aprobado) {
        this.aprobado = aprobado;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public void setOrden(String orden) {
        this.orden = orden;
    }

	
    public Materiales(int id, Listamateriales listamateriales) {
        this.id = id;
    }
    public Materiales(int id, Listamateriales listamateriales, String nombre) {
       this.id = id;
       this.nombre = nombre;
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




}


