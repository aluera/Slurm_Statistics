package com.example.slurm.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "ssucluster_job_table")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_db_inx")
    private Integer id;

    @Column(name = "account")
    private String account;

    @Column(name = "cpus_req")
    private Integer cpus_req;

    @Column(name = "exit_code")
    private Integer exitCode;

    @Column(name = "time_start")
    private Long timeStart;

    @Column(name = "time_end")
    private Long timeEnd;

    @Column(name = "timelimit")
    private Integer timeLimit;

    //Секнуды во времени выполнение задачи
    @Transient
    public long time() {
        Date start = new Date(timeStart);
        Date end = new Date(timeEnd);

        long diffInMillies = Math.abs(end.getTime() - start.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.SECONDS);
        return diff;
    }

    @Column(name = "work_dir")
    private String workDir;


    @Column(name = "partition")
    private String partition;

    @Column(name = "nodelist")
    private String nodeList;

    @Column(name = "id_job")
    private Integer id_Job;

    @Column(name = "job_name")
    private String job_Name;

    @Column(name = "id_user")
    private Integer id_User;

    @Column(name = "id_group")
    private Integer id_Group;

    public String getJob_Name() {
        return job_Name;
    }

    public Integer getId_Job() {
        return id_Job;
    }

    public String getAccount() {
        return account;
    }

    public Integer getCpus_req() {
        return cpus_req;
    }

    //Queue Очередь
    public String getPartition() {
        return partition;
    }

    public String getNodeList() {
        return nodeList;
    }

    public Integer getExitCode() {
        return exitCode;
    }

    public String getTimeStart() {
        Date date = new java.util.Date(timeStart * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4"));
        String formattedDate = sdf.format(date);
        return formattedDate;
    }

    public String getTimeEnd() {
        Date date = new java.util.Date(timeEnd * 1000L);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd-MM-yyyy HH:mm:ss z");
        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT+4"));
        String formattedDate = sdf.format(date);
        return formattedDate;

    }

    public Integer getTimeLimit() {
        return timeLimit;
    }

    public Integer getId_User() {
        return id_User;
    }

    public Integer getId_Group() {
        return id_Group;
    }

    public long getTime() {

        return time();
    }

    public String getWorkDir() {

        return workDir;
    }
}
