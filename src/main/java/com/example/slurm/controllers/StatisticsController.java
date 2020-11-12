package com.example.slurm.controllers;

import com.example.slurm.repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatisticsController {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private StatisticsRepository statisticsRepository;

    @GetMapping(path = "/statistics")
    public String statistics(){
        return "job";
    }
}

