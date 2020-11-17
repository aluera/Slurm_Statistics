package com.example.slurm.controllers;

import com.example.slurm.models.Job;
import com.example.slurm.repositories.JobRepository;
import com.example.slurm.services.JobService;
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

    @Autowired
    private JobService jobService;

    @GetMapping(path = "/jobs")
    public String getAllJobs(HttpServletRequest request, Model model, String keyword) {
        int page = 0; //default page number is 0 (yes it is weird)
        int size = 12; //default page size is 10
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }

        if (keyword != null) {
            model.addAttribute("jobs", jobService.findByKeyword(keyword));
        } else {
            model.addAttribute("jobs", jobService.getJob());
        }

        model.addAttribute("jobs", jobRepository.findAll(PageRequest.of(page, size)));
        return "jobs";
    }
}
