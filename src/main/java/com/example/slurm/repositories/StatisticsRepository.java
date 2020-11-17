package com.example.slurm.repositories;

import com.example.slurm.models.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {

}
