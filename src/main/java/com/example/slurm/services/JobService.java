package com.example.slurm.services;

import com.example.slurm.models.Job;
import com.example.slurm.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List <Job> getJob(){
        return jobRepository.findAll();
    }

    //Get Jobs by keyword
    //public List<Job> findByKeyword(String keyword){
    //   return jobRepository.findByKeyword(keyword);
    //}
}
