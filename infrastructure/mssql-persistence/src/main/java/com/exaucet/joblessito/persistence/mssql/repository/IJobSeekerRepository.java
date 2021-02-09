package com.exaucet.joblessito.persistence.mssql.repository;

import com.exaucet.joblessito.persistence.mssql.entity.JobSeekerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IJobSeekerRepository extends JpaRepository<JobSeekerEntity, String> {
}
