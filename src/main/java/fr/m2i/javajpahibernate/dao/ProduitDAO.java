
package fr.m2i.javajpahibernate.dao;

import fr.m2i.javajpahibernate.helper.SessionHelper;
import fr.m2i.javajpahibernate.model.Produit;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author rahni
 */
public class ProduitDAO {
    
    EntityManager entityManager = SessionHelper.getEntityManager();
    
    public List<Produit> findAll(){
        Query query = entityManager.createQuery("SELECT p FROM Produit p");
        return query.getResultList();
    }
    
    public Produit findById(Long id){
        Produit founded = entityManager.find(Produit.class, id);
        
        if(founded == null){
             System.out.println("Attention le adresse avec l'id: " + id + " n'existe pas !");
        }
        
        return founded;
    }
    
    public void create(Produit produitToCreate){
    
        if (produitToCreate == null) {
            System.out.println("L'objet adresse ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(produitToCreate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                // Une erreur est survenue, on discard les actions entamés dans la transaction
                tx.rollback();
            }
        }
    }
    
    public void update(Long id, Produit produitData) {

        Produit produitToUpdate = entityManager.find(Produit.class, id);

        if (produitToUpdate == null) {
            System.out.println("Le produit avec l'id:" + id + " n'existe pas");
            return;
        }

        //produitToUpdate.copy(produitData); to do

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(produitToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
    // public void delete .. to do
    public void delete(Produit produit) {
        if((produit == null) || (produit.getIdProduit() ==null))
        {
            return;
        }

        
        Produit produitTodelete = entityManager.find(Produit.class, produit.getIdProduit());

        if (produitTodelete == null) {
            System.out.println("Le produit avec l'id:" + produit.getIdProduit() + " n'existe pas");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.remove(produitTodelete);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la suppression");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
    
    
    
   public List<Produit> findByNom(String name){
       Query query=entityManager.createQuery("SELECT p FROM Produit p where p.nom like :nom"); 
       query.setParameter("nom", name);          
       return query.getResultList();
   }
   
    public List<Produit> finByDescription(String desciption){
       Query query=entityManager.createQuery("SELECT p FROM Produit p where p.description like :desc"); 
       query.setParameter("desc", desciption);          
       return query.getResultList();
   }
    
     public List<Produit> findByPrix(Float prix){
       Query query=entityManager.createQuery("SELECT p FROM Produit p where p.prix like :price"); 
       query.setParameter("price", prix);          
       return query.getResultList();
   }
     
     public List<Produit> findByMostQuantity(){
         
        
       Query query=entityManager.createQuery("SELECT p FROM Produit p where p.stock = ( SELECT MAX(p1.stock) FROM Produit p1)");
       return query.getResultList();
      
   }
    
}
