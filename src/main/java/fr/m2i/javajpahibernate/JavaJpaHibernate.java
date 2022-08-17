
package fr.m2i.javajpahibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rahni
 */
public class JavaJpaHibernate {

    public static void main(String[] args) {
      
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("site_commerce_pu");
        EntityManager entityManager = emf.createEntityManager();
        System.out.println("Hello World!");
    }
}
