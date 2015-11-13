/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sgi.servicio;

import sgi.tablas.Asistente;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import sgi.tablas.Acreditacion;
import sgi.tablas.Configuracion;
import sgi.tablas.Foto;
import sgi.tablas.Indexpatrulla;
import sgi.tablas.Login;
import sgi.tablas.Observacion;
import sgi.tablas.RPall;
import sgi.tablas.Registros;
import sgi.tablas.Usuario;
import sgi.tablas.Vehiculo;

/**
 *
 * @author Angelmath
 */
public class ServiceHb {

    private Session session = null;
    private org.hibernate.Transaction tx;
    private String local = "";
    public ServiceHb() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    public ServiceHb(String fileName,String file) {
        this.session = HibernateUtil2.getSessionFactory().getCurrentSession();
    }
    /*
     * ServicesHb General
     */
    public boolean iniciarTransaccion() throws Exception {
        tx = session.beginTransaction();
        this.session.clear();
        return true;
    }
    
    public void abortarTransaccion() throws Exception {
        if (tx != null) {
            if (tx.isActive()) {
                tx.rollback();
            }
        }
    }

    public void confirmarTransaccion() throws Exception {
        try {
        if (tx != null) {
            if (tx.isActive()) {
                tx.commit();
            }
        }
        } catch (Exception ex) {
            tx.rollback();
            throw ex;
        }
    }

    
    public void despejarObjeto(Object o) throws Exception {
        this.session.evict(o);
    }

    public boolean cerrarTransaccion() throws Exception {
        tx = null;
        return true;
    }

    public boolean cerrarSesion() throws Exception {
        tx = null;
        if (session.isOpen()) {
            session.close();
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
    
    public List<Acreditacion> getAcreditaciones() throws Exception {
        List<Acreditacion> lista;
        Query q = session.createQuery("FROM Acreditacion");
        lista = (List<Acreditacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Acreditacion> getAcreditacionesS() throws Exception {
        List<Acreditacion> lista;
        Query q = session.createQuery("FROM Acreditacion");
        lista = (List<Acreditacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
    
    public List<Configuracion> getConfiguracionCampo(String campo) throws Exception {
        List<Configuracion> lista;
        Query q = session.createQuery("FROM Configuracion WHERE campo='"+campo+"'");
        lista = (List<Configuracion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Configuracion> getConfiguracion() throws Exception {
        List<Configuracion> lista;
        Query q = session.createQuery("FROM Configuracion");
        lista = (List<Configuracion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Asistente> getAsistentes() throws Exception {
        List<Asistente> lista;
        Query q = session.createQuery("FROM Asistente");
        lista = (List<Asistente>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Asistente> getAsistentesAll() throws Exception {
        List<Asistente> lista;
        Query q = session.createQuery("FROM Asistente WHERE pendiente IS NULL");
        lista = (List<Asistente>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<RPall> getPatrullas() throws Exception {
        List<RPall> lista;
        Query q = session.createQuery("FROM RPall WHERE tipo='Patrulla' AND punto='"+local+"'");
        lista = (List<RPall>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<RPall> getRelevo() throws Exception {
        List<RPall> lista;
        Query q = session.createQuery("FROM RPall WHERE tipo='Relevo' AND punto='"+local+"'");
        lista = (List<RPall>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Indexpatrulla> getIndexPatrulla() throws Exception {
        List<Indexpatrulla> lista;
        Query q = session.createQuery("FROM Indexpatrulla");
        lista = (List<Indexpatrulla>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Observacion> getListObservacion(Date inicio, Date fin) throws Exception {
        List<Observacion> lista;
        Query q = session.createQuery("FROM Observacion WHERE (fecha >= '"+Funcion.DateTimeFormatJS(inicio)+"') AND (fecha <='"+Funcion.DateTimeFormatJS(fin)+"')");
        lista = (List<Observacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<RPall> getListPatrulla(Date inicio, Date fin,String localidad) throws Exception {
        List<RPall> lista;
        //Query q = session.createQuery("FROM Patrullas WHERE (inicio >= '"+Funcion.DateTimeFormatJS(inicio)+"') AND (inicio <='"+Funcion.DateTimeFormatJS(fin)+"')");
        Query q = session.createQuery("FROM RPall WHERE tipo='Patrulla' AND punto='"+localidad+"'");
        lista = (List<RPall>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<RPall> getListrelevo(Date inicio, Date fin,String localidad) throws Exception {
        List<RPall> lista;
        //Query q = session.createQuery("FROM Patrulla WHERE (inicio >= '"+Funcion.DateTimeFormatJS(inicio)+"') AND (inicio <='"+Funcion.DateTimeFormatJS(fin)+"')");
        Query q = session.createQuery("FROM RPall WHERE tipo='Relevo' AND punto='"+localidad+"'");
        lista = (List<RPall>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistrosex(Date inicio, Date fin) throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE (inicio_tiempo >= '"+Funcion.DateTimeFormatJS(inicio)+"') AND (inicio_tiempo <='"+Funcion.DateTimeFormatJS(fin)+"') ORDER BY id");
        //Query q = session.createQuery("FROM Registros");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Asistente getAsistentes(String cedula) throws Exception {
        List<Asistente> lista;
        Query q = session.createQuery("FROM Asistente WHERE cedula='"+cedula+"'");
        lista = (List<Asistente>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Asistente getAsistentesSERVER(String cedula) throws Exception {
        List<Asistente> lista;
        Query q = session.createQuery("FROM Asistente WHERE cedula='"+cedula+"'");
        lista = (List<Asistente>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Asistente getAsistentes2(String cedula) throws Exception {
        List<Asistente> lista;
        Query q = session.createQuery("FROM Asistente WHERE placa='"+cedula+"'");
        lista = (List<Asistente>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Foto getfotoPlaca(String cedula) throws Exception {
        List<Foto> lista;
        Query q = session.createQuery("FROM Foto WHERE usuario='"+cedula+"' AND nombre='placa' ");
        lista = (List<Foto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    
    public Foto getfotoid(String id) throws Exception {
        List<Foto> lista;
        Query q = session.createQuery("FROM Foto WHERE id="+id+"");
        lista = (List<Foto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    public Foto getfotoCi(String cedula) throws Exception {
        List<Foto> lista;
        Query q = session.createQuery("FROM Foto WHERE usuario LIKE '%"+cedula+"%' AND nombre='rostro'");
        lista = (List<Foto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Foto> getfotoPlacaALL() throws Exception {
        List<Foto> lista;
        Query q = session.createQuery("FROM Foto WHERE nombre='placa' AND pendiente IS NULL");
        lista = (List<Foto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Foto> getfotoALLCi() throws Exception {
        List<Foto> lista;
        Query q = session.createQuery("FROM Foto WHERE nombre='rostro' AND pendiente IS NULL");
        lista = (List<Foto>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Vehiculo> getVehiculos() throws Exception {
        List<Vehiculo> lista;
        Query q = session.createQuery("FROM Vehiculo");
        lista = (List<Vehiculo>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    
    public List<Login> getMonitores() throws Exception {
        List<Login> lista;
        Query q = session.createQuery("FROM Login");
        lista = (List<Login>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Login getMonitores(String user, String pass) throws Exception {
        List<Login> lista;
        Query q = session.createQuery("FROM Login WHERE usuario='"+user+"' AND contrasenia='"+pass+"'");
        lista = (List<Login>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Login getMonitores2(String user) throws Exception {
        Login lista;
        Query q = session.createQuery("FROM Login WHERE usuario='"+user+"'");
        lista = (Login) q.list().get(0);
        if (lista==null) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Registros getRegistrosid(Date inicio, Date fin) throws Exception {
        List<Registros> lista;
        Query q=null;
        if(inicio.before(fin)){
        q = session.createQuery("FROM Registros WHERE inicio_tiempo='"+inicio+"'");
        }else{
        q = session.createQuery("FROM Registros WHERE fin_tiempo='"+fin+"'");
        }
        lista = (List<Registros>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
     
    public Registros getRegistrosid2(Date inicio, Date fin) throws Exception {
        List<Registros> lista;
        Query q=null;
        if(inicio.before(fin)){
        q = session.createQuery("FROM Registros WHERE inicio_tiempo='"+inicio+"'");
        }else{
        q = session.createQuery("FROM Registros WHERE fin_tiempo='"+fin+"'");
        }
        lista = (List<Registros>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<sgi.tablas.Registros> getRegistrosact() throws Exception {
        List<sgi.tablas.Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE (actualizacion IS NULL OR actualizacion = 'P') ORDER BY id ASC");
        lista = (List<sgi.tablas.Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
   public List<sgi.tablas.Revpavitem> getRevpatbyDispositivositem(String id, Date inicio,Date fin) throws Exception {
        List<sgi.tablas.Revpavitem> lista;
        //Query q = session.createQuery("FROM Patrulla WHERE ");
        Query q = session.createQuery("FROM Revpavitem WHERE idr_pall="+id+" AND (fecha >= '"+Funcion.DateTimeFormatJS(inicio)+"') AND (fecha <='"+Funcion.DateTimeFormatJS(fin)+"') ORDER BY id ASC");
        lista = (List<sgi.tablas.Revpavitem>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
   
   public List<sgi.tablas.Revpavitem> getRevpatbyDispositivositem(String id) throws Exception {
        List<sgi.tablas.Revpavitem> lista;
        Query q = session.createQuery("FROM Revpavitem WHERE idr_pall="+id+"");
        lista = (List<sgi.tablas.Revpavitem>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
   
    public boolean getRegistrosexiste(String c1) throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE usuario.ci='"+c1+"' AND fin_tiempo IS NULL");
        lista = (List<Registros>) q.list();
        return lista.isEmpty();
    }
    
    public List<Registros> getRegistros() throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros ORDER BY inicio_tiempo");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistrosBusqueda2(String placa, String ci, String nombre,String apellido, Date inicio, Date fin) throws Exception {
        List<Registros> lista;
        Query q=null;
        if(placa.equalsIgnoreCase("")){
            q = session.createQuery("FROM Registros WHERE upper(usuario.ci) LIKE upper('%"+ci+"%') AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%') AND ((inicio_tiempo >= '"+Funcion.DateTimeFormatJS(inicio)+"' AND inicio_tiempo <= '"+Funcion.DateTimeFormatJS(fin)+"') OR (fin_tiempo >= '"+Funcion.DateTimeFormatJS(inicio)+"' AND fin_tiempo <= '"+Funcion.DateTimeFormatJS(fin)+"')) ORDER BY id ASC");
        }else{
            q = session.createQuery("FROM Registros WHERE upper(usuario.vehiculo.placa) LIKE upper('%"+placa+"%') AND upper(usuario.ci) LIKE upper('%"+ci+"%') AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%') ORDER BY CASE WHEN fin_tiempo IS NULL THEN inicio_tiempo ELSE fin_tiempo END");
        }
        
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()){
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistrosBusqueda(String placa, String ci, String nombre,String apellido) throws Exception {
        List<Registros> lista;
        Query q=null;
        if(placa.equalsIgnoreCase("")){
            q = session.createQuery("FROM Registros WHERE upper(usuario.ci) LIKE upper('%"+ci+"%') AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%')  ORDER BY CASE WHEN fin_tiempo IS NULL THEN inicio_tiempo ELSE fin_tiempo END");
        }else{
            q = session.createQuery("FROM Registros WHERE upper(usuario.vehiculo.placa) LIKE upper('%"+placa+"%') AND upper(usuario.ci) LIKE upper('%"+ci+"%') AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%') ORDER BY CASE WHEN fin_tiempo IS NULL THEN inicio_tiempo ELSE fin_tiempo END");
        }
        
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()){
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros2() throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE tipo='V' AND id_usuario.id_vehiculo IS NULL ORDER BY inicio_tiempo");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Registros> getRegistros3() throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE tipo='P' AND id_usuario.id_vehiculo IS NOT NULL ORDER BY inicio_tiempo");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros4() throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE inicio_tiempo IS NOT NULL AND tipo<>'S' AND fin_tiempo IS NULL  ORDER BY inicio_tiempo");
        lista = (List<Registros>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros5(String placa, String ci,String nombre,String apellido) throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE idusuario=usuario.id AND usuario.ci LIKE '%"+ci+"%' AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%') AND inicio_tiempo IS NOT NULL AND fin_tiempo IS NULL AND tipo='P' ORDER BY inicio_tiempo");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros8() throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE inicio_tiempo IS NOT NULL AND tipo='V' AND fin_tiempo IS NULL  ORDER BY inicio_tiempo");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros7() throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE inicio_tiempo IS NOT NULL AND tipo='V' AND fin_tiempo IS NULL  ORDER BY inicio_tiempo");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros6(String placa, String ci,String nombre,String apellido) throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros WHERE usuario.vehiculo IS NOT NULL AND usuario.vehiculo.placa LIKE '%"+placa+"%' AND usuario.ci LIKE '%"+ci+"%' AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%')  AND inicio_tiempo IS NOT NULL AND fin_tiempo IS NULL AND tipo='V' ORDER BY inicio_tiempo");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    public List<Registros> getRegistroslimite2() throws Exception {
        List<Registros> lista;
        Calendar calendar =Calendar.getInstance(); //obtiene la fecha de hoy 
        calendar.add(Calendar.DATE, -2);
        Query q = session.createQuery("FROM Registros WHERE tipo='V' AND inicio_tiempo > '"+ calendar.getTime()+"' ORDER BY CASE WHEN fin_tiempo IS NULL THEN inicio_tiempo ELSE fin_tiempo END");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    public List<Registros> getRegistroslimite3() throws Exception {
        List<Registros> lista;
        Calendar calendar =Calendar.getInstance(); //obtiene la fecha de hoy 
        calendar.add(Calendar.DATE, -2);
        Query q = session.createQuery("FROM Registros WHERE tipo='P' AND inicio_tiempo > '"+ calendar.getTime() +"'  ORDER BY CASE WHEN fin_tiempo IS NULL THEN inicio_tiempo ELSE fin_tiempo END");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    public List<Registros> getRegistroslimite() throws Exception {
        List<Registros> lista;
        Calendar calendar =Calendar.getInstance(); //obtiene la fecha de hoy 
        calendar.add(Calendar.DATE, -3);
        Query q = session.createQuery("FROM Registros WHERE inicio_tiempo > '"+ calendar.getTime() +"' ORDER BY CASE WHEN fin_tiempo IS NULL THEN inicio_tiempo ELSE fin_tiempo END");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Usuario getUsuario(String nombre, String apellido, String ci) throws Exception {
        List<Usuario> lista;
        Query q = session.createQuery("FROM Usuario WHERE nombre='"+nombre+"'");
        lista = (List<Usuario>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Usuario getUsuariocedula(String ci) throws Exception {
        List<Usuario> lista;
        Query q = session.createQuery("FROM Usuario WHERE ci='"+ci+"' ORDER BY inicio_tiempo");
        lista = (List<Usuario>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Usuario> getListaU() throws Exception {
        List<Usuario> lista;
        Query q = session.createQuery("FROM Usuario");
        lista = (List<Usuario>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Acreditacion getAcreditacionById(int id) throws Exception {
        Acreditacion acrd;
        acrd = (Acreditacion) session.get(Acreditacion.class, id);
        return acrd;
    }
}
