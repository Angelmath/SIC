/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rrhh.servicio;


import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import rrhh.Entidad.Permisos;
import rrhh.Entidad.Anticipos;
import rrhh.Entidad.Bono;
import rrhh.Entidad.CvAdicional;
import rrhh.Entidad.CvEstudio;
import rrhh.Entidad.CvIdioma;
import rrhh.Entidad.CvLaboral;
import rrhh.Entidad.CvReferencia;
import rrhh.Entidad.Departamento;
import rrhh.Entidad.DeptEmpl;
import rrhh.Entidad.Empleado;
import rrhh.Entidad.Horas;
import rrhh.Entidad.Medica;
import rrhh.Entidad.MedicaProfesional;
import rrhh.Entidad.Multa;
import rrhh.Entidad.Prestamos;
import rrhh.Entidad.Roles;
import rrhh.Entidad.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import rrhh.Entidad.Comisiones;
import rrhh.Entidad.Correos;
import rrhh.Entidad.Evaluacion;
import rrhh.Entidad.Otros;
import rrhh.Entidad.Pruebasf;
/**
 *
 * @author Ivan
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
    
    public ServiceHb(String n1, String n2) {
      try{  
            this.session= HibernateUtil.getSessionFactory().getCurrentSession();
      }catch(Exception io){
          this.session = HibernateUtil1.getSessionFactory().getCurrentSession();
      }
    }
    /*
     * ServicesHb General
     */
    public boolean iniciarTransaccion() {
        try{
            if (session.getTransaction() != null
                    && session.getTransaction().isActive()) {
                tx = session.getTransaction();
            } else {
                tx = session.beginTransaction();
            }
            this.session.clear();
        }catch (Exception ex) {
            System.out.println(ex);
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
    public Object obtenerObjeto(Class o, int serie) throws Exception {
        
        return session.get(o, serie);
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
    
    public List<Empleado> getPersonasBycedeno() throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Empleado getPersonasCid2(String ci) throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado WHERE ci='"+ci+"'");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Empleado getPersonasCid(String ci) throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado WHERE cid='"+ci+"'");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<Empleado> getPersonasByTipo() throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado WHERE estado='Activo'"
                + " ORDER BY apellido1 ASC");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Empleado> getPersonasByTipo(Date time) throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado WHERE estado='Activo' AND fechaIngreso < '"+Funcion.DateFormatSql(time) + "' ORDER BY apellido1 ASC");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Long getPersonasdepartamentonum(String cadena) {
        Long count=null;
        try{
        Query q = session.createQuery("SELECT count(*) FROM Empleado WHERE deptEmpl.departamento.nombre='"+cadena+"' AND estado='Activo'");
        count = (Long)q.uniqueResult();
        }catch(Exception io){
            System.out.println(io);
        }
        return count;
    }
    public List<Empleado> getPersonasdepartamento(String cadena) throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado WHERE deptEmpl.departamento.nombre='"+cadena+"' AND estado='Activo'"
                + " ORDER BY apellido1 ASC");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Empleado> getPersonasByTipoespecialbusqueda(String cadena, String nombre) throws Exception {
        List<Empleado> lista;
        Query q =null;
        if(nombre.equalsIgnoreCase("")){
            q = session.createQuery("FROM Empleado WHERE deptEmpl.departamento.nombre='"+cadena+"' AND estado='Activo'"
                + " ORDER BY ciudad, apellido1 ASC" );
        }else{
            q = session.createQuery("FROM Empleado WHERE deptEmpl.departamento.nombre='"+cadena+"' AND estado='Activo' AND (upper(nombre1) LIKE upper('%"+nombre+"%') OR upper(apellido1) LIKE upper('%"+nombre+"%')) "
                + " ORDER BY ciudad, apellido1 ASC" );
        }
        
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Empleado> getPersonasByTipoespecial(String nombre) throws Exception {
        List<Empleado> lista;
        Query q =null;
        if(nombre.equalsIgnoreCase("")){
            q = session.createQuery("FROM Empleado WHERE estado='Activo' "
                + " ORDER BY ciudad, apellido1 ASC" );
        }else{
            q = session.createQuery("FROM Empleado WHERE estado='Activo' AND (upper(nombre1) LIKE upper('%"+nombre+"%') OR upper(apellido1) LIKE upper('%"+nombre+"%'))"
                + " ORDER BY ciudad, apellido1 ASC" );
        }
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Empleado> getPersonasByTipo4() throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado ORDER BY apellido1 ASC");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
//    public Monitor getMonitor(int id) throws Exception {
//        Monitor per;
//        per = (Monitor) session.get(Monitor.class, id);
//        return per;
//    }
//    
//    public List<Monitor> getMonitores() throws Exception {
//        List<Monitor> lista;
//        Query q = session.createQuery("FROM Monitor");
//        lista = (List<Monitor>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
    
//    public Registros getultimoReg(String last) throws Exception {
//        List<Registros> lista;
//        Query q = session.createQuery("FROM Registros WHERE id_usuario="+last+" ORDER BY fechaIngreso ASC");
//        lista = (List<Registros>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista.get(0);
//        }
//    }
    
//    public Monitor getMoni(String last) throws Exception {
//        List<Monitor> lista;
//        Query q = session.createQuery("FROM Monitor WHERE ci='"+last+"'");
//        lista = (List<Monitor>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista.get(0);
//        }
//    }
    
//    public Usuario getUsuario(String last) throws Exception {
//        List<Usuario> lista = null;
//        if(last.charAt(0)=='1'){
//            Query q = session.createQuery("FROM Usuario WHERE ci='"+last+"'");
//            lista = (List<Usuario>) q.list();
//        }else{
//            Query q = session.createQuery("FROM Usuario WHERE ci='0"+last+"'");
//            lista = (List<Usuario>) q.list();
//        }
//        
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista.get(lista.size()-1);
//        }
//    }
    
    public List<Empleado> getPersonasByTipo2() throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado WHERE estado='Activo'"
                + " ORDER BY apellido1 ASC");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Empleado> getPersonasByTipotext2(String depa, String text) throws Exception {
        List<Empleado> lista;
        Query q =null;
        if(depa.equalsIgnoreCase("Inactivo")){
            q = session.createQuery("FROM Empleado WHERE estado='Inactivo' AND (upper(nombre1) LIKE upper('%"+text+"%') OR upper(nombre2) LIKE upper('%"+text+"%') OR upper(apellido1) LIKE upper('%"+text+"%') OR upper(apellido2) LIKE upper('%"+text+"%'))" 
                + " ORDER BY apellido1 ASC");
        }else{
            q = session.createQuery("FROM Empleado WHERE estado='Activo' AND (upper(nombre1) LIKE upper('%"+text+"%') OR upper(nombre2) LIKE upper('%"+text+"%') OR upper(apellido1) LIKE upper('%"+text+"%') OR upper(apellido2) LIKE upper('%"+text+"%')) AND deptEmpl.departamento.nombre='"+depa+"' "
                + " ORDER BY apellido1 ASC");
        }
     
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Empleado> getPersonasByTipotext2(String depa) throws Exception {
        List<Empleado> lista;
        Query q =null;
        if(depa.equalsIgnoreCase("Todos")){
            q = session.createQuery("FROM Empleado WHERE estado='Activo'"
                + " ORDER BY fecha_ingreso ASC");
        }else if(depa.equalsIgnoreCase("Inactivo")){
            q = session.createQuery("FROM Empleado WHERE estado='Inactivo'"
                + " ORDER BY fecha_ingreso ASC");
        }else{
            q = session.createQuery("FROM Empleado WHERE estado='Activo' AND deptEmpl.departamento.nombre='"+depa+"' "
                + " ORDER BY fecha_ingreso ASC");
        }
     
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Empleado> getPersonasByTipotext(String depa) throws Exception {
        List<Empleado> lista;
        Query q =null;
        if(depa.equalsIgnoreCase("Todos")){
            q = session.createQuery("FROM Empleado WHERE estado='Activo'"
                + " ORDER BY fecha_ingreso ASC");
        }else if(depa.equalsIgnoreCase("Inactivo")){
            q = session.createQuery("FROM Empleado WHERE estado='Inactivo'"
                + " ORDER BY fecha_ingreso ASC");
        }else{
            q = session.createQuery("FROM Empleado WHERE estado='Activo' AND deptEmpl.departamento.nombre='"+depa+"' "
                + " ORDER BY fecha_ingreso ASC");
        }
     
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Empleado> getPersonasByTipotext(String palabra,String depa) throws Exception {
        List<Empleado> lista;
        Query q=null;
        if(depa.equalsIgnoreCase("Todos")){
            q = session.createQuery("FROM Empleado WHERE (upper(apellido1) LIKE upper('%"+palabra+"%') OR upper(apellido2) LIKE upper('%"+palabra+"%') OR upper(nombre1) LIKE upper('%"+palabra+"%') OR upper(nombre2) LIKE upper('%"+palabra+"%')) AND estado='Activo'"
                + " ORDER BY apellido1 ASC");
        }else if(depa.equalsIgnoreCase("Inactivo")){
            q = session.createQuery("FROM Empleado WHERE (upper(apellido1) LIKE upper('%"+palabra+"%') OR upper(apellido2) LIKE upper('%"+palabra+"%') OR upper(nombre1) LIKE upper('%"+palabra+"%') OR upper(nombre2) LIKE upper('%"+palabra+"%')) AND estado='Inactivo'"
                + " ORDER BY apellido1 ASC");
        }else{
            q = session.createQuery("FROM Empleado WHERE (upper(apellido1) LIKE upper('%"+palabra+"%') OR upper(apellido2) LIKE upper('%"+palabra+"%') OR upper(nombre1) LIKE upper('%"+palabra+"%') OR upper(nombre2) LIKE upper('%"+palabra+"%')) AND estado='Activo' AND deptEmpl.departamento.nombre='"+depa+"' "
                + " ORDER BY apellido1 ASC");
        }
        
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Empleado> getPersonasByTipo3() throws Exception {
        List<Empleado> lista;
        Query q = session.createQuery("FROM Empleado WHERE estado='Inactivo'"
                + " ORDER BY apellido1 ASC");
        lista = (List<Empleado>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Departamento> getDepartByTipo(String jefe) throws Exception {
        List<Departamento> lista;
        Query q = session.createQuery("FROM Departamento WHERE empleado='"+jefe+"'");
        lista = (List<Departamento>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    //    /*
//     * Usuarios
//     */
    public Empleado getUsuariosById(int id) throws Exception {
        Empleado per;
        per = (Empleado) session.get(Empleado.class, id);
        return per;
    }
    
    public DeptEmpl getDeptEmplById(int id) throws Exception {
        DeptEmpl per;
        per = (DeptEmpl) session.get(DeptEmpl.class, id);
        return per;
    }
    /*
     *  departamentos
     */
    public List<Departamento> getdepartamentosByTipo2(){
        try{
            List<Departamento> lista;
            Query q = session.createQuery("FROM Departamento");
            lista = (List<Departamento>) q.list();
            Collections.reverse(lista);
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        }catch(Exception io){
            System.out.println(io);
        }
        return null;
    }
    
    public List<Departamento> getdepartamentosByTipo(){
        try{
            List<Departamento> lista;
            Query q = session.createQuery("FROM Departamento");
            lista = (List<Departamento>) q.list();
            if (lista.isEmpty()) {
                return null;
            } else {
                return lista;
            }
        }catch(Exception io){
            System.out.println(io);
        }
        return null;
    }
    
    public List<DeptEmpl> getdepartamentosByJefe(String id) throws Exception {
        List<DeptEmpl> lista;
        Query q = session.createQuery("FROM DeptEmpl WHERE id='"+id+"'");
        lista = (List<DeptEmpl>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Permisos> getPermisosByTipo(String ci) throws Exception {
        List<Permisos> lista;
        Query q = session.createQuery("FROM Permisos WHERE ci='"+(ci)+"' ORDER BY id DESC");
        lista = (List<Permisos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Permisos> getPermisosByTipoindi(String ci, String mes, String anio) throws Exception {
        List<Permisos> lista;
        Query q = session.createQuery("FROM Permisos WHERE ci='"+(ci)+"' AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id DESC");
        lista = (List<Permisos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Permisos> getPermisosByTipoindiall(String mes, String anio) throws Exception {
        List<Permisos> lista;
        Query q = session.createQuery("FROM Permisos WHERE mes='"+mes+"' AND anio='"+anio+"' ORDER BY id DESC");
        lista = (List<Permisos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Horas> getHorasByTipo(String ci) throws Exception {
        List<Horas> lista;
        Query q = session.createQuery("FROM Horas WHERE ci='"+(ci)+"' ORDER BY id DESC");
        lista = (List<Horas>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Bono> getBonoByTipo(String ci) throws Exception {
        List<Bono> lista;
        Query q = session.createQuery("FROM Bono WHERE ci='"+(ci)+"' ORDER BY id DESC");
        lista = (List<Bono>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    public List<Otros> getOtrosByTipo(String ci) throws Exception {
        List<Otros> lista;
        Query q = session.createQuery("FROM Otros WHERE ci='"+(ci)+"' ORDER BY id DESC");
        lista = (List<Otros>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Comisiones> getComisionesByTipo2(String relacion) throws Exception {
        List<Comisiones> lista;
        Query q = session.createQuery("FROM Comisiones WHERE relacion='"+relacion+"' ORDER BY id DESC");
        lista = (List<Comisiones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Comisiones> getComisionesByTipo(String ci) throws Exception {
        List<Comisiones> lista;
        Query q = session.createQuery("FROM Comisiones WHERE ci='"+(ci)+"' ORDER BY id DESC");
        lista = (List<Comisiones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Bono> getBonoByTipoAprobado(String ci) throws Exception {
        List<Bono> lista;
        Query q = session.createQuery("FROM Bono WHERE ci='"+(ci)+"'  AND accion='A' ORDER BY id ASC");
        lista = (List<Bono>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Anticipos> getAnticiposByTipo(String ci) throws Exception {
        List<Anticipos> lista;
        Query q = session.createQuery("FROM Anticipos WHERE ci='"+(ci)+"' ORDER BY id ASC");
        lista = (List<Anticipos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Pruebasf> getPruebasfByTipo(String ci) throws Exception {
        List<Pruebasf> lista;
        Query q = session.createQuery("FROM Pruebasf WHERE ci='"+(ci)+"' ORDER BY id ASC");
        lista = (List<Pruebasf>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    public List<Evaluacion> getEvaluacionByTipo2(String ci) throws Exception {
        List<Evaluacion> lista;
        Query q = session.createQuery("FROM Evaluacion WHERE ci='"+(ci)+"' ORDER BY id DESC");
        lista = (List<Evaluacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Evaluacion> getEvaluacionByTipo(String ci) throws Exception {
        List<Evaluacion> lista;
        Query q = session.createQuery("FROM Evaluacion WHERE ci='"+(ci)+"' ORDER BY id ASC");
        lista = (List<Evaluacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Evaluacion> getEvaluacionByTipoO(String tiempo) throws Exception {
        List<Evaluacion> lista;
        Query q = session.createQuery("FROM Evaluacion WHERE fecha>'"+tiempo+"' ORDER BY id ASC");
        lista = (List<Evaluacion>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Roles> getRolesgenerales(String mes, String anio) throws Exception {
        List<Roles> lista;
        Query q = session.createQuery("FROM Roles WHERE mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Roles>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Roles> getRolesByTipo() throws Exception {
        List<Roles> lista;
        Query q = session.createQuery("FROM Roles");
        lista = (List<Roles>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Roles> getRolesByTipo(String ci) throws Exception {
        List<Roles> lista;
        Query q = session.createQuery("FROM Roles WHERE ci='"+ci+"' ORDER BY id ASC");
        lista = (List<Roles>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Anticipos> getAnticiposmesByTipo(String ci, String mes, String anio) throws Exception {
        List<Anticipos> lista;
        Query q = session.createQuery("FROM Anticipos WHERE ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Anticipos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Anticipos> getAnticiposmesByTipo2(String mes, String anio) throws Exception {
        List<Anticipos> lista;
        Query q = session.createQuery("FROM Anticipos WHERE mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Anticipos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Bono> getBonomesByTipo(String ci, String mes, String anio) throws Exception {
        List<Bono> lista;
        Query q = session.createQuery("FROM Bono WHERE ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Bono>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Comisiones> getComisionesmesByTipo(String mes, String anio) throws Exception {
        List<Comisiones> lista;
        Query q = session.createQuery("FROM Comisiones WHERE mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Comisiones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Comisiones> getComisionesmesByTipo(String ci, String mes, String anio) throws Exception {
        List<Comisiones> lista;
        Query q = session.createQuery("FROM Comisiones WHERE ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Comisiones>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Bono> getBonomesByTipo3(String ci, String mes, String anio) throws Exception {
        List<Bono> lista;
        Query q = session.createQuery("FROM Bono WHERE motivo='Liq. Decimotercero Dic-Jul 2015' AND ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Bono>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Prestamos> getPrestamosmesByTipo3(String ci, String mes, String anio) throws Exception {
        List<Prestamos> lista;
        Query q = session.createQuery("FROM Prestamos WHERE motivo='Anticipo por Vacaciones' AND ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Prestamos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Otros> getOtrosmesByTipo(String ci, String mes, String anio) throws Exception {
        List<Otros> lista;
        Query q = session.createQuery("FROM Otros WHERE ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Otros>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Bono> getBonomesByTipo2(String mes, String anio) throws Exception {
        List<Bono> lista;
        Query q = session.createQuery("FROM Bono WHERE mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Bono>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Roles> getRolesmesByTipo(String ci, String mes, String anio) throws Exception {
        List<Roles> lista;
        Query q = session.createQuery("FROM Roles WHERE ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Roles>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Horas> getHorasmesByTipo(String ci, String mes, String anio) throws Exception {
        List<Horas> lista;
        Query q = session.createQuery("FROM Horas WHERE ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Horas>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    
    public List<Horas> getHorasmesByTipo2(String mes, String anio) throws Exception {
        List<Horas> lista;
        Query q = session.createQuery("FROM Horas WHERE mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Horas>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Prestamos> getPrestamosmesByTipo(String ci, String mes, String anio) throws Exception {
        List<Prestamos> lista;
        Query q = session.createQuery("FROM Prestamos WHERE ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Prestamos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Prestamos> getPrestamosmesByTipo2(String mes, String anio) throws Exception {
        List<Prestamos> lista;
        Query q = session.createQuery("FROM Prestamos WHERE mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Prestamos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Multa> getMultamesByTipo(String ci, String mes, String anio) throws Exception {
        List<Multa> lista;
        Query q = session.createQuery("FROM Multa WHERE ci='"+(ci)+"'AND mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Multa>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Multa> getMultamesByTipo2(String mes, String anio) throws Exception {
        List<Multa> lista;
        Query q = session.createQuery("FROM Multa WHERE mes='"+mes+"' AND anio='"+anio+"' ORDER BY id ASC");
        lista = (List<Multa>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Multa> getMultamesByTipo3(String mes, String anio) throws Exception {
        List<Multa> lista;
        Query q = session.createQuery("FROM Multa WHERE mes='"+mes+"' AND anio='"+anio+"' AND accion='A' ORDER BY id ASC");
        lista = (List<Multa>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Prestamos> getPrestamosByTipo(String ci) throws Exception {
        List<Prestamos> lista;
        Query q = session.createQuery("FROM Prestamos WHERE ci='"+(ci)+"' ORDER BY id DESC");
        lista = (List<Prestamos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Prestamos> getPrestamosByTipoAprobado(String ci) throws Exception {
        List<Prestamos> lista;
        Query q = session.createQuery("FROM Prestamos WHERE ci='"+(ci)+"'  AND accion='A' ORDER BY id ASC");
        lista = (List<Prestamos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
        
    public List<Multa> getMultaByTipo(String ci) throws Exception {
        List<Multa> lista;
        Query q = session.createQuery("FROM Multa WHERE ci='"+(ci)+"' ORDER BY id DESC");
        lista = (List<Multa>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Multa> getMultaByTipoAprobadas(String ci) throws Exception {
        List<Multa> lista;
        Query q = session.createQuery("FROM Multa WHERE ci='"+(ci)+"' AND accion='A' ORDER BY id ASC");
        lista = (List<Multa>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Medica getMedicaByTipo(String id) throws Exception {
        List<Medica> lista;
        Query q = session.createQuery("FROM Medica WHERE ci="+id);
        lista = (List<Medica>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public List<MedicaProfesional> getMedicaProfesionalByTipo(String id) throws Exception {
        List<MedicaProfesional> lista;
        Query q = session.createQuery("FROM MedicaProfesional WHERE ci="+id);
        lista = (List<MedicaProfesional>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<Users> getLogin(String user, String pass) throws Exception {
        List<Users> lista;
        Query q = session.createQuery("FROM Users WHERE usuario='"+user+"' AND password='"+pass+"'");
        lista = (List<Users>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public Departamento getDepartamento(String user) throws Exception {
        List<Departamento> lista;
        Query q = session.createQuery("FROM Departamento WHERE nombre='"+user+"'");
        lista = (List<Departamento>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    }
    
    public Departamento getDepartamentoById(int id) throws Exception {
        Departamento per;
        per = (Departamento) session.get(Departamento.class, id);
        return per;
    }
    
    public Roles getRolesById(int id) throws Exception {
        Roles per;
        per = (Roles) session.get(Roles.class, id);
        return per;
    }
    
    //    /*
//     * CvAdicional
//     */
    public CvAdicional getCVadicionalById(int id) throws Exception {
        CvAdicional per;
        per = (CvAdicional) session.get(CvAdicional.class, id);
        return per;
    }
    
    public MedicaProfesional getMedicaprofeById(int id) throws Exception {
        MedicaProfesional per;
        per = (MedicaProfesional) session.get(MedicaProfesional.class, id);
        return per;
    }
    
    public List<CvAdicional> getCvAdicionalByTipo(String cedula) throws Exception {
        List<CvAdicional> lista;
        Query q = session.createQuery("FROM CvAdicional WHERE cedula='"+cedula+"'");
        lista = (List<CvAdicional>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    //    /*
//     * CvEstudio
//     */
    public  CvEstudio getCvEstudioById(int id) throws Exception {
        CvEstudio per;
        per = (CvEstudio) session.get(CvEstudio.class, id);
        return per;
    }
    
    public  Multa getMultaById(int id) throws Exception {
        Multa per;
        per = (Multa) session.get(Multa.class, id);
        return per;
    }             
            
    public  Prestamos getPrestamosById(int id) throws Exception {
        Prestamos per;
        per = (Prestamos) session.get(Prestamos.class, id);
        return per;
    }            
            
    public  Anticipos getAnticiposById(int id) throws Exception {
        Anticipos per;
        per = (Anticipos) session.get(Anticipos.class, id);
        return per;
    }        
        
    public Correos getCorreos(String mes, String anio) throws Exception {
        List<Correos> lista;
        Query q = session.createQuery("FROM Correos WHERE mes='"+mes+"' AND anio='"+anio+"'");
        lista = (List<Correos>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista.get(0);
        }
    } 
    
    public  Bono getBonoById(int id) throws Exception {
        Bono per;
        per = (Bono) session.get(Bono.class, id);
        return per;
    }
            
    public  Horas getHorasById(int id) throws Exception {
        Horas per;
        per = (Horas) session.get(Horas.class, id);
        return per;
    }
    
    public List<CvEstudio> getCvEstudioAll(String cedula) throws Exception {
        List<CvEstudio> lista;
        Query q = session.createQuery("FROM CvEstudio  WHERE cedula='"+cedula+"'");
        lista = (List<CvEstudio>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    public List<CvEstudio> getCvEstudioByTipo(String cedula) throws Exception {
        List<CvEstudio> lista;
        Query q = session.createQuery("FROM CvEstudio WHERE cedula='"+cedula+"'");
        lista = (List<CvEstudio>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    
    
    //    /*
//     * CvIdioma
//     */
    public CvIdioma getCvIdiomaById(int id) throws Exception {
        CvIdioma per;
        per = (CvIdioma) session.get(CvIdioma.class, id);
        return per;
    }
    
    public List<CvIdioma> getCvIdiomaByTipo(String cedula) throws Exception {
        List<CvIdioma> lista;
        Query q = session.createQuery("FROM CvIdioma WHERE cedula='"+cedula+"'");
        lista = (List<CvIdioma>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    //    /*
//     * CvLaboral
//     */
    public CvLaboral getCvLaboralById(int id) throws Exception {
        CvLaboral per;
        per = (CvLaboral) session.get(CvLaboral.class, id);
        return per;
    }
    
    public List<CvLaboral> getCvLaboralByTipo(String cedula) throws Exception {
        List<CvLaboral> lista;
        Query q = session.createQuery("FROM CvLaboral WHERE cedula='"+cedula+"'");
        lista = (List<CvLaboral>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    //    /*
//     * CvReferencia
//     */
    public CvReferencia getCvReferenciaById(int id) throws Exception {
        CvReferencia per;
        per = (CvReferencia) session.get(CvReferencia.class, id);
        return per;
    }
    
    public List<CvReferencia> getCvReferenciaByTipo(String cedula) throws Exception {
        List<CvReferencia> lista;
        Query q = session.createQuery("FROM CvReferencia WHERE cedula='"+cedula+"'");
        lista = (List<CvReferencia>) q.list();
        if (lista.isEmpty()) {
            return null;
        } else {
            return lista;
        }
    }
    //    /*
//     * Usuarios
//     */
    
    /*
     *  Cuentas
     */
//    public List<LocDatos> getCuentas() throws Exception {
//        List<LocDatos> lista;
//        Query q = session.createQuery("FROM LocDatos"
//                + " WHERE estado='A'"
//                + " ORDER BY perDatos.nombres, perDatos.apellidos");
//        lista = (List<LocDatos>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
//
//    public LocDatos getCuentaById(int id) throws Exception {
//        LocDatos cuenta;
//        cuenta = (LocDatos) session.get(LocDatos.class, id);
//        return cuenta;
//    }
//
//    public LocDatos getCuentaByPersonaId(int idP) throws Exception {
//        List<LocDatos> lista;
//        Query q = session.createQuery("FROM LocDatos"
//                + " WHERE perDatos.id = " + idP
//                + " AND estado='A'");
//        lista = (List<LocDatos>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista.get(0);
//        }
//    }
//
//    public List<LocDatos> getCuentaByPersonaIdAll(int idP) throws Exception {
//        List<LocDatos> lista;
//        Query q = session.createQuery("FROM LocDatos"
//                + " WHERE perDatos.id = " + idP
//                + " AND estado='A'");
//        lista = (List<LocDatos>) q.list();
//        return lista;
//    }
//
//    public List<LocDatos> getCuentasByCriterio(String cri, String dato) throws Exception {
//        List<LocDatos> lista;
//        String sQ = "FROM LocDatos"
//                + " WHERE estado='A'"
//                + " ORDER BY perDatos.nombres, perDatos.apellidos";
//        if (cri.equals("1")) {
//            sQ = "FROM LocDatos"
//                    + " WHERE perDatos.nombres LIKE '%" + dato + "%'"
//                    + " AND estado='A'"
//                    + " ORDER BY perDatos.nombres, perDatos.apellidos";
//        } else if (cri.equals("2")) {
//            sQ = "FROM LocDatos"
//                    + " WHERE perDatos.apellidos LIKE '%" + dato + "%'"
//                    + " AND estado='A'"
//                    + " ORDER BY perDatos.nombres, perDatos.apellidos";
//        } else if (cri.equals("3")) {
//            sQ = "FROM LocDatos"
//                    + " WHERE perDatos.nombres LIKE '%" + dato.split(" ")[0] + "%'"
//                    + " AND estado='A'"
//                    + " AND perDatos.apellidos LIKE '%" + dato.split(" ")[1] + "%'"
//                    + " ORDER BY perDatos.nombres, perDatos.apellidos";
//        } else if (cri.equals("4")) {
//            sQ = "FROM LocDatos"
//                    + " WHERE geoZona.numero = '" + dato + "'"
//                    + " AND estado='A'"
//                    + " ORDER BY perDatos.nombres, perDatos.apellidos";
//        } else if (cri.equals("5")) {
//            sQ = "FROM LocDatos"
//                    + " WHERE direccion LIKE '%" + dato + "%'"
//                    + " AND estado='A'"
//                    + " ORDER BY perDatos.nombres, perDatos.apellidos";
//        }
//        Query q = session.createQuery(sQ);
//        lista = (List<LocDatos>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
//
//    /*
//     * Alertas
//     */
//    public EquDatos getEquDatosById(int idL, int num) throws Exception {
//        EquDatos equ;
//        equ = (EquDatos) session.get(EquDatos.class, new EquDatosId(idL, num));
//        return equ;
//    }
//
//    public List<EquDatos> getEquiposByIdLoc(int idL) throws Exception {
//        List<EquDatos> lista;
//        Query q = session.createQuery("FROM EquDatos"
//                + " WHERE id.idLocalidad=" + idL
//                + " ORDER BY id.numero");
//        lista = (List<EquDatos>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
//
//    public List<EquDatos> getEquiposByIdLocCamaras(int idL) throws Exception {
//        List<EquDatos> lista;
//        Query q = session.createQuery("FROM EquDatos"
//                + " WHERE id.idLocalidad=" + idL
//                + " ORDER BY id.numero");
//        lista = (List<EquDatos>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
//
//    public List<PerDatos> getPersonas() throws Exception {
//        List<PerDatos> lista;
//        Query q = session.createQuery("FROM PerDatos"
//                + " WHERE estado='A'"
//                + " ORDER BY nombres, apellidos");
//        lista = (List<PerDatos>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
//

//    
//    /*
//     * Accesos Usuarios
//     */
//
//    public PerAcceso getUsuarioByUsuarioClave(String _usuario, String _clave) throws Exception {
//        List<PerAcceso> lista;
//        Query q = session.createQuery("FROM PerAcceso as p where p.usuario='" + _usuario + "' and p.clave='" + _clave + "'");
//        lista = (List<PerAcceso>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista.get(0);
//        }
//    }
//
//    public PerAcceso getAccesoByIdPersona(int id) throws Exception {
//        List<PerAcceso> lista;
//        Query q = session.createQuery("FROM PerAcceso as p where p.perDatos.id=" + id);
//        lista = (List<PerAcceso>) q.list();
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista.get(0);
//        }
//    }
//

//
//    /*
//     * Rol
//     */
//
//    public List<PerPerfil> getPerfiles() throws Exception {
//        List<PerPerfil> lista;
//        lista = (List<PerPerfil>) session.createQuery("FROM PerPerfil ORDER BY nombre").list();
//
//        if (lista.isEmpty()) {
//            return null;
//        } else {
//            return lista;
//        }
//    }
//
//    public PerPerfil getPerfilById(int id) throws Exception {
//        PerPerfil aRol = (PerPerfil) session.load(PerPerfil.class, id);
//        return aRol;
//    }

}
