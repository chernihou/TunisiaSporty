package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="paniers")
public class Panier {
    private String id_panier;
    private Boolean etat_panier;
@OneToMany(mappedBy = "panier",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
private List<Produit> produits;
}
