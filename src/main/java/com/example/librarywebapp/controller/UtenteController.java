package com.example.librarywebapp.controller;


import com.example.librarywebapp.model.Utente;
import com.example.librarywebapp.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UtenteController {


    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Utente utente) {
        return "register";
    }

    @PostMapping("/postregistration")
    public String addPerson (@Valid Utente utente, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "register";

        }
        userRepository.save(utente);
        session.setAttribute("loggedUser", utente);
        model.addAttribute("utenti", userRepository.findAll());
        return "redirect:/homepage";
    }

    @GetMapping("/login")
    public String login (Utente utente){
        return "login";
    }

    @PostMapping("/postlogin")
    public String checkPerson (@Valid Utente utente, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasFieldErrors("username") || bindingResult.hasFieldErrors("password")){
            return "login";
        }
        Utente loggato = userRepository.findUtenteByUsernameAndPassword(utente.getUsername(), utente.getPassword());
        if (loggato != null){
            session.setAttribute("loggedUser", loggato);
            return "redirect:/homepage";
        }
        else
            return "login";
    }

    @GetMapping("/homepage")
    public String viewHome () {
        return "homepage";
    }

    @GetMapping("/userList")
    public String viewUserList(Model model) {
        model.addAttribute("utenti", userRepository.findAll());
        System.out.println(userRepository.findAll());
        return "userList";
    }
}
