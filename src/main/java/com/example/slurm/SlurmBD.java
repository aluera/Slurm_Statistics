package com.example.slurm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SlurmBD {
    @GetMapping("/slurmbd")
    public String slurmbd(){
        return "statistics";
    }

}
