package Login.Entidad;
// Generated 11/05/2014 06:20:53 PM by Hibernate Tools 3.2.1.GA

import java.sql.Date;

/**
 * Ctepagar generated by hbm2java
 */
public class Items  implements java.io.Serializable {


     private int id;
     private String cat;
     private String marca;
     private String modelo;
     private String proveedor;
     private String idproveedor;
     private String dc;
     private String dl;
     private String costo;
     private String ft;
     private String otro1;
     private String otro2;
     private String codigo;
     private Date fecha;
     
    public Items() {
    }

    public Items(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
 
    public String getDc() {
        return dc;
    }

    public void setDc(String dc) {
        this.dc = dc;
    }

    public String getDl() {
        return dl;
    }

    public void setDl(String dl) {
        this.dl = dl;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getFt() {
        return ft;
    }

    public void setFt(String ft) {
        this.ft = ft;
    }

    public String getOtro1() {
        return otro1;
    }

    public void setOtro1(String otro1) {
        this.otro1 = otro1;
    }

    public String getOtro2() {
        return otro2;
    }

    public void setOtro2(String otro2) {
        this.otro2 = otro2;
    }

}

