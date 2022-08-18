
package fr.m2i.javajpahibernate.dao;

import fr.m2i.javajpahibernate.helper.SessionHelper;
import fr.m2i.javajpahibernate.model.Adresse;
import fr.m2i.javajpahibernate.model.Utilisateur;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author rahni
 */
public class AdresseDAO {

    private final EntityManager entityManager;

    public AdresseDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public Adresse findById(Long id) {
        Adresse founded = entityManager.find(Adresse.class, id);

        if (founded == null) {
            System.out.println("Attention l'adresse avec l'id : " + id + " n'exsiste pas !");
        }

        return founded;
    }

    public void create(Adresse adresse) {

        if (adresse == null) {
            System.out.println("L'objet adresse ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();
            
            entityManager.persist(adresse);
            
            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création de l'adresse");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void update(Long id, Adresse adresse) {

        Adresse adresseToUpdate = findById(id);
        
        if (adresseToUpdate == null) {
            System.out.println("Attention l'adresse avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        adresseToUpdate.copy(adresse);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(adresseToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification de l'adresse");
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
     public List<Adresse> findAll() {
        Query findAllQuery = entityManager.createQuery("select a from Adresse a");
        return findAllQuery.getResultList();
    }
     
     public List<Adresse> findByUtilisateur(Utilisateur user) {
        if(user == null){
            return null;
        }
         
        Query findByUser = entityManager.createQuery("select u.utilisateur from Adresse u where u.utilisateur.idUtilisateur =:userId  ");
        findByUser.setParameter("userId", user.getIdUtilisateur());
        return findByUser.getResultList();
        
    }
    
  
    
    
}
