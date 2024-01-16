package com.example.librarywebapp.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table (name = "libri")
public class Libro {

    @NotNull
    String bookName;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @NotNull
    int yearOfPublish;

    @NotNull
    int price;

    @ManyToOne
    @JoinColumn
    Utente utente;

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Libro(String bookName, Integer id, int yearOfPublish, int price) {
        this.bookName = bookName;
        this.id = id;
        this.yearOfPublish = yearOfPublish;
        this.price = price;
    }

    public Libro() {

    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getYearOfPublish() {
        return yearOfPublish;
    }

    public void setYearOfPublish(int yearOfPublish) {
        this.yearOfPublish = yearOfPublish;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
