/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bitacora.servicio;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import Bitacora.tablas.Acreditacion;
import Bitacora.tablas.EmpresaVehiculo;
import Bitacora.tablas.Horarios;
import Bitacora.tablas.Monitor;
import Bitacora.tablas.Registros;
import Bitacora.tablas.Usuario;
import Bitacora.tablas.Vehiculo;

/**
 *
 * @author Angelmath
 */
public class ServiceHb {

    private Session session = null;
    private org.hibernate.Transaction tx;
    private String local = "";
    
    public ServiceHb() {
      try{  
        this.session= HibernateUtil.getSessionFactory().getCurrentSession();
      }catch(Exception io){
          System.out.println(io);
      }
    }
    /*
     * ServicesHb General
     */
    public boolean iniciarTransaccion() throws Exception {
        try{
            if (session.getTransaction() != null
                    && session.getTransaction().isActive()) {
                tx = session.getTransaction();
            } else {
                tx = session.beginTransaction();
            }
            this.session.clear();
        }catch (Exception ex) {
            tx.rollback();
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

    public void confirmarTransaccion() throws Exception {
        try{
        if (tx != null) {
            if (tx.isActive()) {
                tx.commit();
            }
        }
        }catch(Exception io){
            tx.rollback();
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
         try{  
        tx = null;
        if (session.isOpen()) {
            session.flush();
            session.close();
        }
      }catch(Exception io){
          tx.rollback();
      }
        return true;
    }
    
    public List<Registros> getRegistrosBusqueda(String placa, String ci, String nombre,String apellido) throws Exception {
        List<Registros> lista;
        Query q=null;
        if(placa.equalsIgnoreCase("")){
            q = session.createQuery("FROM Registros WHERE upper(usuario.ci) LIKE upper('%"+ci+"%') AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%')  ORDER BY fecha_ingreso ASC");
        }else{
            q = session.createQuery("FROM Registros WHERE upper(usuario.vehiculo.placa) LIKE upper('%"+placa+"%') AND upper(usuario.ci) LIKE upper('%"+ci+"%') AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%') ORDER BY fecha_ingreso ASC");
        }
        
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()){
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistrosBusqueda2(String placa, String ci, String nombre,String apellido, Date inicio, Date fin, String lugar) throws Exception {
        List<Registros> lista;
        Query q=null;
        if(placa.equalsIgnoreCase("")){
            q = session.createQuery("FROM Registros WHERE upper(usuario.ci) LIKE upper('%"+ci+"%') AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(localidad) LIKE upper('%"+lugar+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%') AND ((fecha_ingreso >= '"+Funcion.DateTimeFormatJS2(inicio)+"' AND fecha_ingreso <= '"+Funcion.DateTimeFormatJS2(fin)+"') OR (fecha_salida >= '"+Funcion.DateTimeFormatJS2(inicio)+"' AND fecha_salida <= '"+Funcion.DateTimeFormatJS2(fin)+"')) ORDER BY fecha_salida ASC");
        }else{
            q = session.createQuery("FROM Registros WHERE upper(usuario.vehiculo.placa) LIKE upper('%"+placa+"%') AND upper(usuario.ci) LIKE upper('%"+ci+"%') AND upper(usuario.nombre) LIKE upper('%"+nombre+"%') AND upper(usuario.apellido) LIKE upper('%"+apellido+"%') ORDER BY fecha_salida ASC");
        }
        
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()){
            return null;
        } else {
            return lista;
        }
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
    
    public List<Monitor> getMonitoresRed() throws Exception {
        List<Monitor> lista;
        Query q = session.createQuery("FROM Monitor ORDER BY monitor ASC");
        lista = (List<Monitor>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
//    
//    public List<Entidadcaja.Monitor> getMonitoresinterno() throws Exception {
//        List<Entidadcaja.Monitor> lista;
//        Query q = session.createQuery("FROM Monitor ORDER BY monitor ASC");
//        lista = (List<Entidadcaja.Monitor>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
//    
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
    
    public List<Horarios> getHorarios() throws Exception {
        List<Horarios> lista;
        Query q = session.createQuery("FROM Horarios");
        lista = (List<Horarios>) q.list();
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
//    
//    public List<Entidadcaja.Monitor> getMonitoresverificarci(String nombre) throws Exception {
//        List<Entidadcaja.Monitor> lista;
//        Query q = session.createQuery("FROM Monitor WHERE monitor='"+nombre+"'");
//        lista = (List<Entidadcaja.Monitor>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
//    
    public List<Monitor> getMonitores() throws Exception {
        List<Monitor> lista;
        Query q = session.createQuery("FROM Monitor");
        lista = (List<Monitor>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<EmpresaVehiculo> getEmpresaVehiculo() throws Exception {
        List<EmpresaVehiculo> lista;
        Query q = session.createQuery("FROM EmpresaVehiculo");
        lista = (List<EmpresaVehiculo>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros() throws Exception {
        List<Registros> lista;
        Query q = session.createQuery("FROM Registros ORDER BY fecha_ingreso ASC, fecha_salida ASC");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if(!local.equalsIgnoreCase("")){
        for(int i =lista.size()-1; i>=0; i--)
            if(!lista.get(i).getLocalidad().equalsIgnoreCase(local)){
                lista.remove(i);
            }
        }
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros3(String local, String f1, String f2, String placa, String ci,String nombre,String apellido) throws Exception {
        List<Registros> lista;
        Query q =null;
        int cont=0;
        String where="";
        String fecha1 = "(fecha_ingreso BETWEEN '"+f2+"' AND '"+f1+"')";
        String fecha2 = "(fecha_salida BETWEEN '"+f2+"' AND '"+f1+"')";
        
        if(!local.equalsIgnoreCase("")||!placa.equalsIgnoreCase("")||!ci.equalsIgnoreCase("")||!nombre.equalsIgnoreCase("")||!apellido.equalsIgnoreCase("")||!f1.equalsIgnoreCase("")||!f2.equalsIgnoreCase("")){
            where="WHERE";
            
        }else{
            
        }
        
        if(local.equalsIgnoreCase("")){
            
        }else{
            local= "localidad ='"+local+"' ";
            cont=1;
        }
        
        if(placa.equalsIgnoreCase("")){
            placa= "observacion LIKE 'cajamarca%' ";
            cont=1;
        }else{
            if(!local.equalsIgnoreCase("")){
            placa= "AND usuario.vehiculo.placa LIKE '"+placa+"%' ";}
            else{
            placa= "usuario.vehiculo.placa LIKE '"+placa+"%' ";}
            cont=1;
        }
        
        if(ci.equalsIgnoreCase("")){
            
        }else{
            if(!local.equalsIgnoreCase("")||!placa.equalsIgnoreCase("")){
            ci= "AND usuario.ci LIKE '"+ci+"%' ";}
            else{
            ci= "usuario.ci LIKE '"+ci+"%' ";
            }
            cont=1;
        }
        
        if(nombre.equalsIgnoreCase("")){
            
        }else{
            if(!local.equalsIgnoreCase("")||!placa.equalsIgnoreCase("")||!ci.equalsIgnoreCase("")){
            nombre= "AND usuario.nombre LIKE '"+nombre+"%' ";}
            else{
            nombre= "usuario.nombre LIKE '"+nombre+"%' ";
            }
            cont=1;
        }
        
        
        if(apellido.equalsIgnoreCase("")){
            
        }else{
            if(!local.equalsIgnoreCase("")||!placa.equalsIgnoreCase("")||!ci.equalsIgnoreCase("")||!nombre.equalsIgnoreCase("")){
            apellido= "AND usuario.apellido LIKE '"+apellido+"%' ";
            }else{
            apellido= "usuario.apellido LIKE '"+apellido+"%' ";
            }
            cont=1;
        }
        
        if(cont==1){
        fecha1= " AND "+fecha1;
        }
        
        if(f1.equalsIgnoreCase("")||f2.equalsIgnoreCase("")){
            q = session.createQuery("FROM Registros "+where+" "+local+" "+placa+" "+ci+" "+nombre+" "+apellido+" ORDER BY fecha_ingreso ASC, fecha_salida ASC");
        }else{
            q = session.createQuery("FROM Registros "+where+" "+local+" "+placa+"  "+ci+" "+nombre+" "+apellido+"   "+fecha1+" AND "+fecha2+" ORDER BY fecha_ingreso ASC, fecha_salida ASC");
        }
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Registros> getRegistros2(String local, String f1, String f2, String placa, String ci,String nombre,String apellido) throws Exception {
        List<Registros> lista;
        Query q =null;
        int cont=0;
        String where="";
        String fecha1 = "(fecha_ingreso BETWEEN '"+f2+"' AND '"+f1+"')";
        String fecha2 = "(fecha_salida BETWEEN '"+f2+"' AND '"+f1+"')";
        
        if(!local.equalsIgnoreCase("")||!placa.equalsIgnoreCase("")||!ci.equalsIgnoreCase("")||!nombre.equalsIgnoreCase("")||!apellido.equalsIgnoreCase("")||!f1.equalsIgnoreCase("")||!f2.equalsIgnoreCase("")){
            where="WHERE";
            
        }else{
            
        }
        
        if(local.equalsIgnoreCase("")){
            
        }else{
            local= "localidad ='"+local+"' ";
            cont=1;
        }
        
        if(placa.equalsIgnoreCase("")){
            
        }else{
            if(!local.equalsIgnoreCase("")){
            placa= "AND usuario.vehiculo.placa LIKE '"+placa+"%' ";}
            else{
            placa= "usuario.vehiculo.placa LIKE '"+placa+"%' ";}
            cont=1;
        }
        
        if(ci.equalsIgnoreCase("")){
            
        }else{
            if(!local.equalsIgnoreCase("")||!placa.equalsIgnoreCase("")){
            ci= "AND usuario.ci LIKE '"+ci+"%' ";}
            else{
            ci= "usuario.ci LIKE '"+ci+"%' ";
            }
            cont=1;
        }
        
        if(nombre.equalsIgnoreCase("")){
            
        }else{
            if(!local.equalsIgnoreCase("")||!placa.equalsIgnoreCase("")||!ci.equalsIgnoreCase("")){
            nombre= "AND usuario.nombre LIKE '"+nombre+"%' ";}
            else{
            nombre= "usuario.nombre LIKE '"+nombre+"%' ";
            }
            cont=1;
        }
        
        
        if(apellido.equalsIgnoreCase("")){
            
        }else{
            if(!local.equalsIgnoreCase("")||!placa.equalsIgnoreCase("")||!ci.equalsIgnoreCase("")||!nombre.equalsIgnoreCase("")){
            apellido= "AND usuario.apellido LIKE '"+apellido+"%' ";
            }else{
            apellido= "usuario.apellido LIKE '"+apellido+"%' ";
            }
            cont=1;
        }
        
        if(cont==1){
        fecha1= " AND "+fecha1;
        }
        
        if(f1.equalsIgnoreCase("")||f2.equalsIgnoreCase("")){
            q = session.createQuery("FROM Registros "+where+" "+local+" "+placa+" "+ci+" "+nombre+" "+apellido+" ORDER BY fecha_ingreso ASC, fecha_salida ASC");
        }else{
            q = session.createQuery("FROM Registros "+where+" "+local+" "+placa+"  "+ci+" "+nombre+" "+apellido+"   "+fecha1+" AND "+fecha2+" ORDER BY fecha_ingreso ASC, fecha_salida ASC");
        }
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
        calendar.add(Calendar.DATE, -2);
        Query q = session.createQuery("FROM Registros WHERE fecha_ingreso > '"+ calendar.getTime() +"' OR fecha_salida > '"+ calendar.getTime() +"' ORDER BY fecha_ingreso ASC, fecha_salida ASC");
        lista = (List<Registros>) q.list();
        Collections.reverse(lista);
        if(!local.equalsIgnoreCase("")){
        for(int i =lista.size()-1; i>=0; i--)
            if(!lista.get(i).getLocalidad().equalsIgnoreCase(local)){
                lista.remove(i);
            }
        }
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
    
     public List<Usuario> getUsuarios() throws Exception {
        List<Usuario> lista;
        Query q = session.createQuery("FROM Usuario");
        lista = (List<Usuario>) q.list();
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
    
     public List<Acreditacion> getAcreditaciones(int id) throws Exception {
        List<Acreditacion> lista;
        Query q = session.createQuery("FROM Acreditacion");
        lista = (List<Acreditacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
}
