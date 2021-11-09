package com.spring.sporty.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name="commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String date_cmd;
    private double prix_cmd;
    private int quantite_cmd;
    private String etat_cmd;
    private String nom_client;
    private String prenom_client;
    private String adresse_client;
    private int tel_client;


}
