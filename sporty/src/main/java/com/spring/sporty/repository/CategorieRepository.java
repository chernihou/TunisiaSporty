package com.spring.sporty.repository;

import com.spring.sporty.model.Categorie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    public List<Categorie> findByNom_cat(String n);
//    @Query(value = "Select m from Categorie m where (m.nom_cat Like :pseudo)")
//    public List<Categorie> searchc(@Param("pseudo") String pseudo);
}
