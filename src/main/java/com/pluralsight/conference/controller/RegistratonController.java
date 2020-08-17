package com.pluralsight.conference.controller;

import com.pluralsight.conference.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class RegistratonController {

    @GetMapping("/registration")
    public String getRegistration(@ModelAttribute("registration") Registration model)
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addRegistration(@Valid @ModelAttribute("registration") Registration reg, BindingResult result){

        if(result.hasErrors()) {
            System.out.println("There were errors.");
            return "registration";
        }
        System.out.println("Registation: " + reg.getName());
        return "redirect:registration";
    }

}
