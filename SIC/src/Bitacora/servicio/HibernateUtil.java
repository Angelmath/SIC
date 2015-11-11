/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Bitacora.servicio;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Angelmath
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration().configure("hibernateBitacora.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

