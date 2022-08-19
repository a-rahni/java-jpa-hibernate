
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
@Table(name="produits")
public class Produit {
    
    @Id
    @Column(name="id_produit")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long idProduit;
    
    @Column(name="active", columnDefinition="TINYINT(1) DEFAULT 1")
    private Boolean active;
    
    @Column(name="description", columnDefinition="TEXT")
    private String description;
    
    @Column(name="nom", length=100)
    private String nom;
    
    @Column(name="prix")
    private Float prix;
    
    @Column(name="reference", length=100)
    private String reference;
    
    @Column(name="stock")
    private Integer stock;

    public Produit(Boolean active, String description, String nom, Float prix, String reference, Integer stock) {
        this.active = active;
        this.description = description;
        this.nom = nom;
        this.prix = prix;
        this.reference = reference;
        this.stock = stock;
    }

    public Produit() {
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "ProduitDao{"
                + "idProduit= " + idProduit
                + ", active= " + active
                + ", description= " + description 
                + ", nom= " + nom
                + ", prix= " + prix 
                + ", reference= " + reference 
                + ", stock= " + stock
                + '}';
    }
 

    public void copy(Produit produitData) {

        if (produitData == null) {
            return;
        }

        if (produitData.getActive() != null) {
            this.active = produitData.getActive();
        }

        if (produitData.getDescription() != null) {
            this.description = produitData.getDescription();
        }

        if (produitData.getNom() != null) {
            this.nom = produitData.getNom();
        }

        if (produitData.getPrix() != null) {
            this.prix = produitData.getPrix();
        }

        if (produitData.getReference() != null) {
            this.reference = produitData.getReference();
        }
        
        if (produitData.getStock() != null) {
            this.stock = produitData.getStock();
        }
    }
    
}
