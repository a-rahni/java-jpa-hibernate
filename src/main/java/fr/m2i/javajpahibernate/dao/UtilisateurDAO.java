
package fr.m2i.javajpahibernate.dao;

import fr.m2i.javajpahibernate.helper.SessionHelper;
import fr.m2i.javajpahibernate.model.Role;
import fr.m2i.javajpahibernate.model.Utilisateur;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author rahni
 */
public class UtilisateurDAO {

    private final EntityManager entityManager;

    public UtilisateurDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public Utilisateur findById(Long id) {
        Utilisateur founded = entityManager.find(Utilisateur.class, id);

        if (founded == null) {
            System.out.println("Attention l'utilisateur avec l'id : " + id + " n'exsiste pas !");
        }

        return founded;
    }

    public void create(Utilisateur user) {

        if (user == null) {
            System.out.println("L'objet user ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            
            entityManager.persist(user);
            
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création de l'utilisateur");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void update(Long id, Utilisateur user) {

        Utilisateur userToUpdate = findById(id);
        
        if (userToUpdate == null) {
            System.out.println("Attention l'utilisteur avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        userToUpdate.copy(user);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(userToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification de l'utilisateur");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }


    
    //delete to DO
 
    /**************************************************************************/
    //exemples pour tester les differentes possibilités
    /**************************************************************************/
    // JPQL
     public List<Utilisateur> findAll() {
        Query findAllQuery = entityManager.createQuery("select u from Utilisateur u");
        return findAllQuery.getResultList();
    }
    
  
    
    
}