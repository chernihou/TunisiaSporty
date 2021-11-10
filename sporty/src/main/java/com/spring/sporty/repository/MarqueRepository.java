package com.spring.sporty.repository;

import com.spring.sporty.model.Marque;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MarqueRepository extends CrudRepository<Marque,Long> {
    public List<Marque> findByNommarque(String m);
}
