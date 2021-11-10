package com.spring.sporty.repository;

import com.spring.sporty.model.Categorie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategorieRepository extends CrudRepository<Categorie, Long> {
    public List<Categorie> findByNomcat(String n);
}
