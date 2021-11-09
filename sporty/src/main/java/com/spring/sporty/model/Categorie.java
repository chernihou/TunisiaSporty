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
@Table(name="categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id_cat;
    private String nom_cat;
    @OneToMany(mappedBy = "categorie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Categorie> categories;

}
