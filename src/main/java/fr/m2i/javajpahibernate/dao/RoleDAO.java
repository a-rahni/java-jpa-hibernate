
package fr.m2i.javajpahibernate.dao;

import fr.m2i.javajpahibernate.helper.SessionHelper;
import fr.m2i.javajpahibernate.model.Role;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author rahni
 */
public class RoleDAO {

    private final EntityManager entityManager;

    public RoleDAO() {
        this.entityManager = SessionHelper.getEntityManager();
    }

    public Role findById(Long id) {
        Role founded = entityManager.find(Role.class, id);

        if (founded == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'exsiste pas !");
        }

        return founded;
    }

    public void create(Role role) {
        // Vérifier le paramètre role
        if (role == null) {
            System.out.println("L'objet role ne peut pas être null");
            return;
        }

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(role);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la création du role");
            if (tx != null) {
                tx.rollback();
            }
        }
    }

    // Différente manière : Lister les paramètres modifiables
    // public void update(Long id, String identifiant, String description)
    // On utilise l'id pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.setIdentifiant(identifiant);
    // ...

    // Différente manière : Avoir l'id + les données à modifier encapsulé dans l'entity
    // public void update(Long id, Role roleData)
    // On utilise l'id pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.copy(roleData); -> set uniquement les données qui ne sont pas null

    // Différente manière : Tout encapsuler dans l'entity
    // public void update(Role roleData)
    // On utilise roleData.getId() pour le recupérer la donnée
    // => set les données :
    // roleToUpdate.copy(roleData); -> set uniquement les données qui ne sont pas null

    public void update(Long id, Role roleData) {

        Role roleToUpdate = entityManager.find(Role.class, id);

        if (roleToUpdate == null) {
            System.out.println("Attention le role avec l'id : " + id + " n'exsiste pas !");
            return;
        }

        roleToUpdate.copy(roleData);

        EntityTransaction tx = null;

        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.merge(roleToUpdate);

            tx.commit();
        } catch (Exception e) {
            System.out.println("Une erreur s'est produite lors de la modification du role");
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
    public List<Role> findAll() {
        Query findAllQuery = entityManager.createQuery("select r from Role r");
        return findAllQuery.getResultList();
    }
    
    //JPQL : query avec paramètres (laison avec le nom de paramètre)
    public List<Role> findByDescription(String description, String identifiant) {
        Query findByDesc = entityManager.createQuery("select r from Role r where r.description like :searched and r.identifiant=:ident  ");
        findByDesc.setParameter("searched", description+"%");
        findByDesc.setParameter("ident",identifiant);
        //findByDesc.setParameter("searched", "admin");
        //findByDesc.setParameter("ident","ADMIN");
        return findByDesc.getResultList();
        //return findByDesc.getSingleResult();
    }
    
    //JPQL : query avec paramètres (laison avec la position de paramètre)
    public List<Role> findByDescriptionV2(String description, String identifiant) {
        Query findByDesc = entityManager.createQuery("select r from Role r where r.description like ?1 and r.identifiant=?2  ");
        findByDesc.setParameter(1, description+"%");
        findByDesc.setParameter(2,identifiant);
        //findByDesc.setParameter("searched", "admin");
        //findByDesc.setParameter("ident","ADMIN");
        return findByDesc.getResultList();
        //return findByDesc.getSingleResult();
    }
    
    
}