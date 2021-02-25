package com.example.slurm.services;

import com.example.slurm.models.Statistics;
import com.example.slurm.repositories.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {
    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<Statistics> getStatistics() {
        return statisticsRepository.findAll();
    }
}
