package com.example.librarywebapp.controller;

import com.example.librarywebapp.model.Libro;
import com.example.librarywebapp.model.Utente;
import com.example.librarywebapp.repository.BookRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class LibroController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/addBook")
    public String createBook(Libro libro) {
        return "addBook";
    }

    @PostMapping("/postaddBook")
    public String addBook (@Valid Libro libro, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "addBook";
        }
        Utente utente = (Utente) session.getAttribute("loggedUser");
        libro.setUtente(utente);
        bookRepository.save(libro);
        model.addAttribute("libri",bookRepository.getMyLibri(utente.getId()));
        return "redirect:/bookList";
    }

    @GetMapping("/bookList")
    public String viewHome(Model model, HttpSession session) {
        Utente utente = (Utente) session.getAttribute("loggedUser");
        model.addAttribute("libri", bookRepository.getMyLibri(utente.getId()));
        return "bookList";
    }
}
