package com.example.slurm.repositories;

import com.example.slurm.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer>, JpaSpecificationExecutor<Job> {


    @Query(value="SELECT * FROM ssucluster_job_table s WHERE  s.id_job LIKE ", nativeQuery = true)
    List<Job> findByKeyword(@Param("keyword") String keyword);

}
