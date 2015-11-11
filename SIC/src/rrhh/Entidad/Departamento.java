package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Departamento generated by hbm2java
 */
public class Departamento  implements java.io.Serializable {


     private int id;
     private Empleado empleado;
     private String nombre;
     private String correoDept;
     private String telefono;
     private Set deptEmpls = new HashSet(0);

    public Departamento() {
    }

	
    public Departamento(int id) {
        this.id = id;
    }
    public Departamento(int id, Empleado empleado, String nombre, String correoDept, String telefono, Set deptEmpls) {
       this.id = id;
       this.empleado = empleado;
       this.nombre = nombre;
       this.correoDept = correoDept;
       this.telefono = telefono;
       this.deptEmpls = deptEmpls;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreoDept() {
        return this.correoDept;
    }
    
    public void setCorreoDept(String correoDept) {
        this.correoDept = correoDept;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public Set getDeptEmpls() {
        return this.deptEmpls;
    }
    
    public void setDeptEmpls(Set deptEmpls) {
        this.deptEmpls = deptEmpls;
    }




}


