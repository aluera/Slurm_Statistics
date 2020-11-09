package com.example.slurm.controllers;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
    public class DatasourceConfig {
        @Bean
        public DataSource datasource() {
            return DataSourceBuilder.create()
                    .driverClassName("com.mysql.cj.jdbc.Driver")
                    .url("jdbc:mysql://mpi-m1.sgu.ru:3306/slurm_acct_db")
                    .username("root")
                    .password("test001")
                    .build();
        }
}
