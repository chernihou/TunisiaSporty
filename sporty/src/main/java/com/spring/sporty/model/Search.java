package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class Search {
    private String genre;
    private List<Produit> produits;
    private  List<Categorie> categories;
    private List<Marque>marques;
    private String pseudo;
}
