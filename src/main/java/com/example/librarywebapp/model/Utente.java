package com.example.librarywebapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "Utenti")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;


    @NotNull
    @Size(min = 3, max = 20)
    String username;

    @NotNull
    @Size(min = 3, max = 20)
    String name;

    @NotNull
    @Size(min = 3, max = 20)
    String surname;

    @NotNull
    String password;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    List<Libro> libri;
    public Utente( String username, String name, String surname, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public Utente() {

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}
