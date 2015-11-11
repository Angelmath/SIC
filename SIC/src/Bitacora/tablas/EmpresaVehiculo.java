package Bitacora.tablas;
// Generated 23/03/2015 16:39:48 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * EmpresaVehiculo generated by hbm2java
 */
public class EmpresaVehiculo  implements java.io.Serializable {


     private int id;
     private String placa;
     private Set vehiculos = new HashSet(0);

    public EmpresaVehiculo() {
    }

	
    public EmpresaVehiculo(int id) {
        this.id = id;
    }
    public EmpresaVehiculo(int id, String placa, Set vehiculos) {
       this.id = id;
       this.placa = placa;
       this.vehiculos = vehiculos;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getPlaca() {
        return this.placa;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public Set getVehiculos() {
        return this.vehiculos;
    }
    
    public void setVehiculos(Set vehiculos) {
        this.vehiculos = vehiculos;
    }




}

