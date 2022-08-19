
package fr.m2i.javajpahibernate.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "utilisateurs")
public class Utilisateur {

    @Id
    @Column(name = "id_utilisateur")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUtilisateur;

    @JoinColumn(name = "id_role", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Role role;

    @OneToMany(mappedBy = "utilisateur", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Adresse> adresses;

    @Column(name = "civilite", length = 100)
    private String civilite;

    @Column(name = "nom", length = 100)
    private String nom;

    @Column(name = "prenom", length = 100)
    private String prenom;

    @Column(name = "identifiant", length = 100)
    private String identifiant;

    @Column(name = "mot_passe", length = 100)
    private String motPasse;

    @Column(name = "actif", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean actif;

    @Column(name = "marquer_effacer", columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean marquerEffacer;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateCreation;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_modification", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateModification;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_naissance", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date dateNaissance;

    public Utilisateur() {

    }

    public Utilisateur(Role role, String civilite, String nom, String prenom,
            String identifiant, String motPasse, Boolean actif, Boolean marquerEffacer,
            Date dateCreation, Date dateModification, Date dateNaissance) {
        this.role = role;
        this.civilite = civilite;
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.motPasse = motPasse;
        this.actif = actif;
        this.marquerEffacer = marquerEffacer;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.dateNaissance = dateNaissance;
    }

    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Adresse> getAdresses() {
        return adresses;
    }

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public Boolean getActif() {
        return actif;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Boolean getMarquerEffacer() {
        return marquerEffacer;
    }

    public void setMarquerEffacer(Boolean marquerEffacer) {
        this.marquerEffacer = marquerEffacer;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "idUtilisateur=" + idUtilisateur
                + ", role=" + role
                + ", civilite=" + civilite
                + ", nom=" + nom
                + ", prenom=" + prenom
                + ", identifiant=" + identifiant
                + ", motPasse=" + motPasse
                + ", actif=" + actif
                + ", marquerEffacer=" + marquerEffacer
                + ", dateCreation=" + dateCreation
                + ", dateModification=" + dateModification
                + ", dateNaissance=" + dateNaissance + '}';
    }

    public void addAddress(Adresse address) {
        
        if (adresses == null) {
            adresses = new ArrayList<>();
        }

        adresses.add(address);
        address.setUtilisateur(this);
        
    }

    public void removeAddress(Adresse address) {
         address.setUtilisateur(null);

        if (adresses != null) {
            adresses.remove(address);
        }
        
    }

    public void copy(Utilisateur userData) {

        if (userData == null) {
            return;
        }

        if (userData.getCivilite() != null) {
            this.setCivilite(userData.getCivilite());
        }

        if (userData.getNom() != null) {
            this.setNom(userData.getNom());
        }

        if (userData.getPrenom() != null) {
            this.setPrenom(userData.getPrenom());
        }

        if (userData.getIdentifiant() != null) {
            this.setIdentifiant(userData.getIdentifiant());
        }

        if (userData.getMotPasse() != null) {
            this.setMotPasse(userData.getMotPasse());
        }

        if (userData.getActif() != null) {
            this.setActif(userData.getActif());
        }

        if (userData.getMarquerEffacer() != null) {
            this.setMarquerEffacer(userData.getMarquerEffacer());
        }

        if (userData.getDateCreation() != null) {
            this.setDateCreation(userData.getDateCreation());
        }

        if (userData.getDateModification() != null) {
            this.setDateModification(userData.getDateModification());
        }

        if (userData.getDateNaissance() != null) {
            this.setDateNaissance(userData.getDateNaissance());
        }
    }
}



/*
@Entity
@Table(name="utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name="id_utilisateur")
    private Long idUtilisateur;
    
    @Column(name="actif", columnDefinition = "TINYINT(1)")
    private boolean actif;
    
    @Column(name="civilite", length=100)
    private String civilite;
    
    @Column(name="date_creation")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dateCreation;              // type sql timestamp
    
    @Column(name="date_modification")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dateModification;
    
    @Column(name="date_naissance")
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dateNaissance;
    
    @Column(name="identifiant", length=100)
    private String identifiant;
    
    @Column(name="marquer_effacer",columnDefinition = "TINYINT(1)")
    private boolean marquer_effacer;          // type sql TININT(1).
    
    @Column(name="mot_passe", length=100)
    private String motPasse;
    
    @Column(name="nom",length=100)
    private String nom;
    
    @Column(name="prenom",length=100)
    private String prenom;              //VARCHAR(100)
    
    // un utilisateur ne peut avoir qu'un seul role
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_role")
    private Role role;                  //BIGINT

    public Utilisateur(boolean actif, String civilite, Date dateCreation, Date dateModification, Date dateNaissance, String identifiant, boolean marquer_effacer, String motPasse, String nom, String prenom, Role role) {
        this.actif = actif;
        this.civilite = civilite;
        this.dateCreation = dateCreation;
        this.dateModification = dateModification;
        this.dateNaissance = dateNaissance;
        this.identifiant = identifiant;
        this.marquer_effacer = marquer_effacer;
        this.motPasse = motPasse;
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
    }

    public Utilisateur() {
    }

    
    
    
    public Long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public boolean isActif() {
        return actif;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public boolean isMarquer_effacer() {
        return marquer_effacer;
    }

    public void setMarquer_effacer(boolean marquer_effacer) {
        this.marquer_effacer = marquer_effacer;
    }

    public String getMotPasse() {
        return motPasse;
    }

    public void setMotPasse(String motPasse) {
        this.motPasse = motPasse;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
}
*/