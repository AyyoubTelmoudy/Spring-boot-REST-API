package com.example.demo.repos;

import com.example.demo.entities.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepos extends JpaRepository<Livre, Long> {

    List<Livre> findByOrderByTitreAsc();

}