package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * DeptEmpl generated by hbm2java
 */
public class DeptEmpl  implements java.io.Serializable {


     private int id;
     private Departamento departamento;
     private Empleado empleado;
     private Set empleados = new HashSet(0);

    public DeptEmpl() {
    }

	
    public DeptEmpl(int id) {
        this.id = id;
    }
    public DeptEmpl(int id, Departamento departamento, Empleado empleado, Set empleados) {
       this.id = id;
       this.departamento = departamento;
       this.empleado = empleado;
       this.empleados = empleados;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Departamento getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    public Set getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set empleados) {
        this.empleados = empleados;
    }




}

