package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Empleado generated by hbm2java
 */
public class Empleado  implements java.io.Serializable {
        private int ci;
     private DeptEmpl deptEmpl;
     private String nombre1;
     private String nombre2;
     private String apellido1;
     private String apellido2;
     private String correo;
     private String foto;
     private Character genero;
     private Character estadoCivil;
     private String pais;
     private String ciudad;
     private String cuidadResidencia;
     private String direccion;
     private String telefono;
     private String celular;
     private String cv;
     private Date fechaNacimiento;
     private Date fechaIngreso;
     private String estado;
     private String ultimo;
     private String cliente;
     private String team;
     private String cuentatipo;
     private String cuentadue;
     private String cuentaci;
     private String cuentanum;
     private String cumple2;
     private String salidaemp;
     private String dato1;
     private String dato2;
     private String dato3;
     private String banco;
     private String departamento;
     private String fondos;
     private String decimotercero;
     private String decimocuarto;
     private String actividades;
     private String alimentacion;
     private String perfilpuesto;
     private String dato4;
     private String cid;
     private Set departamentos = new HashSet(0);
     private Set departamentos_1 = new HashSet(0);
     private Set deptEmpls = new HashSet(0);
     private Set deptEmpls_1 = new HashSet(0);

    public Empleado() {
    }
	
    public Empleado(int ci, String cid) {
        this.ci = ci;
        this.cid = cid;
    }

    public Empleado(int ci, DeptEmpl deptEmpl, String nombre1, String nombre2, String apellido1, String apellido2, String correo, String foto, Character genero, Character estadoCivil, String pais, String ciudad, String cuidadResidencia, String direccion, String telefono, String celular, String cv, Date fechaNacimiento, Date fechaIngreso, String estado, String ultimo, String cliente, String team, String cuentatipo, String cuentadue, String cuentaci, String cuentanum, String cumple2, String salidaemp, String dato1, String dato2, String dato3, String banco, String departamento, String fondos, String decimotercero, String decimocuarto, String actividades, String alimentacion, String perfilpuesto, String dato4, String cid) {
        this.ci = ci;
        this.deptEmpl = deptEmpl;
        this.nombre1 = nombre1;
        this.nombre2 = nombre2;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.correo = correo;
        this.foto = foto;
        this.genero = genero;
        this.estadoCivil = estadoCivil;
        this.pais = pais;
        this.ciudad = ciudad;
        this.cuidadResidencia = cuidadResidencia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.cv = cv;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.ultimo = ultimo;
        this.cliente = cliente;
        this.team = team;
        this.cuentatipo = cuentatipo;
        this.cuentadue = cuentadue;
        this.cuentaci = cuentaci;
        this.cuentanum = cuentanum;
        this.cumple2 = cumple2;
        this.salidaemp = salidaemp;
        this.dato1 = dato1;
        this.dato2 = dato2;
        this.dato3 = dato3;
        this.banco = banco;
        this.departamento = departamento;
        this.fondos = fondos;
        this.decimotercero = decimotercero;
        this.decimocuarto = decimocuarto;
        this.actividades = actividades;
        this.alimentacion = alimentacion;
        this.perfilpuesto = perfilpuesto;
        this.dato4 = dato4;
        this.cid = cid;
    }
    
    public String getDecimotercero() {
        return decimotercero;
    }

    public void setDecimotercero(String decimotercero) {
        this.decimotercero = decimotercero;
    }

    public String getDecimocuarto() {
        return decimocuarto;
    }

    public void setDecimocuarto(String decimocuarto) {
        this.decimocuarto = decimocuarto;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getAlimentacion() {
        return alimentacion;
    }

    public void setAlimentacion(String alimentacion) {
        this.alimentacion = alimentacion;
    }
    
    public int getCi() {
        return this.ci;
    }
    
    public void setCi(int ci) {
        this.ci = ci;
    }
    public DeptEmpl getDeptEmpl() {
        return this.deptEmpl;
    }
    
    public void setDeptEmpl(DeptEmpl deptEmpl) {
        this.deptEmpl = deptEmpl;
    }
    public String getNombre1() {
        return this.nombre1;
    }
    
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }
    public String getNombre2() {
        return this.nombre2;
    }
    
    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }
    public String getApellido1() {
        return this.apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return this.apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getFoto() {
        return this.foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public Character getGenero() {
        return this.genero;
    }
    
    public void setGenero(Character genero) {
        this.genero = genero;
    }
    public Character getEstadoCivil() {
        return this.estadoCivil;
    }
    
    public void setEstadoCivil(Character estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public String getPais() {
        return this.pais;
    }
    
    public void setPais(String pais) {
        this.pais = pais;
    }
    public String getCiudad() {
        return this.ciudad;
    }
    
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    public String getCuidadResidencia() {
        return this.cuidadResidencia;
    }
    
    public void setCuidadResidencia(String cuidadResidencia) {
        this.cuidadResidencia = cuidadResidencia;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getCv() {
        return this.cv;
    }
    
    public void setCv(String cv) {
        this.cv = cv;
    }
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }
    
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }
    
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getUltimo() {
        return this.ultimo;
    }
    
    public void setUltimo(String ultimo) {
        this.ultimo = ultimo;
    }
    public String getCliente() {
        return this.cliente;
    }
    
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getTeam() {
        return this.team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    public String getCuentatipo() {
        return this.cuentatipo;
    }
    
    public void setCuentatipo(String cuentatipo) {
        this.cuentatipo = cuentatipo;
    }
    public String getCuentadue() {
        return this.cuentadue;
    }
    
    public void setCuentadue(String cuentadue) {
        this.cuentadue = cuentadue;
    }
    public String getCuentaci() {
        return this.cuentaci;
    }
    
    public void setCuentaci(String cuentaci) {
        this.cuentaci = cuentaci;
    }
    public String getCuentanum() {
        return this.cuentanum;
    }
    
    public void setCuentanum(String cuentanum) {
        this.cuentanum = cuentanum;
    }
    public String getCumple2() {
        return this.cumple2;
    }
    
    public void setCumple2(String cumple2) {
        this.cumple2 = cumple2;
    }
    public String getSalidaemp() {
        return this.salidaemp;
    }
    
    public void setSalidaemp(String salidaemp) {
        this.salidaemp = salidaemp;
    }
    public String getDato1() {
        return this.dato1;
    }
    
    public void setDato1(String dato1) {
        this.dato1 = dato1;
    }
    public String getDato2() {
        return this.dato2;
    }
    
    public void setDato2(String dato2) {
        this.dato2 = dato2;
    }
    public String getDato3() {
        return this.dato3;
    }
    
    public void setDato3(String dato3) {
        this.dato3 = dato3;
    }
    public String getBanco() {
        return this.banco;
    }
    
    public void setBanco(String banco) {
        this.banco = banco;
    }
    public String getDepartamento() {
        return this.departamento;
    }
    
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getFondos() {
        return this.fondos;
    }
    
    public void setFondos(String fondos) {
        this.fondos = fondos;
    }
    public String getPerfilpuesto() {
        return this.perfilpuesto;
    }
    
    public void setPerfilpuesto(String perfilpuesto) {
        this.perfilpuesto = perfilpuesto;
    }
    public String getDato4() {
        return this.dato4;
    }
    
    public void setDato4(String dato4) {
        this.dato4 = dato4;
    }
    public String getCid() {
        return this.cid;
    }
    
    public void setCid(String cid) {
        this.cid = cid;
    }
    public Set getDepartamentos() {
        return this.departamentos;
    }
    
    public void setDepartamentos(Set departamentos) {
        this.departamentos = departamentos;
    }
    public Set getDepartamentos_1() {
        return this.departamentos_1;
    }
    
    public void setDepartamentos_1(Set departamentos_1) {
        this.departamentos_1 = departamentos_1;
    }
    public Set getDeptEmpls() {
        return this.deptEmpls;
    }
    
    public void setDeptEmpls(Set deptEmpls) {
        this.deptEmpls = deptEmpls;
    }
    public Set getDeptEmpls_1() {
        return this.deptEmpls_1;
    }
    
    public void setDeptEmpls_1(Set deptEmpls_1) {
        this.deptEmpls_1 = deptEmpls_1;
    }




}
