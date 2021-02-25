package com.example.slurm.controllers;

import com.example.slurm.models.Job;
import com.example.slurm.repositories.JobRepository;
import com.example.slurm.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private JobService jobService;

    @GetMapping(path = "/jobs")
    public String getAllJobs(HttpServletRequest request, Model model) {
        int page = 0; //default page number is 0 (yes it is weird)
        int size = 100; //default page size is 10
        if (request.getParameter("page") != null && !request.getParameter("page").isEmpty()) {
            page = Integer.parseInt(request.getParameter("page")) - 1;
        }
        if (request.getParameter("size") != null && !request.getParameter("size").isEmpty()) {
            size = Integer.parseInt(request.getParameter("size"));
        }
        model.addAttribute("jobs", jobRepository.findAll(PageRequest.of(page, size)));
        return "jobs";
    }

    @GetMapping("/jobs_data")
    public @ResponseBody
    Iterable<Job> getAllJobsdata() {
        return jobRepository.findAll();
    }

}
