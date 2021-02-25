package com.example.slurm.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@Table(name = "ssucluster_job_table")
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "time_start")
    private Integer timeStart;
    @Column(name = "time_end")
    private Integer timeEnd;

    //Секнуды во времени выполнение задачи
    @Transient
    public long time() {
        Date start = new Date(timeStart);
        Date end = new Date(timeEnd);

        long diffInMillies = Math.abs(end.getTime() - start.getTime());
        long diff = TimeUnit.SECONDS.convert(diffInMillies, TimeUnit.SECONDS);
        return diff;
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

    public Integer countTime() {
        Integer CountTime;
        CountTime = (timeEnd - timeStart);
        return CountTime;
    }

    public Integer getCount() {
        return (countTime());
    }


}
