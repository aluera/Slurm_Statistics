package com.example.slurm.models;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Entity
@Table(name = "ssucluster_job_table")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_db_inx")
    private Integer id;
    @Column(name = "time_start")
    private Integer timeStart;
    @Column(name = "time_end")
    private Integer timeEnd;

    public Integer getTimeEnd() {
        return (timeEnd);
    }

    public Integer getTimeStart() {
        return (timeStart);
    }

    public Integer count() {
        Integer CountTime;
        CountTime = (timeEnd - timeStart);
        return CountTime;
    }
    public Integer getCount(){
        return (count());
    }
}
