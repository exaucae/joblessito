package com.exaucet.joblessito.persistence.mssql.repository;

import com.exaucet.joblessito.persistence.mssql.entity.JobSeekerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface IJobSeekerRepository extends JpaRepository<JobSeekerEntity, Long>, JpaSpecificationExecutor<JobSeekerEntity> {
}
