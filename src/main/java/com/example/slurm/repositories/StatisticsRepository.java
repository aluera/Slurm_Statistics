package com.example.slurm.repositories;

import com.example.slurm.models.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Integer> {
    @Query(value = "SELECT account FROM ssucluster_job_table", nativeQuery = true)
    Integer selectTimeStart();
}
