
package fr.m2i.javajpahibernate.dao;

import fr.m2i.javajpahibernate.helper.SessionHelper;
import fr.m2i.javajpahibernate.model.Produit;
import java.util.List;
import javax.persistence.*;

public class ProduitDAO {

    private final EntityManager entityManager;

    public ProduitDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public List<Produit> findAll() {
        Query findAllQuery = entityManager.createQuery("select p from Produit p");
        return findAllQuery.getResultList();
    }

    public Produit findById(Long id) {
        Produit founded = entityManager.find(Produit.class, id);

        if (founded == null) {
            System.out.println("Attention le produit avec l'id: " + id + " n'existe pas !");
        }

        return founded;
    }

    public List<Produit> findByNom(String nom) {
        
        if (nom == null) {
            System.out.println("Le nom du produit n'est pas valide !");
            return null;
        }

        Query query = entityManager.createQuery("select p from Produit p where p.nom = ?1");
        query.setParameter(1, nom);

        return query.getResultList();
    }

    public List<Produit> findByDescription(String description) {

        if (description == null) {
            System.out.println("Le description du produit n'est pas valide !");
            return null;
        }

        Query query = entityManager.createQuery("select p from Produit p where p.description = :description");
        query.setParameter("description", description);

        return query.getResultList();
    }

    public List<Produit> findByPrix(Float prix) {

        if (prix == null) {
            System.out.println("Le prix du produit n'est pas valide !");
            return null;
        }

        Query query = entityManager.createQuery("select p from Produit p where p.prix = ?1");
        query.setParameter(1, prix);

        return query.getResultList();
    }

    public List<Produit> findByReference(String reference) {

        if (reference == null) {
            System.out.println("Le reference du produit n'est pas valide !");
            return null;
        }

        Query query = entityManager.createQuery("select p from Produit p where p.reference = :reference");
        query.setParameter("reference", reference);

        return query.getResultList();
    }

    public Produit findByMostQuantity() {

        TypedQuery<Produit> query = entityManager
                .createQuery("select p from Produit p where p.stock = (select max(pp.stock) from Produit pp)", Produit.class);

        return query.getSingleResult();
    }

    public void create(Produit productToCreate) {

        if (productToCreate == null) {
            System.out.println("L'objet produit ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(productToCreate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la création");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    public void update(Long id, Produit productData) {

        Produit productToUpdate = findById(id);

        if (productToUpdate == null) {
            System.out.println("Le produit avec l'id:" + id + " n'existe pas");
            return;
        }

        productToUpdate.copy(productData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(productToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la modification");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
    }
    
    public void delete(Produit product) {
        
        if (product == null || product.getIdProduit() == null || product.getIdProduit() < 1L) {
            System.out.println("Le produit n'est pas valide !");
            return;
        }
        
        Produit productToDelete = findById(product.getIdProduit());

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.remove(productToDelete);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur est survenu lors de la suppression");
            System.out.println("Exception message : " + e.getMessage());
            if (tx != null) {
                tx.rollback();
            }
        }
        
    }

}