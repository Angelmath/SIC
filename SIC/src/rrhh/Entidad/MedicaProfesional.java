package rrhh.Entidad;
// Generated 23/01/2014 08:44:55 AM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * MedicaProfesional generated by hbm2java
 */
public class MedicaProfesional  implements java.io.Serializable {


     private int id;
     private Integer ci;
     private Date fecha;
     private String empresa;
     private String diagnostico;
     private String friesgo;
     private String agriesgo;

    public MedicaProfesional() {
    }

	
    public MedicaProfesional(int id) {
        this.id = id;
    }
    public MedicaProfesional(int id, Integer ci, Date fecha, String empresa, String diagnostico, String friesgo, String agriesgo) {
       this.id = id;
       this.ci = ci;
       this.fecha = fecha;
       this.empresa = empresa;
       this.diagnostico = diagnostico;
       this.friesgo = friesgo;
       this.agriesgo = agriesgo;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public Integer getCi() {
        return this.ci;
    }
    
    public void setCi(Integer ci) {
        this.ci = ci;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getEmpresa() {
        return this.empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public String getDiagnostico() {
        return this.diagnostico;
    }
    
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String getFriesgo() {
        return this.friesgo;
    }
    
    public void setFriesgo(String friesgo) {
        this.friesgo = friesgo;
    }
    public String getAgriesgo() {
        return this.agriesgo;
    }
    
    public void setAgriesgo(String agriesgo) {
        this.agriesgo = agriesgo;
    }




}


