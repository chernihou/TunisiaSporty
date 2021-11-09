package com.spring.sporty.model;

import lombok.Data;
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
    private String id;
    private String nom_cat;

    @OneToMany(mappedBy = "categorie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Produit> Produits;




    public Categorie() {
    }

    public Categorie(String id_cat, String nom_cat) {
        this.id = id_cat;
        this.nom_cat = nom_cat;
    }
}
