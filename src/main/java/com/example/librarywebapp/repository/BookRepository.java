package com.example.librarywebapp.repository;

import com.example.librarywebapp.model.Libro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Libro, Integer> {
@Query("select l from Libro l where l.utente.id = :id ")
    List<Libro> getMyLibri(Integer id);
}
