package com.example.librarywebapp.controller;

import com.example.librarywebapp.model.Libro;
import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class LibroController {

    static ArrayList<Libro> libri = new ArrayList<>();
    @GetMapping("/addBook")
    public String createBook(Libro libro) {
        return "addBook";
    }

    @PostMapping("/postaddBook")
    public String addBook (@Valid Libro libro, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "addBook";
        }
        libri.add(libro);
        model.addAttribute("libri",libri);
        return "redirect:/bookList";
    }

    @GetMapping("/bookList")
    public String viewHome(Model model) {
        model.addAttribute("libri", libri);
        return "bookList";
    }
}
