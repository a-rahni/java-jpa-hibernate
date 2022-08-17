
package fr.m2i.javajpahibernate;

import fr.m2i.javajpahibernate.dao.RoleDAO;
import fr.m2i.javajpahibernate.helper.SessionHelper;
import fr.m2i.javajpahibernate.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author rahni
 */
public class JavaJpaHibernate {

    public static void main(String[] args) {
      
        EntityManager entityManager = SessionHelper.getEntityManager();
        
        System.out.println("Nos traitement ...");
        
        RoleDAO roleDAO = new RoleDAO(entityManager);
        //Role toCreate = new Role("jpa","un role crée via JPA");
        //roleDAO.create(toCreate);
        
        System.out.println(roleDAO.findById(2L).getDescription());
        
        Role toUpdate = new Role(null,"description role avec id 1 Modifie");
        roleDAO.update(1L, toUpdate);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        EntityTransaction tx = null;
        
        // update
//        Role roleToUpdate = entityManager.find(Role.class, 2L);
//        try{
//            tx= entityManager.getTransaction();
//            tx.begin();
//            
//            roleToUpdate.setDescription("nouvelle description");
//            entityManager.persist(roleToUpdate);
//            
//            tx.commit();
//        }catch(Exception e){
//            if(tx != null){
//                tx.rollback();
//            }
//            
//        }
        
//        // create (insert)
//        EntityTransaction tx = null;
//        
//        try{
//            tx= entityManager.getTransaction();
//            tx.begin();
//            
//            Role toCreate = new Role("jpa","un role crée via JPA");
//            entityManager.persist(toCreate);
//            
//             tx.commit();
//        }catch(Exception e){
//            if(tx != null){
//                tx.rollback();
//            }
//            
//        }
        
        
        // find by Id
        //Role firstRole = entityManager.find(Role.class, 2L);
        
        
        entityManager.close(); // a utiliser en fonction de la durée de vie, liberer la memoire et fermer la connexion a la DB
    }
}
