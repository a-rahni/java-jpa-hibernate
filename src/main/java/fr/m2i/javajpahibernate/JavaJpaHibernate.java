
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
        RoleDAO roleDao = new RoleDAO();

        // create
        Role roleAdmin = new Role("ADMIN", "Le rôle Administrateur"); 
        roleDao.create(roleAdmin);

        // find
        Role founded = roleDao.findById(1L);
        System.out.println("Role CREATED : " + founded);

        // update
        Role roleData = new Role();
        roleData.setDescription("Le rôle Administrateur implique de grandes responsabilités");

        roleDao.update(1L, roleData);

        // find
        Role updated = roleDao.findById(1L);
        System.out.println("Role UPDATED : " + updated);

        entityManager.close();
    }
}
