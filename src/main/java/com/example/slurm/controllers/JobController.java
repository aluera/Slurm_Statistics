package com.example.slurm.controllers;

import com.example.slurm.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JobController {

    @Autowired
    private JobRepository jobRepository;


    @GetMapping(path = "/job")
    public String getAllJobs(HttpServletRequest request, Model model) {
        int page = 0; //default page number is 0 (yes it is weird)
        int size = 12; //default page size is 10

        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }

        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        model.addAttribute("job", jobRepository.findAll(PageRequest.of(page, size)));
        return "job";
    }

}
