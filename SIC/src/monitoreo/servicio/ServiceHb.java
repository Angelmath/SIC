/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package monitoreo.servicio;

import org.hibernate.Session;


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
    
}
