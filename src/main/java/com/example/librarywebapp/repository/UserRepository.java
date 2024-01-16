package com.example.librarywebapp.repository;

import com.example.librarywebapp.model.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<Utente, Integer> {

    @Query("select u from Utente u where username = :username and password = :password")
    Utente findUtenteByUsernameAndPassword(String username, String password);
}
