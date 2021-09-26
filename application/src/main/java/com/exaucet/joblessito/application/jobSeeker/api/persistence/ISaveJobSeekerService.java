package com.exaucet.joblessito.application.jobSeeker.api.persistence;

import com.exaucet.joblessito.application.jobSeeker.model.JobSeeker;

import java.util.Optional;

public interface ISaveJobSeekerService {
    Optional<JobSeeker> handle(JobSeeker jobSeeker);
}
