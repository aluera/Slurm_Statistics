package com.example.slurm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class    MainControllers {
    @GetMapping
    public String main() {
        return "main";
    }

}