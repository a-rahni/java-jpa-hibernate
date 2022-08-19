
package fr.m2i.javajpahibernate;

import fr.m2i.javajpahibernate.dao.AdresseDAO;
import fr.m2i.javajpahibernate.dao.RoleDAO;
import fr.m2i.javajpahibernate.dao.UtilisateurDAO;
import fr.m2i.javajpahibernate.helper.SessionHelper;
import fr.m2i.javajpahibernate.model.Adresse;
import fr.m2i.javajpahibernate.model.Role;
import fr.m2i.javajpahibernate.model.Utilisateur;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

        /*********** ROLE **********/
        RoleDAO roleDao = new RoleDAO();
        
        // create
        Role role = new Role("USER", "Le rôle User"); 
        roleDao.create(role);

        // find all
//        List<Role> roles = roleDao.findAll();
//        
//        for (Role r : roles) {
//            System.out.println(r);
//        }

//        // find
//        Role founded = roleDao.findById(1L);
//        System.out.println("Role CREATED : " + founded);
//
//        // update
//        Role roleData = new Role();
//        roleData.setDescription("Le rôle Administrateur implique de grandes responsabilités");
//
//        roleDao.update(1L, roleData);
//
//        // find
//        Role updated = roleDao.findById(1L);
//        System.out.println("Role UPDATED : " + updated);


        /*********** USER **********/
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        UtilisateurDAO userDao = new UtilisateurDAO();

        // create
        role.setIdRole(1L);

        Utilisateur user = new Utilisateur(role, "Madame", "Mme x", "x", "x_x", "password", true, false, new Date(), new Date(), new Date());
        Utilisateur user2 = new Utilisateur(role, "Monsieur", "Mr x", "x", "x_x", "password", true, false, new Date(), new Date(), new Date());

        Adresse address1 = new Adresse("21 avenue gabriel peri", "76600", "Le Havre", "France", false);
        Adresse address2 = new Adresse("1 rue de la paix", "75001", "Paris", "France", true);
        Adresse address3 = new Adresse("10 rue de l'insurection", "75000", "Paris", "France", false);

        user.addAddress(address1);
        user2.addAddress(address2);
        user2.addAddress(address3);
        
        userDao.create(user);
        userDao.create(user2);

        // find all
//        List<Utilisateur> users = userDao.findAll();
//
//        for (Utilisateur u : users) {
//            System.out.println("Find all : " + u);
//        }

        // update
//        Utilisateur userData = new Utilisateur();
//        userData.setActif(false);
//        userData.setMarquerEffacer(true);
//
//        try {
//            userData.setDateModification(formatter.parse("11/01/2022"));
//        } catch (ParseException e) {
//            System.out.println("Problème de parsing : " + e.getMessage());
//        }
//
//        userDao.update(2L, userData);

        // find
        Utilisateur secondUser = userDao.findById(2L);
        System.out.println("User updated : " + secondUser);

        // update user address
        secondUser.removeAddress(secondUser.getAdresses().get(secondUser.getAdresses().size() - 1));
        userDao.update(2L, secondUser);

        /*********** ADDRESS **********/

//        AdresseDAO adresseDao = new AdresseDAO();
//        
//        // create
//        Utilisateur user = new Utilisateur();
//        user.setIdUtilisateur(1L);
//
//        Adresse address1 = new Adresse(user, "1 rue de la paix", "75001", "Paris", "France", true);
//        Adresse address2 = new Adresse(secondUser, "2 rue de la guerre", "75019", "Paris", "France", false);
//        
//        adresseDao.create(address1);
//        adresseDao.create(address2);
//
//        // find all
//        List<Adresse> addresses = adresseDao.findAll();
//        
//        for (Adresse a : addresses) {
//            System.out.println("All addresses : " + a.getFullAdresse());
//        }
//
//        // update
//        Adresse addressData = new Adresse();
//        addressData.setRue("2 rue de la paix");
//        addressData.setPrincipale(true);
//        
//        adresseDao.update(2L, addressData);
//        
//        // find by user
//        List<Adresse> addressesOfSecondUser = adresseDao.findByUtilisateur(secondUser);
//        
//        for (Adresse a : addressesOfSecondUser) {
//            System.out.println("All addresses of 2nd user : " + a.getFullAdresse());
//        }
//
//        // find
//        System.out.println("First address : " + adresseDao.findById(1L).getFullAdresse());
  
 
/*************************************************************/
 /*       // test requets JPQL avec parametres  
        System.out.println("********************* description contenant admin et identification = ADMIN");
        //listRoles= roleDao.findByDescription("admin", "ADMIN");
        listRoles= roleDao.findByDescriptionV2("admin", "ADMIN");
        for(Role r:listRoles){
            System.out.println(r);
        }
*/
        
        entityManager.close();
    }
}
