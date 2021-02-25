package com.example.slurm.controllers;

import com.example.slurm.models.Statistics;
import com.example.slurm.repositories.StatisticsRepository;
import com.example.slurm.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StatisticsController {

    @Autowired
    private StatisticsRepository statisticsRepository;

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/time")
    public String getAllStatistics(HttpServletRequest request, Model model) {
        model.addAttribute("statistics", statisticsRepository.findAll());
        return "statistics";
    }

    @GetMapping("/time_stamp")
    public @ResponseBody
    Iterable<Statistics> getAllStatistics_stamp() {
        return statisticsRepository.findAll();
    }
}

