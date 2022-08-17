
package fr.m2i.javajpahibernate;

import fr.m2i.javajpahibernate.helper.SessionHelper;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rahni
 */
public class JavaJpaHibernate {

    public static void main(String[] args) {
      
        EntityManager entityManager = SessionHelper.getEntityManager();
        
        System.out.println("Nos traitement ...");
        
        entityManager.close(); // a utiliser en fonction de la durée de vie, liberer la memoire et fermer la connexion a la DB
    }
}
