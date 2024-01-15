package com.example.librarywebapp.controller;


import com.example.librarywebapp.model.LoginUser;
import com.example.librarywebapp.model.Utente;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UtenteController {

    @GetMapping("/registration")
    public String registration(Utente utente) {
        return "register";
    }

    @PostMapping("/postregistration")
    public String addPerson (@Valid Utente utente, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "register";
        return "redirect:/homepage";
    }

    @GetMapping("/login")
    public String login (LoginUser loginUser){
        return "login";
    }

    @PostMapping("/postlogin")
    public String checkPerson (@Valid LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "login";
        }
        return "redirect:/homepage";
    }

    @GetMapping("/homepage")
    public String viewHome () {
        return "homepage";
    }


}
