package com.example.slurm.repositories;

import com.example.slurm.models.Job;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface JobRepository extends JpaRepository<Job, Integer> {
}
