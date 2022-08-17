
package fr.m2i.javajpahibernate.dao;

import fr.m2i.javajpahibernate.model.Role;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author rahni
 */
public class RoleDAO {
    private EntityManager entityManager;

    public RoleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public Role findById(Long id){
        return entityManager.find(Role.class, id);
    }
    
    public void create(Role role){
        EntityTransaction tx = null;
        
        try{
            tx= entityManager.getTransaction();
            tx.begin();
            entityManager.persist(role); 
             tx.commit();
        }catch(Exception e){
            if(tx != null){
                tx.rollback();
            } 
        }
    }
    
    public void update(Long id, Role role){
        EntityTransaction tx = null;
        
        Role roleToUpdate = entityManager.find(Role.class, id);
        if((roleToUpdate != null) && (role !=null)){
            try{
                tx= entityManager.getTransaction();
                tx.begin();

                if (role.getIdentifiant()!=null){
                    roleToUpdate.setIdentifiant(role.getIdentifiant());
                }
                if (role.getDescription()!=null){
                    roleToUpdate.setDescription(role.getDescription());
                }
                entityManager.merge(roleToUpdate);

                tx.commit();
            }catch(Exception e){
                if(tx != null){
                    tx.rollback();
                }

            }
        }
    }
    
}
