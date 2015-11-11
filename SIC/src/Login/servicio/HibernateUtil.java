/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login.servicio;

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
        try{
        Configuration configuration = new Configuration().configure("hibernateL.cfg.xml");
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        return configuration.buildSessionFactory(builder.build());
        }catch(Exception io){
            System.out.println(io);
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

