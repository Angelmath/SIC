/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.servicio;

import Login.Entidad.Articulos;
import Login.Entidad.Caldepartamento;
import Login.Entidad.Calendario;
import Login.Entidad.Calpermisos;
import Login.Entidad.Clientes;
import Login.Entidad.Contactos;
import Login.Entidad.Ctecobrar;
import Login.Entidad.Ctepagar;
import Login.Entidad.Diseno;
import Login.Entidad.Factu;
import Login.Entidad.Factura;
import Login.Entidad.Fcomisiones;
import Login.Entidad.Fechactecobrar;
import Login.Entidad.Fempleado;
import Login.Entidad.Indexcontable;
import Login.Entidad.Indexitem;
import Login.Entidad.Indexpresupuesto;
import Login.Entidad.Instalacion;
import Login.Entidad.Inventario;
import Login.Entidad.Inventario2;
import Login.Entidad.Inventario3;
import Login.Entidad.Items;
import Login.Entidad.Listamateriales;
import Login.Entidad.Login;
import Login.Entidad.Materiales;
import Login.Entidad.Notas;
import Login.Entidad.Noticalen;
import Login.Entidad.Notificaciones;
import Login.Entidad.Orden;
import Login.Entidad.Owncloud;
import Login.Entidad.Permisos;
import Login.Entidad.Presupuesto;
import Login.Entidad.Productos;
import Login.Entidad.Proveedores;
import Login.Entidad.Proyectos;
import Login.Entidad.Report;
import Login.Entidad.Retencion;
import Login.Entidad.Retencionfactu;
import Login.Entidad.Ticket;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Angelmath
 */

/*
 * 
 *      
 * 
 * 
 */
public class ServiceHb {

    private Session session = null;
    private org.hibernate.Transaction tx;

    public ServiceHb() {
      try{  
          this.session= HibernateUtil.getSessionFactory().getCurrentSession();
      }catch(Exception io){
         System.out.println(io);
      }
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Transaction getTx() {
        return tx;
    }

    public void setTx(Transaction tx) {
        this.tx = tx;
    }
    
    /*
     * ServicesHb General
     */
    public boolean iniciarTransaccion(){
        try{
            if (session.getTransaction() != null
                    && session.getTransaction().isActive()) {
                tx = session.getTransaction();
            } else {
                tx = session.beginTransaction();
            }
            this.session.clear();
        }catch (Exception ex) {
        }
        return true;
    }
    
    public void abortarTransaccion() throws Exception {
        if (tx != null) {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void confirmarTransaccion() {
        try{
        if (tx != null) {
            if (tx.isActive()) {
                tx.commit();
            }
        }
        }catch(Exception io){
            
        }
    }

    
    public void despejarObjeto(Object o) throws Exception {
        this.session.evict(o);
    }

    public boolean cerrarTransaccion() throws Exception {
        tx = null;
        return true;
    }

    public boolean cerrarSesion(){
      try{  
        tx = null;
        if (session.isOpen()) {
            session.flush();
            session.close();
        }
      }catch(Exception io){
          
      }
        return true;
    }

    public void crearObjeto(Object o) throws Exception {
        session.save(o);
    }

    public void actualizarObjeto(Object o) throws Exception {
        session.update(o);
    }

    public void crearOrActualizarObjeto(Object o) throws Exception {
        session.saveOrUpdate(o);
    }

    public boolean eliminarObjeto(Object o) throws Exception {
        session.delete(o);
        return true;
    }
    public Object obtenerObjeto(Class o, int serie) throws Exception {
        
        return session.get(o, serie);
    }
    public List<Login> getlistaUsuarios() throws Exception {
        List<Login> lista;
        Query q = session.createQuery("FROM Login");
        lista = (List<Login>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Login> getlistaUsuarios(String cedula) throws Exception {
        List<Login> lista;
        Query q = session.createQuery("FROM Login WHERE ci='"+cedula+"'");
        lista = (List<Login>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Object[]> getlistaClientesSeguimiento() throws Exception {
        List<Object[]> lista;
        Query q = session.createQuery("FROM Clientes  ORDER BY apellido ASC");
        lista = (List<Object[]>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public Retencionfactu getrentencion2(String id) throws Exception {
        List<Retencionfactu> lista;
        Query q = session.createQuery("FROM Retencionfactu WHERE idnombre='"+id+"'");
        lista = (List<Retencionfactu>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Retencionfactu getrentencion(String id) throws Exception {
        List<Retencionfactu> lista;
        Query q = session.createQuery("FROM Retencionfactu WHERE idnombre='"+id+"'");
        lista = (List<Retencionfactu>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Clientes> getlistaClientes() throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes  ORDER BY apellido ASC");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Noticalen> getlistaNotiCalen(String dueno) throws Exception {
        List<Noticalen> lista;
        Query q = session.createQuery("FROM Noticalen WHERE dueno='"+dueno+"' AND visto='NO'");
        lista = (List<Noticalen>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Clientes> getlistaClientes2(Login responsable) throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes WHERE (login.id=23) ORDER BY apellido ASC");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Clientes> getlistaClientes(Login responsable) throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes WHERE responsable='"+responsable.getNombre()+"'ORDER BY apellido ASC");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    public List<Clientes> getlistaClientesSearch(String palabra) throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes WHERE upper(apellido) LIKE upper('%"+palabra+"%') ORDER BY apellido ASC");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Clientes> getlistaClientesSearch2(String palabra, String responsable) throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes WHERE (login.id=23) AND upper(apellido) LIKE upper('%"+palabra+"%') ORDER BY apellido ASC");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Clientes> getlistaClientesSearch(String palabra, String responsable) throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes WHERE responsable='"+responsable+"' AND upper(apellido) LIKE upper('%"+palabra+"%') ORDER BY apellido ASC");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Permisos> getlistaPermisos(Login log)  {
        List<Permisos> lista=null;
        try{
            Query q = session.createQuery("SELECT l.permisos FROM LoginPermisos l  WHERE l.login.id="+log.getId()+" ORDER BY l.permisos.acceso ASC");
            lista = (List<Permisos>) q.list();            
        }catch(Exception io){
            System.out.println(io);
        }
        if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
    }
    
    public List<Proveedores> getlistaProveedores() throws Exception {
        List<Proveedores> lista;
        Query q = session.createQuery("FROM Proveedores");
        lista = (List<Proveedores>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Items> getlistaItems(String categoria) throws Exception {
        List<Items> lista;
        Query q=null;
        if(categoria.equalsIgnoreCase("ALL")){
        q = session.createQuery("FROM Items");
        }else{
        q = session.createQuery("FROM Items WHERE cat='"+categoria+"'");
        }
        lista = (List<Items>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Items> getlistaItems(String categoria, String texto) throws Exception {
        List<Items> lista;
        Query q=null;
        if(categoria.equalsIgnoreCase("ALL")){
        q = session.createQuery("FROM Items WHERE upper(modelo) LIKE upper('%"+texto+"%') OR upper(codigo) LIKE upper('%"+texto+"%')");
        }else{
        q = session.createQuery("FROM Items WHERE cat='"+categoria+"' AND (upper(modelo) LIKE upper('%"+texto+"%') OR upper(codigo) LIKE upper('%"+texto+"%'))");
        }
        lista = (List<Items>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Items> getlistaItems2(String categoria, String text) throws Exception {
        List<Items> lista;
        Query q=null;
        if(categoria.equalsIgnoreCase("ALL")){
        q = session.createQuery("FROM Items");
        }else{
        q = session.createQuery("FROM Items WHERE cat='"+categoria+"' AND upper(dc) LIKE upper('%"+text+"%')");
        }
        lista = (List<Items>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ticket> getlistaTicket() throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalaciones() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    public List<Instalacion> getlistaInstalaciones2(int num) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE idcliente='"+num+"' AND selectt IS null");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionesAprobadaSearch(String palabra) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='En Diseño' AND selectt IS NOT null ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionesAprobadaSearch(String palabra,Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.login.nombre='"+responsable.getNombre()+"' AND upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='En Diseño' AND selectt IS NOT null ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionesenaprobacion() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Espera Aprobación Tecnica'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionesencurso() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionesencurso2() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño' AND selectt IS null AND clientes.login.nivel='Ventas'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionesencurso(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño' AND selectt IS null AND clientes.login.nombre='"+responsable.getNombre()+"'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionesenaprobacion2() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Espera Aprobación Tecnica' AND (clientes.login.nivel='Ventas')");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionesenaprobacion(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Espera Aprobación Tecnica' AND clientes.login.nombre='"+responsable.getNombre()+"'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionesencurso2(String responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño' AND selectt IS null AND responsable='"+responsable+"' ORDER BY apellido ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionaprobada2(String responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño' AND selectt IS NOT null AND responsable='"+responsable+"' ORDER BY apellido ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Notificaciones> getNotificacionesNV(String modulo) throws Exception {
        List<Notificaciones> lista;
        Query q = session.createQuery("FROM Notificaciones WHERE visto='NO'  ORDER BY fecha DESC");
        lista = (List<Notificaciones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Notificaciones> getNotificacionesV(String modulo) throws Exception {
        List<Notificaciones> lista;
        Query q = session.createQuery("FROM Notificaciones WHERE visto='SI'  ORDER BY fecha DESC");
        lista = (List<Notificaciones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Notificaciones> getNotificaciones(String modulo) throws Exception {
        List<Notificaciones> lista;
        Query q = session.createQuery("FROM Notificaciones ORDER BY fecha DESC");
        lista = (List<Notificaciones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionFinan(int tipo) throws Exception {
        List<Instalacion> lista;
        Query q =null;
        if(tipo==0){
        q = session.createQuery("FROM Instalacion WHERE (proceso='Espera Aprobación Financiera' OR proceso='Aprobación Financiera' OR proceso='En Curso' OR proceso='Culminada' OR proceso='Facturado' OR proceso='Cancelado')");
        }
        if(tipo==1){
        q = session.createQuery("FROM Instalacion WHERE (proceso='Espera Aprobación Financiera')");
        }
        if(tipo==2){
        q = session.createQuery("FROM Instalacion WHERE (proceso='Aprobación Financiera')");
        }
        if(tipo==3){
        q = session.createQuery("FROM Instalacion WHERE (proceso='En Curso')");
        }
        if(tipo==4){
        q = session.createQuery("FROM Instalacion WHERE (proceso='Culminada')");
        }
        if(tipo==5){
        q = session.createQuery("FROM Instalacion WHERE (proceso='Facturado')");
        }
        if(tipo==6){
        q = session.createQuery("FROM Instalacion WHERE (proceso='Cancelado')");
        }
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionFinan2(int tipo, String palabra,String palabra2) {
        List<Instalacion> lista=null;
        Query q =null;
        try{
            if(tipo==0){
            q = session.createQuery("FROM Instalacion WHERE (proceso='Espera Aprobación Financiera' OR proceso='Aprobación Financiera' OR proceso='En Curso' OR proceso='Culminada' OR proceso='Facturado' OR proceso='Cancelado') AND (upper(detalle) LIKE upper('%"+palabra+"%') AND upper(clientes.apellido) LIKE upper('%"+palabra2+"%'))");
            }
            if(tipo==1){
            q = session.createQuery("FROM Instalacion WHERE (proceso='Espera Aprobación Financiera') AND (upper(detalle) LIKE upper('%"+palabra+"%') AND upper(clientes.apellido) LIKE upper('%"+palabra2+"%'))");
            }
            if(tipo==2){
            q = session.createQuery("FROM Instalacion WHERE (proceso='Aprobación Financiera') AND (upper(detalle) LIKE upper('%"+palabra+"%') AND upper(clientes.apellido) LIKE upper('%"+palabra2+"%'))");
            }
            if(tipo==3){
            q = session.createQuery("FROM Instalacion WHERE (proceso='En Curso') AND (upper(detalle) LIKE upper('%"+palabra+"%') AND upper(clientes.apellido) LIKE upper('%"+palabra2+"%'))");
            }
            if(tipo==4){
            q = session.createQuery("FROM Instalacion WHERE (proceso='Culminada') AND (upper(detalle) LIKE upper('%"+palabra+"%') AND upper(clientes.apellido) LIKE upper('%"+palabra2+"%'))");
            }
            if(tipo==5){
            q = session.createQuery("FROM Instalacion WHERE (proceso='Facturado') AND (upper(detalle) LIKE upper('%"+palabra+"%') AND upper(clientes.apellido) LIKE upper('%"+palabra2+"%'))");
            }
            if(tipo==6){
            q = session.createQuery("FROM Instalacion WHERE (proceso='Cancelado') AND (upper(detalle) LIKE upper('%"+palabra+"%') AND upper(clientes.apellido) LIKE upper('%"+palabra2+"%'))");
            }
            if(tipo==11){
            q = session.createQuery("FROM Instalacion WHERE (proceso='Espera Aprobación Financiera' OR proceso='Aprobación Financiera' OR proceso='En Curso' OR proceso='Culminada' OR proceso='Facturado' OR proceso='Cancelado') AND (upper(detalle) LIKE upper('%"+palabra+"%') OR upper(clientes.apellido) LIKE upper('%"+palabra2+"%'))");
            }
            lista = (List<Instalacion>) q.list();
            }catch(Exception io){
                System.out.println(io);
            }
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Instalacion> getlistaInstalacionaprobada() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aprobación Tecnica' AND selectt IS NOT null");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
   
    public List<Instalacion> getlistaInstalacionaprobada2() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aprobación Tecnica' AND selectt IS NOT null AND (clientes.login.nivel='Ventas')");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionaprobada(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aprobación Tecnica' AND selectt IS NOT null AND clientes.login.nombre='"+responsable.getNombre()+"'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctepagar> getlistactepagar() throws Exception {
        List<Ctepagar> lista;
        Query q = session.createQuery("FROM Ctepagar" );
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Retencion> getlistaret() throws Exception {
        List<Retencion> lista;
        Query q = session.createQuery("FROM Retencion" );
        lista = (List<Retencion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Factu> getlistafact() throws Exception {
        List<Factu> lista;
        Query q = session.createQuery("FROM Factu" );
        lista = (List<Factu>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionDiseñoSearch(String palabra, Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.login.nombre='"+responsable.getNombre()+"' AND proceso='En Diseño' AND selectt IS null AND upper(detalle) LIKE upper('%"+palabra+"%')   ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
   
        
    public List<Instalacion> getlistaInstalacionDiseñoSearch(String palabra) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño' AND selectt IS null AND upper(detalle) LIKE upper('%"+palabra+"%')   ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionAceptadaSearch(String palabra, Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.login.nombre='"+responsable.getNombre()+"' AND upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='Aceptada por Cliente' ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionRechazadaSearch(String palabra, Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.login.nombre='"+responsable.getNombre()+"' AND upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='Enviada a Cliente' ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionEnviadaSearch(String palabra, Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.login.nombre='"+responsable.getNombre()+"' AND upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='Enviada a Cliente' ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionAceptadaSearch(String palabra) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='Aceptada por Cliente' ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionRechazadaSearch(String palabra) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='Rechazada por Cliente' ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionEnviadaSearch(String palabra) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='Enviada a Cliente' ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionEnviada2() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Enviada a Cliente' AND (clientes.login.nivel='Ventas') ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionEnviada(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Enviada a Cliente' AND clientes.login.nombre='"+responsable.getNombre()+"' ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    
    public List<Instalacion> getlistaInstalacionEnviada() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Enviada a Cliente' ORDER BY detalle ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionDiseño() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño' AND selectt IS null");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionDiseño(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño' AND selectt IS null AND clientes.login.nombre='"+responsable.getNombre()+"'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionAprobada(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.login.nombre='"+responsable.getNombre()+"' AND proceso='En Diseño' AND selectt IS NOT null");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionAprobada() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='En Diseño' AND selectt IS NOT null");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionEnviada2(String responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Enviada a Cliente'  AND responsable='"+responsable+"' ORDER BY apellido ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Items getItems(String id) throws Exception {
        List<Items> lista;
        Query q = session.createQuery("FROM Items WHERE codigo='"+id+"'");
        lista = (List<Items>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Instalacion getInstalacionid(String id) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE id="+id+"");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Instalacion> getInstalacionnotifi(java.sql.Date sqlDate) throws Exception {
        List<Instalacion> lista;
        
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Culminada' AND (fechafininsta =>"+sqlDate+")");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Instalacion getInstalacion(String responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE id="+responsable+"");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    public List<Instalacion> getlistaInstalacionAceptada2(String responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aceptada por Cliente' AND responsable='"+responsable+"' ORDER BY apellido ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionRechazada2() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Rechazada por Cliente' AND (clientes.login.nivel='Ventas')");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionRechazada(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Rechazada por Cliente' AND clientes.login.nombre='"+responsable.getNombre()+"' ");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionAceptada2() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aceptada por Cliente' AND (clientes.login.nivel='Ventas') ");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionAceptada3() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aceptada por Cliente' AND (clientes.login.nivel='Ventas') ");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionAceptada(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aceptada por Cliente' AND clientes.login.nombre='"+responsable.getNombre()+"' ");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Productos> getlistaProductos() throws Exception {
        List<Productos> lista;
        Query q = session.createQuery("FROM Productos");
        lista = (List<Productos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Listamateriales> getlistaMaterial() throws Exception {
        List<Listamateriales> lista;
        Query q = session.createQuery("FROM Listamateriales");
        lista = (List<Listamateriales>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Materiales getMaterialesnombre(String mate) throws Exception {
        List<Materiales> lista;
        
        Query q = session.createQuery("FROM Materiales WHERE id="+mate.substring(12, mate.length())+" ORDER BY id ASC");
        lista = (List<Materiales>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Materiales> getMateriales(String mate) throws Exception {
        List<Materiales> lista;
        Query q = session.createQuery("FROM Materiales WHERE orden='"+mate+"' ORDER BY id ASC");
        lista = (List<Materiales>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
     public List<Listamateriales> getlistaMateriales(String mate) throws Exception {
        List<Listamateriales> lista;
        Query q = session.createQuery("FROM Listamateriales WHERE material="+mate+"");
        lista = (List<Listamateriales>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionEstados(Login responsable) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aceptada por Cliente' OR proceso='Espera Aprobación Financiera' OR proceso='Aprobación Financiera' OR proceso='En Curso' OR proceso='Culminada' OR proceso='Facturado' OR proceso='Cancelado' AND clientes.login.nombre='"+responsable.getNombre()+"' ");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionEstados() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aceptada por Cliente' OR proceso='Espera Aprobación Financiera' OR proceso='Aprobación Financiera' OR proceso='En Curso' OR proceso='Culminada' OR proceso='Facturado' OR proceso='Cancelado'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionAceptada() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Aceptada por Cliente'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionRechazada() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Rechazada por Cliente'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Instalacion getlistaInstalacionpyl(int numero) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE tick="+numero+"");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Ticket getTicket2(int numero) throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE id="+numero+"");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Object[]> getlistaseguimiento(String responsable) throws Exception {
        List<Object[]> lista;
        Query q = session.createQuery("FROM Clientes WHERE responsable='"+responsable+"' ORDER BY apellido ASC");
        lista = (List<Object[]>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Clientes> getlistaClientes3() throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes WHERE login.nivel='Ventas' ORDER BY apellido ASC");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Clientes> getlistaClientes2(int responsable) throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes WHERE login.id="+responsable+" OR login2.id="+responsable+" OR login3.id="+responsable+" ORDER BY apellido ASC");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionSearch(String palabra,String cliente) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE idcliente='"+cliente+"' AND upper(detalle) LIKE upper('%"+palabra+"%')");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacion3(String cliente) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.apellido="+cliente+"");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionseguimiento() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionseguimiento(String cadena) throws Exception {
        List<Instalacion> lista;
        Query q=null;
        if(cadena.equalsIgnoreCase("Todos")){
            q = session.createQuery("FROM Instalacion ");
        }else{
            q = session.createQuery("FROM Instalacion WHERE proceso='"+cadena+"'");
        }
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionseguimiento(String cadena,String cadena2) throws Exception {
        List<Instalacion> lista;
        Query q=null;
        if(cadena2.equalsIgnoreCase("Todos")){
            q = session.createQuery("FROM Instalacion WHERE clientes.responsable='"+cadena+"'");
        }else{
            q = session.createQuery("FROM Instalacion WHERE proceso='"+cadena2+"' AND clientes.responsable='"+cadena+"'");
        }
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacion2(String cliente) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.id="+cliente+"");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstPresupuesto(Clientes cliente) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.id="+cliente.getId()+" ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstPresupuesto(Clientes cliente, String campo) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.id="+cliente.getId()+" AND upper(detalle) LIKE upper('%"+campo+"%')");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionSoporteBodega(String texto) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE tipo='Soporte Técnico' AND proceso='' AND upper(detalle) LIKE upper('%"+texto+"%') AND proceso='Espera Aprobación Tecnica'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionSoporte(int id,String texto) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.id="+id+" AND tipo='Soporte Técnico' AND upper(detalle) LIKE upper('%"+texto+"%') AND proceso='En Diseño'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionSoporteBodega() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE tipo='Soporte Técnico' AND proceso='Espera Aprobación Tecnica'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionSoporte(int id) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.id="+id+" AND tipo='Soporte Técnico' AND proceso='En Diseño'");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacion(Clientes cliente) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE clientes.id="+cliente.getId()+"");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Factura> getlistaFactura(java.sql.Date inicio, java.sql.Date fin) throws Exception {
        List<Factura> lista;
        Query q = session.createQuery("FROM Factura WHERE (fecha>='"+inicio+"' AND NOT fecha<'"+inicio+"' OR (fecha IS NOT NULL AND fecha BETWEEN '"+inicio+"' AND '"+fin+"')) ORDER BY fecha ASC");
        lista = (List<Factura>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Factura> getlistaFacturasInsta(java.sql.Date inicio, java.sql.Date fin) throws Exception {
        List<Factura> lista;
        Query q = session.createQuery("FROM Factura WHERE  ORDER BY fecha ASC");
        lista = (List<Factura>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Factura> getlistaFactura(java.sql.Date inicio, java.sql.Date fin, String tipo) throws Exception {
        List<Factura> lista;
        Query q = session.createQuery("FROM Factura WHERE pagado='"+tipo+"' AND ((fecha>='"+inicio+"' AND NOT fecha<'"+inicio+"' OR (fecha IS NOT NULL AND fecha BETWEEN '"+inicio+"' AND '"+fin+"'))) ORDER BY fecha ASC");
        lista = (List<Factura>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Indexcontable getIndexcontable(String indice) throws Exception {
        List<Indexcontable> lista;
        Query q = session.createQuery("FROM Indexcontable WHERE indice='"+indice+"'");
        lista = (List<Indexcontable>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Ctecobrar> getlistaCtecobrar(java.sql.Date inicio, java.sql.Date fin) throws Exception {
        List<Ctecobrar> lista;
        Query q = session.createQuery("FROM Ctecobrar WHERE fecha IS NOT NULL AND fecha BETWEEN '"+inicio+"' AND '"+fin+"' ORDER BY fecha ASC");
        lista = (List<Ctecobrar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionfacturado(java.sql.Date inicio, java.sql.Date fin) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Facturado' AND fechafactu IS NOT NULL AND (fechafactu>='"+inicio+"' AND NOT fechafactufin<'"+inicio+"' OR (fechaanticipo IS NOT NULL AND fechaanticipo BETWEEN '"+inicio+"' AND '"+fin+"')) ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionpyl1(String proceso,String palabra) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='"+proceso+"' ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionpyl1(String proceso) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='"+proceso+"' ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionpyl1inst(String proceso) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='"+proceso+"' AND tipo <> 'Poligrafos' ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionpyl1poli(String proceso) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='"+proceso+"' AND tipo='Poligrafos' ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Instalacion> getlistaInstalacionpyl1a(String palabra) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='Culminada' OR proceso='Aceptada por Cliente' ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionpyl2a(String palabra) throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND proceso='Culminada' ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionpyl2a() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Culminada' ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Instalacion> getlistaInstalacionpyl1a() throws Exception {
        List<Instalacion> lista;
        Query q = session.createQuery("FROM Instalacion WHERE proceso='Culminada' ORDER BY id ASC");
        lista = (List<Instalacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Proyectos> getlistaProyectos() throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Proyectos> getlistaProyectos2(String numero) throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos WHERE numero='"+numero+"'");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Proyectos> getlistaProyectos1(String instalacion) throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos WHERE instalacion='"+instalacion+"'");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Proyectos> getlistaProyectos1a(String instalacion,String grupo) throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos WHERE instalacion='"+instalacion+"' AND grupo='"+grupo+"'");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Diseno> getlistaDiseno(String instalacion) throws Exception {
        List<Diseno> lista;
        Query q = session.createQuery("FROM Diseno WHERE instalacion='"+instalacion+"'");
        lista = (List<Diseno>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Diseno> getlistaDisenoa(String instalacion,String grupo) throws Exception {
        List<Diseno> lista;
        Query q = session.createQuery("FROM Diseno WHERE instalacion='"+instalacion+"' AND grupo='"+grupo+"'");
        lista = (List<Diseno>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Diseno getDiseno(String instalacion) throws Exception {
        List<Diseno> lista;
        Query q = session.createQuery("FROM Diseno WHERE nombre='"+instalacion+"'");
        lista = (List<Diseno>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    public Proyectos getProyectos2(String instalacion) throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos WHERE instalacion='"+instalacion+"'");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    public Proyectos getProyectos(String instalacion) throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos WHERE subproyecto='"+instalacion+"'");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Proyectos getProyectoVt(String instalacion) throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos WHERE instalacion='"+instalacion+"'");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    
    public Report getReport(String instalacion) throws Exception {
        List<Report> lista;
        Query q = session.createQuery("FROM Report WHERE nombre='"+instalacion+"'");
        lista = (List<Report>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Orden getOrden(String instalacion) throws Exception {
        List<Orden> lista;
        Query q = session.createQuery("FROM Orden WHERE nombre='"+instalacion+"'");
        lista = (List<Orden>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Notas getNotas(String instalacion) throws Exception {
        List<Notas> lista;
        Query q = session.createQuery("FROM Notas WHERE nombre='"+instalacion+"'");
        lista = (List<Notas>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
   public Notas getNotasa(String instalacion,String grupo) throws Exception {
        List<Notas> lista;
        Query q = session.createQuery("FROM Notas WHERE nombre='"+instalacion+"' AND grupo='"+grupo+"'");
        lista = (List<Notas>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
   public Factura getFactura2(String articulo) throws Exception {
        List<Factura> lista;
        Query q = session.createQuery("FROM Factura WHERE idnombre='"+articulo+"'");
        lista = (List<Factura>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
   
    public Factu getFactu(String instalacion) throws Exception {
        List<Factu> lista;
        Query q = session.createQuery("FROM Factu WHERE nombre='"+instalacion+"'");
        lista = (List<Factu>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Factu getFactua(String instalacion,String grupo) throws Exception {
        List<Factu> lista;
        Query q = session.createQuery("FROM Factu WHERE nombre='"+instalacion+"' AND grupo='"+grupo+"'");
        lista = (List<Factu>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Report> getlistaReport(String instalacion) throws Exception {
        List<Report> lista;
        Query q = session.createQuery("FROM Report WHERE instalacion='"+instalacion+"'");
        lista = (List<Report>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Report> getlistaReporta(String instalacion,String grupo) throws Exception {
        List<Report> lista;
        Query q = session.createQuery("FROM Report WHERE instalacion='"+instalacion+"' AND grupo='"+grupo+"'");
        lista = (List<Report>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Factu> getlistaFactu(String instalacion) throws Exception {
        List<Factu> lista;
        Query q = session.createQuery("FROM Factu WHERE instalacion='"+instalacion+"'");
        lista = (List<Factu>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Factu> getlistaFactua(String instalacion,String grupo) throws Exception {
        List<Factu> lista;
        Query q = session.createQuery("FROM Factu WHERE instalacion='"+instalacion+"' AND grupo='"+grupo+"'");
        lista = (List<Factu>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Proveedores> getlistaProveedoresteeam(String numero) throws Exception {
        List<Proveedores> lista;
        Query q = session.createQuery("FROM Proveedores WHERE proforma='"+numero+"'");
        lista = (List<Proveedores>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Orden> getlistaOrden(String instalacion) throws Exception {
        List<Orden> lista;
        Query q = session.createQuery("FROM Orden WHERE instalacion='"+instalacion+"'");
        lista = (List<Orden>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Notas> getlistaNotas(String instalacion) throws Exception {
        List<Notas> lista;
        Query q = session.createQuery("FROM Notas WHERE instalacion='"+instalacion+"'");
        lista = (List<Notas>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Orden> getlistaOrdena(String instalacion,String grupo) throws Exception {
        List<Orden> lista;
        Query q = session.createQuery("FROM Orden WHERE instalacion='"+instalacion+"' AND grupo='"+grupo+"'");
        lista = (List<Orden>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Notas> getlistaNotasa(String instalacion,String grupo) throws Exception {
        List<Notas> lista;
        Query q = session.createQuery("FROM Notas WHERE instalacion='"+instalacion+"' AND grupo='"+grupo+"'");
        lista = (List<Notas>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Retencion getRetencion(String instalacion) throws Exception {
        List<Retencion> lista;
        Query q = session.createQuery("FROM Retencion WHERE cte='"+instalacion+"'");
        lista = (List<Retencion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Ctecobrar> getListaCteCobrar(String cad, int instalacion, int proyecto) throws Exception {
        List<Ctecobrar> lista;
        Query q = session.createQuery("FROM Ctecobrar WHERE planpagos LIKE '%"+cad+"%' AND idcliente='"+instalacion+"' AND idproyecto='"+proyecto+"'");
        lista = (List<Ctecobrar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctecobrar> getListCteCobrar(int id) throws Exception {
        List<Ctecobrar> lista;
        Query q = session.createQuery("FROM Ctecobrar WHERE id="+id+"");
        lista = (List<Ctecobrar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctecobrar> getListCteCobrar(int instalacion, int proyecto) throws Exception {
        List<Ctecobrar> lista;
        Query q = session.createQuery("FROM Ctecobrar WHERE idcliente='"+instalacion+"' AND idproyecto='"+proyecto+"' ORDER BY id ASC");
        lista = (List<Ctecobrar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
   
    public List<Calpermisos> getCalpermisos(String id) {
        List<Calpermisos> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Calpermisos WHERE caldepartamentoByIdcaldepa1.nombre='"+id+"'");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Calpermisos>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Fempleado> getFempleado(String text) {
        List<Fempleado> lista;
        Query q=null;
        q = session.createQuery("FROM Fempleado WHERE idfcomisiones='"+text+"'");

        lista = (List<Fempleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Calpermisos> getCalpermisos() {
        List<Calpermisos> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Calpermisos");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Calpermisos>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public Caldepartamento getCaldepartamento(String depa) {
        List<Caldepartamento> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Caldepartamento WHERE nombre='"+depa+"'");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Caldepartamento>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista.get(0);
            }
        
    }
    
    public List<Noticalen> getNoticalennom(String depa) {
        List<Noticalen> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Noticalen WHERE dueno='"+depa+"'");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Noticalen>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Login> getDepartamento(String depa) {
        List<Login> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Login WHERE departamento='"+depa+"'");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Login>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Login> getLoginnombre(String depa) {
        List<Login> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Login WHERE nombre='"+depa+"'");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Login>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Owncloud> getOwncloud(String tipo, Login l) {
        List<Owncloud> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Owncloud WHERE direccion='"+tipo+"' AND (duenio='"+l.getId()+"' OR permisos LIKE '%"+l.getId()+"%') ");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Owncloud>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Caldepartamento> getCaldepartamento() {
        List<Caldepartamento> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Caldepartamento");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Caldepartamento>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Calendario> getCalendario(Date fecha, Login l) {
        List<Calendario> lista;
        Query q=null;
        java.sql.Date d1 = new java.sql.Date(fecha.getTime());
        try{
            q = session.createQuery("FROM Calendario WHERE fechaini='"+d1.toString()+"' AND ( vinculos LIKE '%"+l.getNombre()+"%' OR visible LIKE '%"+l.getDepartamento()+"%' OR idlogin="+l.getId()+" )");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Calendario>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Calendario> getCalendario(Date fecha) {
        List<Calendario> lista;
        Query q=null;
        java.sql.Date d1 = new java.sql.Date(fecha.getTime());
        try{
            q = session.createQuery("FROM Calendario WHERE fechaini='"+d1.toString()+"'" );
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Calendario>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Calendario> getCalendario(Date fecha, String hora) {
        List<Calendario> lista;
        Query q=null;
        java.sql.Date d1 = new java.sql.Date(fecha.getTime());
        try{
            q = session.createQuery("FROM Calendario WHERE fechaini='"+d1.toString()+"' AND hora='"+hora+"'" );
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Calendario>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Calendario> getCalendario(Date fecha, Date fechamax, String nombre, String depa) {
        List<Calendario> lista;
        Query q=null;
        java.sql.Date d1 = new java.sql.Date(fecha.getTime());
        java.sql.Date d2 = new java.sql.Date(fechamax.getTime());
        try{
            q = session.createQuery("FROM Calendario WHERE fechaini>='"+d1.toString()+"' AND fechaini<='"+d2.toString()+"' AND (visible LIKE '%"+depa+"%' OR vinculos LIKE '%"+nombre+"%')" );
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Calendario>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Calendario> getCalendario(Date fecha, Date fechamax, String nombre, String depa, int id) {
        List<Calendario> lista;
        Query q=null;
        java.sql.Date d1 = new java.sql.Date(fecha.getTime());
        java.sql.Date d2 = new java.sql.Date(fechamax.getTime());
        try{
            q = session.createQuery("FROM Calendario WHERE fechaini>='"+d1.toString()+"' AND fechaini<='"+d2.toString()+"' AND (visible LIKE '%"+depa+"%' OR vinculos LIKE '%"+nombre+"%' OR idlogin="+id+")" );
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Calendario>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Calendario> getCalendario(Date fecha, Date fechamax) {
        List<Calendario> lista;
        Query q=null;
        java.sql.Date d1 = new java.sql.Date(fecha.getTime());
        java.sql.Date d2 = new java.sql.Date(fechamax.getTime());
        try{
            q = session.createQuery("FROM Calendario WHERE fechaini>='"+d1.toString()+"' AND fechaini<='"+d2.toString()+"'" );
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Calendario>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public List<Fechactecobrar> getCtefecha(String idinstalacion) throws Exception {
        List<Fechactecobrar> lista;
        Query q=null;
        q = session.createQuery("FROM Fechactecobrar WHERE idinstalacion='"+idinstalacion+"' ORDER BY fecha ASC"); 
        lista = (List<Fechactecobrar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Contactos> getContactos(String cont) {
        List<Contactos> lista;
        Query q=null;
        try{
            q = session.createQuery("FROM Contactos WHERE cliente='"+cont+"'");
        }catch(Exception io){
            System.out.println(io);
        }    
            lista = (List<Contactos>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        
    }
    
    public Ctecobrar getCteCobrar(int instalacion, int proyecto) throws Exception {
        List<Ctecobrar> lista;
        Query q = session.createQuery("FROM Ctecobrar WHERE idcliente='"+instalacion+"' AND idproyecto='"+proyecto+"'");
        lista = (List<Ctecobrar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Ctepagar getCtePagar(String instalacion) throws Exception {
        List<Ctepagar> lista;
        Query q = session.createQuery("FROM Ctepagar WHERE pdf='"+instalacion+"'");
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Ctepagar> getlistaCtePagarvarioscomi(String cliente, String instalacion, String ci) throws Exception {
        List<Ctepagar> lista;
        Query q = session.createQuery("FROM Ctepagar WHERE idcliente='"+cliente+"' AND idinstalacion='"+instalacion+"' AND upper(detalle) LIKE upper('%"+ci+"%')");
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctepagar> getlistaCtePagarvarios2() throws Exception {
        List<Ctepagar> lista;
        Query q = session.createQuery("FROM Ctepagar");
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctepagar> getlistaCtePagarvarios(String cliente, String instalacion) throws Exception {
        List<Ctepagar> lista;
        Query q = session.createQuery("FROM Ctepagar WHERE idcliente='"+cliente+"' AND idinstalacion='"+instalacion+"'");
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctepagar> getlistaCtePagar3(String nombre) throws Exception {
        List<Ctepagar> lista;
        Query q = session.createQuery("FROM Ctepagar");
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctepagar> getlistaCtePagarvarios(String nombre, int tipo) throws Exception {
        List<Ctepagar> lista;
        Query q=null;
        if(tipo==0){
            q = session.createQuery("FROM Ctepagar WHERE upper(detalle) LIKE upper('%"+nombre+"%')");
        }
        if(tipo==1){
            q = session.createQuery("FROM Ctepagar WHERE upper(fecha) LIKE upper('%"+nombre+"%')");
        }
        if(tipo==2){
            q = session.createQuery("FROM Ctepagar WHERE upper(cliente) LIKE upper('%"+nombre+"%')");
        }
        if(tipo==3){
            q = session.createQuery("FROM Ctepagar WHERE upper(instalacion) LIKE upper('%"+nombre+"%')");
        }
        
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctepagar> getlistaCtePagar2(String instalacion, String nombre) throws Exception {
        List<Ctepagar> lista;
        Query q = session.createQuery("FROM Ctepagar WHERE idproforma='"+instalacion+"' AND extra='"+nombre+"'");
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctepagar> getlistaCtePagar(String instalacion) throws Exception {
        List<Ctepagar> lista;
        Query q = session.createQuery("FROM Ctepagar WHERE idproforma='"+instalacion+"'");
        lista = (List<Ctepagar>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Fempleado> getlistaFempleado(String text) throws Exception {
        List<Fempleado> lista;
        Query q = session.createQuery("FROM Fempleado WHERE idfcomisiones='"+text+"'");
        lista = (List<Fempleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Fcomisiones> getlistaComisiones(String texto) throws Exception {
        List<Fcomisiones> lista;
        Query q = null;
        if(texto.equalsIgnoreCase("Culminados")){
            q = session.createQuery("FROM Fcomisiones WHERE pendiente IS NOT NULL");
        }else{
            q = session.createQuery("FROM Fcomisiones WHERE pendiente IS NULL");
        }
        lista = (List<Fcomisiones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Fcomisiones> getlistaComisiones() throws Exception {
        List<Fcomisiones> lista;
        Query q = session.createQuery("FROM Fcomisiones");
        lista = (List<Fcomisiones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Proyectos getlistaProyectosFinan(String instalacion) throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos WHERE instalacion='"+instalacion+"'");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Proyectos getlistaProyectos2(String instalacion,String subproyecto) throws Exception {
        List<Proyectos> lista;
        Query q = session.createQuery("FROM Proyectos WHERE subproyecto='"+subproyecto+"' and instalacion='"+instalacion+"'");
        lista = (List<Proyectos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Productos> getlistaProductos2() throws Exception {
        List<Productos> lista;
        Query q = session.createQuery("FROM Productos");
        lista = (List<Productos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Productos> getlistaProductos (String proyecto) throws Exception {
        List<Productos> lista;
        Query q = session.createQuery("FROM Productos WHERE proyecto='"+proyecto+"'");
        lista = (List<Productos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Inventario> getlistaInventario() throws Exception {
        List<Inventario> lista;
        Query q = session.createQuery("FROM Inventario");
        lista = (List<Inventario>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ticket> getTicketsencurso(String palabra) throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND estado='En Curso' ORDER BY numero ASC");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ticket> getTicketsencurso() throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE estado='En Curso' ORDER BY numero ASC");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Ticket> getTicketsencursoinst() throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE estado='En Curso' AND diseno<>'Poligrafos' ORDER BY numero ASC");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Ticket> getTicketsencursopoli() throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE estado='En Curso' AND diseno='Poligrafos' ORDER BY numero ASC");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    } 
    public List<Ticket> getTicketsculminado(String palabra) throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE upper(detalle) LIKE upper('%"+palabra+"%') AND estado='Culminada' ORDER BY numero ASC");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ticket> getTicketsculminado() throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE estado='Culminada' ORDER BY numero ASC");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Ticket> getTicketsculminadoinst() throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE estado='Culminada' AND diseno <> 'Poligrafos' ORDER BY numero ASC");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
     public List<Ticket> getTicketsculminadopoli() throws Exception {
        List<Ticket> lista;
        Query q = session.createQuery("FROM Ticket WHERE estado='Culminada' AND diseno='Poligrafos' ORDER BY numero ASC");
        lista = (List<Ticket>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Inventario2> getlistaInventario2() throws Exception {
        List<Inventario2> lista;
        Query q = session.createQuery("FROM Inventario2");
        lista = (List<Inventario2>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Inventario3> getlistaInventario3() throws Exception {
        List<Inventario3> lista;
        Query q = session.createQuery("FROM Inventario3");
        lista = (List<Inventario3>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Login getLogin(String ci) throws Exception {
        List<Login> lista;
        Query q = session.createQuery("FROM Login WHERE ci='"+ci+"'");
        lista = (List<Login>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Login> getLogin() throws Exception {
        List<Login> lista;
        Query q = session.createQuery("FROM Login");
        lista = (List<Login>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Indexpresupuesto> getIndexpresupuesto() throws Exception {
        List<Indexpresupuesto> lista;
        Query q = session.createQuery("FROM Indexpresupuesto");
        lista = (List<Indexpresupuesto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Indexcontable> getIndexcontable() throws Exception {
        List<Indexcontable> lista;
        Query q = session.createQuery("FROM Indexcontable");
        lista = (List<Indexcontable>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Presupuesto> getPresupuesto() throws Exception {
        List<Presupuesto> lista;
        Query q = session.createQuery("FROM Presupuesto");
        lista = (List<Presupuesto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public Presupuesto getPresupuestoindi(String nombre) throws Exception {
        List<Presupuesto> lista;
        Query q = session.createQuery("FROM Presupuesto WHERE presupuesto='"+nombre+"'");
        lista = (List<Presupuesto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Indexpresupuesto> getIndexpresupuesto(String nombre) throws Exception {
        List<Indexpresupuesto> lista;
        Query q = session.createQuery("FROM Indexpresupuesto WHERE upper(presupuesto) LIKE upper('%"+nombre+"%')");
        lista = (List<Indexpresupuesto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    public List<Permisos> getPermisos() throws Exception {
        List<Permisos> lista;
        Query q = session.createQuery("FROM Permisos");
        lista = (List<Permisos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Inventario getInventario(String tipo) throws Exception {
        List<Inventario> lista;
        Query q = session.createQuery("FROM Inventario WHERE tipo='"+tipo+"'");
        lista = (List<Inventario>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Articulos> getListaArticulos2(String tipo) throws Exception {
        List<Articulos> lista;
        Query q = session.createQuery("FROM Articulos WHERE idpresupueston='"+tipo+"'");
        lista = (List<Articulos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Articulos> getListaArticulosfin(String insta) throws Exception {
        List<Articulos> lista;
        Query q = session.createQuery("FROM Articulos WHERE idinstalacion='"+insta+"'");
        lista = (List<Articulos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Articulos> getListaArticulosfin(String cliente, String insta) throws Exception {
        List<Articulos> lista;
        Query q = session.createQuery("FROM Articulos WHERE idcliente='"+cliente+"' AND idinstalacion='"+insta+"'");
        lista = (List<Articulos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Articulos> getListaArticulos(String tipo) throws Exception {
        List<Articulos> lista;
        Query q = session.createQuery("FROM Articulos WHERE idfactura='"+tipo+"'");
        lista = (List<Articulos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Indexitem> getListaIndexitem() throws Exception {
        List<Indexitem> lista;
        Query q = session.createQuery("FROM Indexitem ORDER BY tipo ASC");
        lista = (List<Indexitem>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Factura getFacturafecha(String tipo) throws Exception {
        List<Factura> lista;
        Query q = session.createQuery("FROM Factura WHERE idnombre='"+tipo+"'");
        lista = (List<Factura>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Factura> getFactura(int tipo) throws Exception {
        List<Factura> lista;
        Query q = session.createQuery("FROM Factura WHERE idproveedor='"+tipo+"' ORDER BY idnombre ASC");
        lista = (List<Factura>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Factura> getbusquedaFactura(Date f1, Date f2) {
        List<Factura> lista=null;
        Query q=null;
        try{
            q = session.createQuery("FROM Factura WHERE (fecha between '"+Funcion.DateFormatSql(f1)+"' AND '"+Funcion.DateFormatSql(f2)+"') OR  (fecha2 between '"+Funcion.DateFormatSql(f1)+"' AND '"+Funcion.DateFormatSql(f2)+"') ORDER BY fecha ASC");
            lista = (List<Factura>) q.list();
        }catch(Exception io){
        
        }
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Ctecobrar> getbusquedaCtecobrar(Date f1, Date f2) {
        List<Ctecobrar> lista=null;
        Query q=null;
        try{
            q = session.createQuery("FROM Ctecobrar WHERE (fecha between '"+Funcion.DateFormatSql(f1)+"' AND '"+Funcion.DateFormatSql(f2)+"') AND NOT factura = '' ORDER BY fecha ASC");
            lista = (List<Ctecobrar>) q.list();
        }catch(Exception io){
        
        }
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Retencionfactu getretencionfactu(String tipo) throws Exception {
        List<Retencionfactu> lista;
        Query q = session.createQuery("FROM Retencionfactu WHERE idnombre='"+tipo+"'");
        lista = (List<Retencionfactu>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Fcomisiones getFcomisiones(String cliente, String insta) throws Exception {
        List<Fcomisiones> lista;
        Query q = session.createQuery("FROM Fcomisiones WHERE idcliente="+cliente+" AND idinstalacion="+insta);
        lista = (List<Fcomisiones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Clientes getClientes(String tipo) throws Exception {
        List<Clientes> lista;
        Query q = session.createQuery("FROM Clientes WHERE ruc='"+tipo+"'");
        lista = (List<Clientes>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Inventario2 getInventario2(String tipo) throws Exception {
        List<Inventario2> lista;
        Query q = session.createQuery("FROM Inventario2 WHERE tipo='"+tipo+"'");
        lista = (List<Inventario2>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Inventario3 getInventario3(String tipo) throws Exception {
        List<Inventario3> lista;
        Query q = session.createQuery("FROM Inventario3 WHERE tipo='"+tipo+"'");
        lista = (List<Inventario3>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
}
