
package fr.m2i.javajpahibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rahni
 */

@Entity
@Table(name="roles")
public class Role {
    
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_role")  // en sql convetion snake case: minisc_minisc_minusc
    private Long idRole;         // preferer type objet que type primitif / type sql BigInt(20)
    
    @Column(name = "identifiant", length = 50)
    private String identifiant;  //sql type varchar 50
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;  // sql type text : columnDefinition pour ajouter des modif en sql

    public Role(String identifiant, String description) {
        this.identifiant = identifiant;
        this.description = description;
    }

    public Role() {
    }
    

    public Long getIdRole() {
        return idRole;
    }
    
    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }
    

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    @Override
    public String toString(){
        return "Role{" + "idRole=" + idRole + ", identifiant=" + identifiant + ", description=" + description + '}';
    }
    
}

