package com.spring.sporty.repository;

import com.spring.sporty.model.Produit;
import org.springframework.data.repository.CrudRepository;

public interface ProduitRepository extends CrudRepository<Produit,Long> {
}
