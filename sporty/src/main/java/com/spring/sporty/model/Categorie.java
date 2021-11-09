package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
//@NoArgsConstructor

@Entity
@Table(name="categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_cat;
    private String nom_cat;

    @OneToMany(mappedBy = "categorie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Produit> Produits;

    public String getId_cat() {
        return id_cat;
    }

    public void setId_cat(String id_cat) {
        this.id_cat = id_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public List<Produit> getProduits() {
        return Produits;
    }

    public void setProduits(List<Produit> produits) {
        Produits = produits;
    }

    public Categorie() {
    }

    public Categorie(String id_cat, String nom_cat) {
        this.id_cat = id_cat;
        this.nom_cat = nom_cat;
    }
}
