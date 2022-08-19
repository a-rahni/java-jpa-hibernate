
package fr.m2i.javajpahibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produits")
public class Produit {

    @Id
    @Column(name = "id_produit")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduit;

    @Column(name = "reference", length = 100)
    private String reference;

    @Column(name = "prix")
    private Float prix;

    @Column(name = "nom", length = 100)
    private String nom;
    
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "active", columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean active;

    public Produit() {

    }

    public Produit(String reference, Float prix, String nom, String description, Integer stock, Boolean active) {
        this.reference = reference;
        this.prix = prix;
        this.nom = nom;
        this.description = description;
        this.stock = stock;
        this.active = active;
    }

    public Long getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(Long idProduit) {
        this.idProduit = idProduit;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", reference='" + reference + '\'' +
                ", prix=" + prix +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", stock=" + stock +
                ", active=" + active +
                '}';
    }
    
    public void copy(Produit productData) {

        if (productData == null) {
            return;
        }

        if (productData.getReference() != null) {
            this.reference = productData.getReference();
        }

        if (productData.getPrix() != null) {
            this.prix = productData.getPrix();
        }

        if (productData.getNom() != null) {
            this.nom = productData.getNom();
        }

        if (productData.getDescription() != null) {
            this.description = productData.getDescription();
        }

        if (productData.getStock() != null) {
            this.stock = productData.getStock();
        }

        if (productData.getActive() != null) {
            this.active = productData.getActive();
        }
    }
}