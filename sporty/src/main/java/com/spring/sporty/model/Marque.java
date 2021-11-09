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
@Table(name="marques")
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_marque;
    private String nom_marque;
    @OneToMany(mappedBy = "marque",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Produit> Produits;

    public String getId_marque() {
        return id_marque;
    }

    public void setId_marque(String id_marque) {
        this.id_marque = id_marque;
    }

    public String getNom_marque() {
        return nom_marque;
    }

    public void setNom_marque(String nom_marque) {
        this.nom_marque = nom_marque;
    }

    public List<Produit> getProduits() {
        return Produits;
    }

    public void setProduits(List<Produit> produits) {
        Produits = produits;
    }

    public Marque() {
    }

    public Marque(String id_marque, String nom_marque) {
        this.id_marque = id_marque;
        this.nom_marque = nom_marque;
    }
}
