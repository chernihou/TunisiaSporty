package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter


@Entity
@Table(name="produits")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String designation;
    private double prix;
    private int quantite;
    @ManyToOne(optional = false)
   @JoinColumn(name="categorie_id", referencedColumnName = "id")
    private Categorie categorie;
    @ManyToOne(optional = false)
    @JoinColumn(name="marque_id", referencedColumnName = "id")
    private Marque marque;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Produit() {
    }

    public Produit(Long id, String designation, double prix, int quantite) {
        this.id = id;
        this.designation = designation;
        this.prix = prix;
        this.quantite = quantite;
    }
}
