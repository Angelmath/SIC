package Login.Entidad;
// Generated 11/05/2014 06:20:53 PM by Hibernate Tools 3.2.1.GA



/**
 * Ctepagar generated by hbm2java
 */
public class Ctepagar  implements java.io.Serializable {


     private int id;
     private String detalle;
     private String fecha;
     private String valor;
     private String total;
     private String instalacion;
     private String idinstalacion;
     private String cliente;
     private String idcliente;
     private String dias;

    public Ctepagar() {
    }

    public Ctepagar(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getInstalacion() {
        return instalacion;
    }

    public void setInstalacion(String instalacion) {
        this.instalacion = instalacion;
    }

    public String getIdinstalacion() {
        return idinstalacion;
    }

    public void setIdinstalacion(String idinstalacion) {
        this.idinstalacion = idinstalacion;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

}


