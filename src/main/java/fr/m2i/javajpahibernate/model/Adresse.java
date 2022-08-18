package fr.m2i.javajpahibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author rahni
 */
@Entity
@Table(name="adresses")
public class Adresse {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idAdresse;
    
    @JoinColumn(name = "id_utilisateur")  // une adresse est attachée à un seul utilisateur
    @ManyToOne(fetch=FetchType.LAZY)
    private Utilisateur utilisateur;
    
    @Column(name="code_postal", length=100)
    private String codePostal;
    
    @Column(name="pays", length=100)
    private String pays;
    
    @Column(name="principle", columnDefinition="TINYINT(1)")
    private Boolean principale;
    
    @Column(name="rue", length=100)
    private String rue;
    
    @Column(name="ville", length=100)
    private String ville;

    public Adresse(Utilisateur utilisateur, String codePostal, String pays, Boolean principale, String rue, String ville) {
        this.utilisateur = utilisateur;
        this.codePostal = codePostal;
        this.pays = pays;
        this.principale = principale;
        this.rue = rue;
        this.ville = ville;
    }

    public Adresse() {
    }

    public Long getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(Long idAdresse) {
        this.idAdresse = idAdresse;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public Boolean getPrincipale() {
        return principale;
    }

    public void setPrincipale(Boolean principale) {
        this.principale = principale;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
    
    @Override
    public String toString(){
        return "Adresse{" + "idAdresse=" + idAdresse
                + ", utilisateur=" + utilisateur
                + ", Code postal=" + codePostal
                + ", pays=" + pays
                + ", principale=" + principale
                + ", rue=" + rue
                + ", ville=" + ville+ '}';
    }
    
     public void copy(Adresse adresseData) {

        if (adresseData == null) {
            return;
        }

        if (adresseData.getCodePostal() != null) {
            this.setCodePostal(adresseData.getCodePostal());
        }
        
        if (adresseData.getPays() != null) {
            this.setPays(adresseData.getPays());
        }
        
        if (adresseData.getPrincipale() != null) {
            this.setPrincipale(adresseData.getPrincipale());
        }
        
        if (adresseData.getRue() != null) {
            this.setRue(adresseData.getRue());
        }
        
        if (adresseData.getVille() != null) {
            this.setVille(adresseData.getVille());
        }
     }

       
    
}
