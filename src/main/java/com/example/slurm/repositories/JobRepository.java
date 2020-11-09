package com.example.slurm.repositories;

import com.example.slurm.models.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends CrudRepository<Job, Integer> {
}
