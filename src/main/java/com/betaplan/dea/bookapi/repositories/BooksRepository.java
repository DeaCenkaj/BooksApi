



  package com.betaplan.dea.bookapi.repositories;

import java.util.List;

import com.betaplan.dea.bookapi.models.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.betaplan.dea.bookapi.models.Books;

    @Repository
    public interface BooksRepository extends CrudRepository<Books, Long> {
        List<Books> findAll();
        List<Books> findByDescriptionContaining(String search);
    }
