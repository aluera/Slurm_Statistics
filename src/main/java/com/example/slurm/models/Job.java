package com.example.slurm.models;

import javax.persistence.*;

@Entity
@Table(name = "ssucluster_job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_db_inx")
    private Integer id;

    @Column(name = "mod_time")
    private Integer modTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getModTime() {
        return modTime;
    }

    //public void setModTime(Integer modTime) {
    //    this.modTime = modTime;
    //}


}
