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
    private String id;
    private String nom_marque;
    @OneToMany(mappedBy = "marque",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Produit> Produits;
    public Marque() {
    }

    public Marque(String id_marque, String nom_marque) {
        this.id = id;
        this.nom_marque = nom_marque;
    }
}
